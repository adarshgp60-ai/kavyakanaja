package com.kavyakanaja.utils

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.dataStore by preferencesDataStore(name = "kavya_kanaja_prefs")

/**
 * DataStore Preferences Manager
 * Handles app preferences like first launch, theme settings, etc.
 */
class PreferencesManager(private val context: Context) {
    companion object {
        private val IS_FIRST_LAUNCH = booleanPreferencesKey("is_first_launch")
        private val IS_DARK_THEME = booleanPreferencesKey("is_dark_theme")
        private val IS_DATA_INITIALIZED = booleanPreferencesKey("is_data_initialized")
    }

    val isFirstLaunch: Flow<Boolean> = context.dataStore.data.map { preferences ->
        preferences[IS_FIRST_LAUNCH] ?: true
    }

    val isDarkTheme: Flow<Boolean> = context.dataStore.data.map { preferences ->
        preferences[IS_DARK_THEME] ?: false
    }

    val isDataInitialized: Flow<Boolean> = context.dataStore.data.map { preferences ->
        preferences[IS_DATA_INITIALIZED] ?: false
    }

    suspend fun setFirstLaunchComplete() {
        context.dataStore.edit { preferences ->
            preferences[IS_FIRST_LAUNCH] = false
        }
    }

    suspend fun setDarkTheme(isDark: Boolean) {
        context.dataStore.edit { preferences ->
            preferences[IS_DARK_THEME] = isDark
        }
    }

    suspend fun setDataInitialized() {
        context.dataStore.edit { preferences ->
            preferences[IS_DATA_INITIALIZED] = true
        }
    }
}
