package com.example.animationexamples

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ColorAnimationSimple() {
    Column() {
        var primaryColor by rememberSaveable {
            mutableStateOf(false)
        }
        var currentColor1 = if (primaryColor) Color.Red else Color.Yellow
        Box(modifier = Modifier
            .size(100.dp)
            .background(currentColor1)
            .clickable { primaryColor = !primaryColor })
        Spacer(modifier = Modifier.size(200.dp))
        var secondaryColor by rememberSaveable {
            mutableStateOf(false)
        }
        val currentColor2 by animateColorAsState(targetValue = if (secondaryColor) Color.Red else Color.Yellow)
        Box(modifier = Modifier
            .size(100.dp)
            .background(currentColor2)
            .clickable { secondaryColor = !secondaryColor })
    }

}