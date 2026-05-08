package com.kavyakanaja.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.kavyakanaja.domain.model.ReadingHistory
import kotlinx.coroutines.flow.Flow

/**
 * Data Access Object for Reading History entity
 */
@Dao
interface ReadingHistoryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addHistory(history: ReadingHistory)

    @Delete
    suspend fun removeHistory(history: ReadingHistory)

    @Query("SELECT * FROM history WHERE userId = :userId ORDER BY lastRead DESC LIMIT :limit")
    fun getUserHistory(userId: String, limit: Int = 10): Flow<List<ReadingHistory>>

    @Query("SELECT * FROM history WHERE userId = :userId AND poemId = :poemId")
    suspend fun getHistoryEntry(userId: String, poemId: String): ReadingHistory?

    @Query("SELECT COUNT(*) FROM history WHERE userId = :userId")
    suspend fun getHistoryCount(userId: String): Int

    @Query("DELETE FROM history WHERE userId = :userId")
    suspend fun clearUserHistory(userId: String)
}
