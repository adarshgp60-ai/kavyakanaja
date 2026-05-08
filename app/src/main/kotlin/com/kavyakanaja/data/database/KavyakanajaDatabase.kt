package com.kavyakanaja.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.kavyakanaja.domain.model.Favorite
import com.kavyakanaja.domain.model.Poem
import com.kavyakanaja.domain.model.Poet
import com.kavyakanaja.domain.model.ReadingHistory

/**
 * Room database for Kavya-Kanaja
 */
@Database(
    entities = [
        Poem::class,
        Poet::class,
        Favorite::class,
        ReadingHistory::class
    ],
    version = 1,
    exportSchema = false
)
abstract class KavyakanajaDatabase : RoomDatabase() {
    abstract fun poemDao(): PoemDao
    abstract fun poetDao(): PoetDao
    abstract fun favoriteDao(): FavoriteDao
    abstract fun readingHistoryDao(): ReadingHistoryDao
}
