package com.example.youtubedownloader.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.youtubedownloader.AppScreen
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    currentScreen: AppScreen,
    onScreenChange: (AppScreen) -> Unit
) {
    CenterAlignedTopAppBar(
        title = { Text("YouTube Downloader") },
        actions = {
            Row {
                Button(
                    onClick = { onScreenChange(AppScreen.Main) },
                    enabled = currentScreen != AppScreen.Main
                ) {
                    Text("Main")
                }
                Spacer(modifier = Modifier.width(8.dp))
                Button(
                    onClick = { onScreenChange(AppScreen.Settings) },
                    enabled = currentScreen != AppScreen.Settings
                ) {
                    Text("Settings")
                }
            }
        }
    )
}
