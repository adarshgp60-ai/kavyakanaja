package com.kavyakanaja

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import androidx.navigation.compose.rememberNavController
import com.kavyakanaja.navigation.AppNavGraph
import com.kavyakanaja.ui.theme.KavyaKanajaTheme
import dagger.hilt.android.AndroidEntryPoint

/**
 * Main Activity for Kavya-Kanaja
 * Entry point of the application
 */
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KavyaKanajaTheme {
                // Set status bar color
                val backgroundColor = MaterialTheme.colorScheme.background
                window.statusBarColor = backgroundColor.toArgb()

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    AppNavGraph(navController = navController)
                }
            }
        }
    }
}
