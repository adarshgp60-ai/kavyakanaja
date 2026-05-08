package com.kavyakanaja.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.kavyakanaja.domain.model.Favorite
import kotlinx.coroutines.flow.Flow

/**
 * Data Access Object for Favorite entity
 */
@Dao
interface FavoriteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addFavorite(favorite: Favorite)

    @Delete
    suspend fun removeFavorite(favorite: Favorite)

    @Query("SELECT * FROM favorites WHERE userId = :userId")
    fun getUserFavorites(userId: String): Flow<List<Favorite>>

    @Query("SELECT EXISTS(SELECT 1 FROM favorites WHERE userId = :userId AND poemId = :poemId)")
    suspend fun isFavorite(userId: String, poemId: String): Boolean

    @Query("DELETE FROM favorites WHERE userId = :userId AND poemId = :poemId")
    suspend fun removeFavoriteByIds(userId: String, poemId: String)

    @Query("SELECT COUNT(*) FROM favorites WHERE userId = :userId")
    suspend fun getFavoriteCount(userId: String): Int
}
