package com.kavyakanaja.utils

import androidx.compose.material3.SnackbarDuration

/**
 * Extension functions for common operations
 */

/**
 * Format timestamp to readable date
 */
fun Long.formatDate(): String {
    val sdf = java.text.SimpleDateFormat("dd MMM yyyy", java.util.Locale("kn", "IN"))
    return sdf.format(java.util.Date(this))
}

/**
 * Format seconds to HH:MM:SS
 */
fun Long.formatTime(): String {
    val hours = this / 3600
    val minutes = (this % 3600) / 60
    val seconds = this % 60
    return String.format("%02d:%02d:%02d", hours, minutes, seconds)
}

/**
 * Capitalize first letter
 */
fun String.capitalizeWords(): String {
    return this.split(" ").joinToString(" ") { word ->
        word.replaceFirstChar { if (it.isLowerCase()) it.titlecase() else it.toString() }
    }
}

/**
 * Truncate text to specified length
 */
fun String.truncate(maxLength: Int): String {
    return if (this.length > maxLength) {
        this.substring(0, maxLength) + "..."
    } else {
        this
    }
}
