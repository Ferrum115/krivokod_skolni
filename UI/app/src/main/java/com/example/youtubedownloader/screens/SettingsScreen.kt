@file:Suppress("UNUSED_EXPRESSION")

package com.example.youtubedownloader.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.youtubedownloader.ui.DropdownMenuBox
import androidx.compose.ui.Alignment
import androidx.compose.foundation.background
import androidx.compose.material3.MaterialTheme


@Composable
fun SettingsScreen(
    isDarkTheme: Boolean,
    onThemeChange: (Boolean) -> Unit,
    language: String,
    onLanguageChange: (String) -> Unit
) {
    val languages = listOf("English", "Spanish", "French", "German", "Italian", "Chinese", "Japanese", "Indian", "Russian")

    Column(
        modifier = Modifier
            .fillMaxSize()
//            .background(MaterialTheme.colorScheme.background)
            .padding(24.dp),
        verticalArrangement = Arrangement.Top
    ) {
        Spacer(modifier = Modifier.height(64.dp))

        Text("Settings", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(20.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Theme: ", modifier = Modifier.weight(1f))
            Switch(
                checked = isDarkTheme,
                onCheckedChange = { onThemeChange(it) }
            )
            Text(if (isDarkTheme) "Dark" else "Light")
        }
        Spacer(modifier = Modifier.height(8.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Language:", modifier = Modifier.weight(1f))
            DropdownMenuBox(
                items = languages,
                selectedItem = language,
                onItemSelected = { onLanguageChange(it) }
            )
        }
    }
}