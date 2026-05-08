package com.kavyakanaja.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFFD9A06F),
    onPrimary = Color(0xFF202124),
    primaryContainer = Color(0xFF4A3426),
    onPrimaryContainer = Color(0xFFF1ECE2),
    secondary = Color(0xFFAAB6C4),
    onSecondary = Color(0xFFFFFFFF),
    secondaryContainer = Color(0xFF252F3C),
    onSecondaryContainer = Color(0xFFE8E5DE),
    tertiary = Color(0xFF9CB2A7),
    onTertiary = Color(0xFF111315),
    tertiaryContainer = Color(0xFF24322D),
    onTertiaryContainer = Color(0xFFE8E5DE),
    error = Color(0xFFB3261E),
    onError = Color(0xFFFFFFFF),
    errorContainer = Color(0xFFF9DEDC),
    onErrorContainer = Color(0xFF410E0B),
    background = Color(0xFF111315),
    onBackground = Color(0xFFFFFFFF),
    surface = Color(0xFF1B1D1F),
    onSurface = Color(0xFFFFFFFF),
    surfaceVariant = Color(0xFF25282B),
    onSurfaceVariant = Color(0xFFD5D1C8),
    outline = Color(0xFF74787C),
    outlineVariant = Color(0xFF34383B),
    scrim = Color(0xFF000000)
)

private val LightColorScheme = lightColorScheme(
    primary = Color(0xFFB86F38),
    onPrimary = Color(0xFFFFFFFF),
    primaryContainer = Color(0xFFE8D2BE),
    onPrimaryContainer = Color(0xFF3B2416),
    secondary = Color(0xFF364A63),
    onSecondary = Color(0xFFFFFFFF),
    secondaryContainer = Color(0xFFDDE3EA),
    onSecondaryContainer = Color(0xFF202B38),
    tertiary = Color(0xFF5D7469),
    onTertiary = Color(0xFFFFFFFF),
    tertiaryContainer = Color(0xFFDDE7E1),
    onTertiaryContainer = Color(0xFF25332D),
    error = Color(0xFFB3261E),
    onError = Color(0xFFFFFFFF),
    errorContainer = Color(0xFFF9DEDC),
    onErrorContainer = Color(0xFF410E0B),
    background = Color(0xFFFAF7F0),
    onBackground = Color(0xFF202124),
    surface = Color(0xFFF1ECE2),
    onSurface = Color(0xFF202124),
    surfaceVariant = Color(0xFFE8E5DE),
    onSurfaceVariant = Color(0xFF55504A),
    outline = Color(0xFF9B948A),
    outlineVariant = Color(0xFFD5D1C8),
    scrim = Color(0xFF000000)
)

/**
 * Kavya-Kanaja Material Design 3 Theme
 */
@Composable
fun KavyaKanajaTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = KavyaKanajaTypography,
        content = content
    )
}
