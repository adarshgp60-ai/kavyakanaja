package com.kavyakanaja.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kavyakanaja.ai.AiLiteratureClient
import com.kavyakanaja.ai.PoemAnalysis
import com.kavyakanaja.ai.WordMeaning
import com.kavyakanaja.data.local.AppSettings
import com.kavyakanaja.data.local.UserPreferences
import com.kavyakanaja.data.repository.KavyaRepository
import com.kavyakanaja.domain.model.Favorite
import com.kavyakanaja.domain.model.Poem
import com.kavyakanaja.domain.model.Poet
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

data class AppUiState(
    val poems: List<Poem> = emptyList(),
    val poets: List<Poet> = emptyList(),
    val favorites: List<Favorite> = emptyList(),
    val settings: AppSettings = AppSettings(),
    val userName: String = "Guest Reader",
    val selectedWord: WordMeaning? = null,
    val analysis: PoemAnalysis? = null,
    val chatReply: String = "Ask Kavya AI about poems, poets, words, or moods."
)

@HiltViewModel
class AppViewModel @Inject constructor(
    private val repository: KavyaRepository,
    private val preferences: UserPreferences,
    private val aiClient: AiLiteratureClient
) : ViewModel() {
    private val userId = "guest"

    val uiState: StateFlow<AppUiState> = combine(
        repository.poems(),
        repository.poets(),
        repository.favorites(userId),
        preferences.settings
    ) { poems, poets, favorites, settings ->
        AppUiState(poems = poems, poets = poets, favorites = favorites, settings = settings)
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), AppUiState())

    init {
        viewModelScope.launch { repository.seedIfEmpty() }
    }

    fun completeOnboarding() = viewModelScope.launch { preferences.completeOnboarding() }
    fun setDarkMode(enabled: Boolean) = viewModelScope.launch { preferences.setDarkMode(enabled) }
    fun setFontScale(scale: Float) = viewModelScope.launch { preferences.setFontScale(scale) }
    fun toggleFavorite(poemId: String) = viewModelScope.launch { repository.toggleFavorite(userId, poemId) }
    fun markRead(poemId: String) = viewModelScope.launch { repository.addHistory(userId, poemId) }

    fun explainWord(word: String, poem: Poem, update: (WordMeaning) -> Unit) {
        viewModelScope.launch { update(aiClient.explainWord(word, poem)) }
    }

    fun analyze(poem: Poem, update: (PoemAnalysis) -> Unit) {
        viewModelScope.launch { update(aiClient.analyzePoem(poem)) }
    }

    fun chat(message: String, update: (String) -> Unit) {
        viewModelScope.launch { update(aiClient.chat(message)) }
    }
}
