package com.example.youtubedownloader.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

@Composable
fun InitialScreen(onFinishLoading: () -> Unit) {
    // Simulate loading for 2 seconds
    var progress by remember { mutableStateOf(0f) }
    LaunchedEffect(Unit) {
        repeat(100) {
            delay(15)
            progress += 0.01f
        }
        onFinishLoading()
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "YouTube Downloader",
                style = MaterialTheme.typography.headlineLarge
            )
            Spacer(modifier = Modifier.height(36.dp))
            LinearProgressIndicator(
                progress = progress,
                modifier = Modifier
                    .width(200.dp)
                    .height(8.dp)
            )
        }
    }
}