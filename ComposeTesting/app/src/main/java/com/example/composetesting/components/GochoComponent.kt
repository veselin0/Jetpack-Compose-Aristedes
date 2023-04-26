package com.example.composetesting.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag

@Composable
fun GochoComponent() {
    Column(Modifier.fillMaxSize()) {
        Text(text = "GOCHO", Modifier.testTag("component1"))
        Text(text = "GOCHO", Modifier.testTag("component2"))
        
        Image(Icons.Default.Add, contentDescription = "superImage")

    }
}