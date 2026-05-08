package com.kavyakanaja.utils

/**
 * Constants for the Kavya-Kanaja application
 */
object Constants {
    // API Configuration (for future use)
    const val BASE_URL = "https://api.kavyakanaja.com/v1/"
    const val CONNECTION_TIMEOUT = 30L  // seconds
    const val READ_TIMEOUT = 30L        // seconds

    // Database
    const val DATABASE_NAME = "kavyakanaja_db"

    // Categories
    val POEM_CATEGORIES = listOf(
        "Bhakti",
        "Nature",
        "Love",
        "Philosophy",
        "Patriotism",
        "Classical Kannada"
    )

    // Difficulty Levels
    const val DIFFICULTY_EASY = 1
    const val DIFFICULTY_MEDIUM = 2
    const val DIFFICULTY_HARD = 3
    const val DIFFICULTY_VERY_HARD = 4
    const val DIFFICULTY_EXPERT = 5

    // UI
    const val POEM_LINE_HEIGHT = 1.6f
    const val DEFAULT_ANIMATION_DURATION = 300  // ms
    const val SPLASH_SCREEN_DURATION = 2000     // ms

    // Pagination
    const val PAGE_SIZE = 20

    // User defaults
    const val DEFAULT_USER_ID = "guest_user"
}
