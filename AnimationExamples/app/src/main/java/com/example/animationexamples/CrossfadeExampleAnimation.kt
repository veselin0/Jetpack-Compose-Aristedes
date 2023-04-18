package com.example.animationexamples

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlin.random.Random.Default.nextInt

@Composable
fun CrossfadeExampleAnimation() {

    var myComponentType: CrossfadeComponentType by remember {
        mutableStateOf(CrossfadeComponentType.Text)
    }

    Column(Modifier.fillMaxSize()) {
        Button(onClick = { myComponentType = getComponentTypeRandom() }) {
            Text(text = "Change Component")
        }

        Crossfade(targetState = myComponentType) {
            when (it) {
                CrossfadeComponentType.Image -> Icon(
                    Icons.Default.ShoppingCart,
                    contentDescription = "icon Shopping cart"
                )
                CrossfadeComponentType.Text -> Text(text = "SOY UN COMPONENTE")
                CrossfadeComponentType.Box -> Box(
                    modifier = Modifier
                        .size(150.dp)
                        .background(Color.Red)
                )
                CrossfadeComponentType.Error -> Text(text = "ERROOOORRR!")
            }
        }


    }


}

fun getComponentTypeRandom(): CrossfadeComponentType {

    return when(nextInt(from = 0, until = 3)) {
        0 -> CrossfadeComponentType.Image
        1 -> CrossfadeComponentType.Text
        2 -> CrossfadeComponentType.Box
        else -> CrossfadeComponentType.Error
    }
}
