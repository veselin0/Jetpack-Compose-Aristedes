package com.example.animationexamples

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun VisibilityAnimationAdvanced() {
    var isVisible by remember { mutableStateOf(true) }
    Column(Modifier.fillMaxSize()) {
        Button(onClick = { isVisible = !isVisible }) {
            Text(text = "Show/Hide")
        }
        Spacer(modifier = Modifier.size(50.dp))

        AnimatedVisibility(
            isVisible,
            enter = slideInHorizontally(),
            exit = slideOutHorizontally()
        ) {
            Box(
                modifier = Modifier
                    .size(150.dp)
                    .background(Color.Red)
            )
        }
    }
}