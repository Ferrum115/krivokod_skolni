package com.example.youtubedownloader

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import com.example.youtubedownloader.screens.InitialScreen
import com.example.youtubedownloader.screens.MainScreen
import com.example.youtubedownloader.screens.SettingsScreen
import com.example.youtubedownloader.ui.theme.YouTubeDownloaderTheme
import com.example.youtubedownloader.ui.TopBar

enum class AppScreen {
    Initial, Main, Settings
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var currentScreen by remember { mutableStateOf(AppScreen.Initial) }
            var isDarkTheme by remember { mutableStateOf(false) }
            var language by remember { mutableStateOf("English") }

            YouTubeDownloaderTheme(darkTheme = isDarkTheme) {
                when (currentScreen) {
                    AppScreen.Initial -> InitialScreen(
                        onFinishLoading = { currentScreen = AppScreen.Main }
                    )
                    else -> {
                        TopBar(
                            currentScreen = currentScreen,
                            onScreenChange = { currentScreen = it }
                        )
                        when (currentScreen) {
                            AppScreen.Main -> MainScreen()
                            AppScreen.Settings -> SettingsScreen(
                                isDarkTheme = isDarkTheme,
                                onThemeChange = { isDarkTheme = it },
                                language = language,
                                onLanguageChange = { language = it }
                            )
                            else -> {}
                        }
                    }
                }
            }
        }
    }
}