package com.kavyakanaja.data.repository

import com.kavyakanaja.data.database.FavoriteDao
import com.kavyakanaja.data.database.PoemDao
import com.kavyakanaja.data.database.PoetDao
import com.kavyakanaja.data.database.ReadingHistoryDao
import com.kavyakanaja.domain.model.Favorite
import com.kavyakanaja.domain.model.Poem
import com.kavyakanaja.domain.model.Poet
import com.kavyakanaja.domain.model.ReadingHistory
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Repository for Poem operations
 * Implements repository pattern for clean separation of concerns
 */
interface IPoemRepository {
    suspend fun insertPoem(poem: Poem)
    suspend fun insertPoems(poems: List<Poem>)
    suspend fun updatePoem(poem: Poem)
    suspend fun deletePoem(poem: Poem)
    suspend fun getPoemById(poemId: String): Poem?
    fun getPoemByIdFlow(poemId: String): Flow<Poem?>
    fun getAllPoems(): Flow<List<Poem>>
    fun getPoemsByCategory(category: String): Flow<List<Poem>>
    fun getPoemsByPoet(poetId: String): Flow<List<Poem>>
    suspend fun getPoemOfDay(): Poem?
}

class PoemRepository @Inject constructor(
    private val poemDao: PoemDao
) : IPoemRepository {
    override suspend fun insertPoem(poem: Poem) {
        poemDao.insertPoem(poem)
    }

    override suspend fun insertPoems(poems: List<Poem>) {
        poemDao.insertPoems(poems)
    }

    override suspend fun updatePoem(poem: Poem) {
        poemDao.updatePoem(poem)
    }

    override suspend fun deletePoem(poem: Poem) {
        poemDao.deletePoem(poem)
    }

    override suspend fun getPoemById(poemId: String): Poem? {
        return poemDao.getPoemById(poemId)
    }

    override fun getPoemByIdFlow(poemId: String): Flow<Poem?> {
        return poemDao.getPoemByIdFlow(poemId)
    }

    override fun getAllPoems(): Flow<List<Poem>> {
        return poemDao.getAllPoems()
    }

    override fun getPoemsByCategory(category: String): Flow<List<Poem>> {
        return poemDao.getPoemsByCategory(category)
    }

    override fun getPoemsByPoet(poetId: String): Flow<List<Poem>> {
        return poemDao.getPoemsByPoet(poetId)
    }

    override suspend fun getPoemOfDay(): Poem? {
        return poemDao.getPoemOfDay()
    }
}

/**
 * Repository for Poet operations
 */
interface IPoetRepository {
    suspend fun insertPoet(poet: Poet)
    suspend fun insertPoets(poets: List<Poet>)
    suspend fun getPoetById(poetId: String): Poet?
    fun getPoetByIdFlow(poetId: String): Flow<Poet?>
    fun getAllPoets(): Flow<List<Poet>>
    fun getPoetsByEra(era: String): Flow<List<Poet>>
    fun searchPoets(query: String): Flow<List<Poet>>
}

class PoetRepository @Inject constructor(
    private val poetDao: PoetDao
) : IPoetRepository {
    override suspend fun insertPoet(poet: Poet) {
        poetDao.insertPoet(poet)
    }

    override suspend fun insertPoets(poets: List<Poet>) {
        poetDao.insertPoets(poets)
    }

    override suspend fun getPoetById(poetId: String): Poet? {
        return poetDao.getPoetById(poetId)
    }

    override fun getPoetByIdFlow(poetId: String): Flow<Poet?> {
        return poetDao.getPoetByIdFlow(poetId)
    }

    override fun getAllPoets(): Flow<List<Poet>> {
        return poetDao.getAllPoets()
    }

    override fun getPoetsByEra(era: String): Flow<List<Poet>> {
        return poetDao.getPoetsByEra(era)
    }

    override fun searchPoets(query: String): Flow<List<Poet>> {
        return poetDao.searchPoets("%$query%")
    }
}

/**
 * Repository for Favorite operations
 */
interface IFavoriteRepository {
    suspend fun addFavorite(favorite: Favorite)
    suspend fun removeFavorite(userId: String, poemId: String)
    fun getUserFavorites(userId: String): Flow<List<Favorite>>
    suspend fun isFavorite(userId: String, poemId: String): Boolean
}

class FavoriteRepository @Inject constructor(
    private val favoriteDao: FavoriteDao
) : IFavoriteRepository {
    override suspend fun addFavorite(favorite: Favorite) {
        favoriteDao.addFavorite(favorite)
    }

    override suspend fun removeFavorite(userId: String, poemId: String) {
        favoriteDao.removeFavoriteByIds(userId, poemId)
    }

    override fun getUserFavorites(userId: String): Flow<List<Favorite>> {
        return favoriteDao.getUserFavorites(userId)
    }

    override suspend fun isFavorite(userId: String, poemId: String): Boolean {
        return favoriteDao.isFavorite(userId, poemId)
    }
}

/**
 * Repository for Reading History operations
 */
interface IReadingHistoryRepository {
    suspend fun addHistory(history: ReadingHistory)
    fun getUserHistory(userId: String, limit: Int = 10): Flow<List<ReadingHistory>>
    suspend fun getHistoryEntry(userId: String, poemId: String): ReadingHistory?
    suspend fun clearUserHistory(userId: String)
}

class ReadingHistoryRepository @Inject constructor(
    private val historyDao: ReadingHistoryDao
) : IReadingHistoryRepository {
    override suspend fun addHistory(history: ReadingHistory) {
        historyDao.addHistory(history)
    }

    override fun getUserHistory(userId: String, limit: Int): Flow<List<ReadingHistory>> {
        return historyDao.getUserHistory(userId, limit)
    }

    override suspend fun getHistoryEntry(userId: String, poemId: String): ReadingHistory? {
        return historyDao.getHistoryEntry(userId, poemId)
    }

    override suspend fun clearUserHistory(userId: String) {
        historyDao.clearUserHistory(userId)
    }
}
