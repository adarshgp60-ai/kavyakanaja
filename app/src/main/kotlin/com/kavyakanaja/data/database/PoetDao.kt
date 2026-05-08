package com.kavyakanaja.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.kavyakanaja.domain.model.Poet
import kotlinx.coroutines.flow.Flow

/**
 * Data Access Object for Poet entity
 */
@Dao
interface PoetDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPoet(poet: Poet)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPoets(poets: List<Poet>)

    @Update
    suspend fun updatePoet(poet: Poet)

    @Delete
    suspend fun deletePoet(poet: Poet)

    @Query("SELECT * FROM poets WHERE id = :poetId")
    suspend fun getPoetById(poetId: String): Poet?

    @Query("SELECT * FROM poets WHERE id = :poetId")
    fun getPoetByIdFlow(poetId: String): Flow<Poet?>

    @Query("SELECT * FROM poets ORDER BY name ASC")
    fun getAllPoets(): Flow<List<Poet>>

    @Query("SELECT * FROM poets WHERE era = :era")
    fun getPoetsByEra(era: String): Flow<List<Poet>>

    @Query("SELECT * FROM poets WHERE name LIKE :query ORDER BY name ASC")
    fun searchPoets(query: String): Flow<List<Poet>>

    @Query("SELECT COUNT(*) FROM poets")
    suspend fun getPoetsCount(): Int
}
