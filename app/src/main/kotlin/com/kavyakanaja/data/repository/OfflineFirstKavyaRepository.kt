package com.kavyakanaja.data.repository

import com.kavyakanaja.data.SampleData
import com.kavyakanaja.data.database.FavoriteDao
import com.kavyakanaja.data.database.PoemDao
import com.kavyakanaja.data.database.PoetDao
import com.kavyakanaja.data.database.ReadingHistoryDao
import com.kavyakanaja.domain.model.Favorite
import com.kavyakanaja.domain.model.Poem
import com.kavyakanaja.domain.model.Poet
import com.kavyakanaja.domain.model.ReadingHistory
import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.coroutines.flow.Flow

@Singleton
class OfflineFirstKavyaRepository @Inject constructor(
    private val poemDao: PoemDao,
    private val poetDao: PoetDao,
    private val favoriteDao: FavoriteDao,
    private val historyDao: ReadingHistoryDao
) : KavyaRepository {
    override fun poems(): Flow<List<Poem>> = poemDao.getAllPoems()
    override fun poets(): Flow<List<Poet>> = poetDao.getAllPoets()
    override fun favorites(userId: String): Flow<List<Favorite>> = favoriteDao.getUserFavorites(userId)
    override fun poem(poemId: String): Flow<Poem?> = poemDao.getPoemByIdFlow(poemId)
    override fun poet(poetId: String): Flow<Poet?> = poetDao.getPoetByIdFlow(poetId)
    override fun poemsByCategory(category: String): Flow<List<Poem>> = poemDao.getPoemsByCategory(category)
    override fun searchPoets(query: String): Flow<List<Poet>> = poetDao.searchPoets("%$query%")

    override suspend fun seedIfEmpty() {
        if (poetDao.getPoetsCount() == 0) poetDao.insertPoets(SampleData.poets)
        if (poemDao.getPoemsCount() == 0) poemDao.insertPoems(SampleData.poems)
    }

    override suspend fun poemOfDay(): Poem? = poemDao.getPoemOfDay()

    override suspend fun addHistory(userId: String, poemId: String) {
        historyDao.addHistory(ReadingHistory(userId = userId, poemId = poemId))
    }

    override suspend fun toggleFavorite(userId: String, poemId: String) {
        if (favoriteDao.isFavorite(userId, poemId)) {
            favoriteDao.removeFavoriteByIds(userId, poemId)
        } else {
            favoriteDao.addFavorite(Favorite(userId = userId, poemId = poemId))
        }
    }

    override suspend fun isFavorite(userId: String, poemId: String): Boolean =
        favoriteDao.isFavorite(userId, poemId)
}
