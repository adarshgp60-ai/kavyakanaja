package com.kavyakanaja.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

/**
 * Domain model for a Kannada Poem
 */
@Entity(tableName = "poems")
data class Poem(
    @PrimaryKey
    val id: String = UUID.randomUUID().toString(),
    val title: String,
    val poetId: String,
    val content: String,
    val category: String,
    val meaning: String,
    val audioUrl: String? = null,
    val imageUrl: String? = null,
    val dateAdded: Long = System.currentTimeMillis(),
    val difficultyLevel: Int = 1, // 1-5 scale
    val isBookmarked: Boolean = false,
    val isDownloaded: Boolean = false
)

/**
 * Domain model for a Poet
 */
@Entity(tableName = "poets")
data class Poet(
    @PrimaryKey
    val id: String = UUID.randomUUID().toString(),
    val name: String,
    val biography: String,
    val imageUrl: String? = null,
    val awards: String = "",
    val era: String = "", // e.g., "Medieval", "Renaissance", "Modern"
    val jnanpithInfo: String = "",
    val influence: String = ""
)

/**
 * Domain model for User's Favorite Poem
 */
@Entity(tableName = "favorites")
data class Favorite(
    @PrimaryKey
    val id: String = UUID.randomUUID().toString(),
    val userId: String,
    val poemId: String,
    val dateAdded: Long = System.currentTimeMillis()
)

/**
 * Domain model for Reading History
 */
@Entity(tableName = "history")
data class ReadingHistory(
    @PrimaryKey
    val id: String = UUID.randomUUID().toString(),
    val userId: String,
    val poemId: String,
    val lastRead: Long = System.currentTimeMillis(),
    val readCount: Int = 1
)

/**
 * Domain model for User Profile
 */
data class UserProfile(
    val userId: String,
    val name: String,
    val email: String,
    val profileImageUrl: String? = null,
    val readingStreak: Int = 0,
    val poemsCompleted: Int = 0,
    val listeningHours: Float = 0f,
    val joinedDate: Long = System.currentTimeMillis()
)

/**
 * Combined model for Poem with Poet details
 */
data class PoemWithPoet(
    val poem: Poem,
    val poet: Poet
)
