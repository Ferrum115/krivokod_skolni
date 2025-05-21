package com.example.youtubedownloader.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.youtubedownloader.ui.DropdownMenuBox
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.OutlinedTextField
import androidx.compose.foundation.background
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MainScreen()
}

@Composable
fun MainScreen() {
    var videoLink by remember { mutableStateOf("") }
    var selectedFormat by remember { mutableStateOf("mp4") }
    var selectedQuality by remember { mutableStateOf("1080p") }

    val formatOptions = listOf("mp4", "mp3")
    val qualityOptions = listOf("1080p", "720p", "480p")

    Column(
        modifier = Modifier
            .fillMaxSize()
//            .background(MaterialTheme.colorScheme.background)
            .padding(24.dp),
        verticalArrangement = Arrangement.Top
    ) {
        Spacer(modifier = Modifier.height(64.dp))
        Text("Main Menu", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = videoLink,
            onValueChange = { videoLink = it },
            label = { Text("YouTube Link") },
            modifier = Modifier.fillMaxWidth(),
        )
        Spacer(modifier = Modifier.height(20.dp))

        Text(text = "Format:")
        DropdownMenuBox(
            items = formatOptions,
            selectedItem = selectedFormat,
            onItemSelected = { selectedFormat = it }
        )

        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Quality:")
        DropdownMenuBox(
            items = qualityOptions,
            selectedItem = selectedQuality,
            onItemSelected = { selectedQuality = it }
        )

        Spacer(modifier = Modifier.height(20.dp))
        Button(
            onClick = {
                // TODO: Implement video download logic
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Download")
        }
    }
}
