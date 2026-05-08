package com.kavyakanaja.data.local

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.floatPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.dataStore by preferencesDataStore(name = "kavya_user_preferences")

data class AppSettings(
    val onboardingComplete: Boolean = false,
    val darkMode: Boolean = false,
    val fontScale: Float = 1f,
    val language: String = "Kannada + English"
)

@Singleton
class UserPreferences @Inject constructor(
    @ApplicationContext private val context: Context
) {
    private object Keys {
        val Onboarding = booleanPreferencesKey("onboarding_complete")
        val DarkMode = booleanPreferencesKey("dark_mode")
        val FontScale = floatPreferencesKey("font_scale")
        val Language = stringPreferencesKey("language")
    }

    val settings: Flow<AppSettings> = context.dataStore.data.map { preferences ->
        AppSettings(
            onboardingComplete = preferences[Keys.Onboarding] ?: false,
            darkMode = preferences[Keys.DarkMode] ?: false,
            fontScale = preferences[Keys.FontScale] ?: 1f,
            language = preferences[Keys.Language] ?: "Kannada + English"
        )
    }

    suspend fun completeOnboarding() {
        context.dataStore.edit { it[Keys.Onboarding] = true }
    }

    suspend fun setDarkMode(enabled: Boolean) {
        context.dataStore.edit { it[Keys.DarkMode] = enabled }
    }

    suspend fun setFontScale(scale: Float) {
        context.dataStore.edit { it[Keys.FontScale] = scale }
    }
}
