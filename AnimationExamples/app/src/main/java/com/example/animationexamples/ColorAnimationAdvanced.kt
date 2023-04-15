package com.example.animationexamples

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ColorAnimationAdvanced() {
    var primaryColor by rememberSaveable {
        mutableStateOf(false)
    }
    var showBox by rememberSaveable {
        mutableStateOf(true)
    }
    val currentColor by animateColorAsState(
        targetValue = if (primaryColor) Color.Red else Color.Yellow,
        animationSpec = tween(durationMillis = 3000),
        finishedListener = { showBox = false }
    )


    Column {
        Button(onClick = { showBox = true }) {
            Text(text = "Show Box")
        }
        if (showBox) {
            Box(modifier = Modifier
                .size(100.dp)
                .background(currentColor)
                .clickable { primaryColor = !primaryColor })
        }

    }

}

