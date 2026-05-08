package com.kavyakanaja.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.kavyakanaja.domain.model.Poem
import kotlinx.coroutines.flow.Flow

/**
 * Data Access Object for Poem entity
 */
@Dao
interface PoemDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPoem(poem: Poem)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPoems(poems: List<Poem>)

    @Update
    suspend fun updatePoem(poem: Poem)

    @Delete
    suspend fun deletePoem(poem: Poem)

    @Query("SELECT * FROM poems WHERE id = :poemId")
    suspend fun getPoemById(poemId: String): Poem?

    @Query("SELECT * FROM poems WHERE id = :poemId")
    fun getPoemByIdFlow(poemId: String): Flow<Poem?>

    @Query("SELECT * FROM poems ORDER BY dateAdded DESC")
    fun getAllPoems(): Flow<List<Poem>>

    @Query("SELECT * FROM poems WHERE category = :category")
    fun getPoemsByCategory(category: String): Flow<List<Poem>>

    @Query("SELECT * FROM poems WHERE poetId = :poetId")
    fun getPoemsByPoet(poetId: String): Flow<List<Poem>>

    @Query("SELECT * FROM poems WHERE difficultyLevel = :level")
    fun getPoemsByDifficulty(level: Int): Flow<List<Poem>>

    @Query("SELECT * FROM poems LIMIT 1")
    suspend fun getPoemOfDay(): Poem?

    @Query("SELECT COUNT(*) FROM poems")
    suspend fun getPoemsCount(): Int
}
