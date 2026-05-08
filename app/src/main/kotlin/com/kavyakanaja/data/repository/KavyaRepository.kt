package com.kavyakanaja.data.repository

import com.kavyakanaja.domain.model.Favorite
import com.kavyakanaja.domain.model.Poem
import com.kavyakanaja.domain.model.Poet
import com.kavyakanaja.domain.model.ReadingHistory
import kotlinx.coroutines.flow.Flow

interface KavyaRepository {
    fun poems(): Flow<List<Poem>>
    fun poets(): Flow<List<Poet>>
    fun favorites(userId: String): Flow<List<Favorite>>
    fun poem(poemId: String): Flow<Poem?>
    fun poet(poetId: String): Flow<Poet?>
    fun poemsByCategory(category: String): Flow<List<Poem>>
    fun searchPoets(query: String): Flow<List<Poet>>
    suspend fun seedIfEmpty()
    suspend fun poemOfDay(): Poem?
    suspend fun addHistory(userId: String, poemId: String)
    suspend fun toggleFavorite(userId: String, poemId: String)
    suspend fun isFavorite(userId: String, poemId: String): Boolean
}
