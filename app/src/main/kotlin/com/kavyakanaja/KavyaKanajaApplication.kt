package com.kavyakanaja

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * Application class for Kavya-Kanaja
 * Initialized with Hilt for dependency injection
 */
@HiltAndroidApp
class KavyaKanajaApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        // Initialization code can be added here if needed
    }
}
