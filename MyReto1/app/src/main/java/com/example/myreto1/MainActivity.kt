package com.example.myreto1

import android.graphics.drawable.shapes.Shape
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myreto1.ui.theme.MyReto1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyReto1Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Row(modifier = Modifier.padding(16.dp)) {
                        RoundImage()
                        Column(modifier = Modifier.fillMaxSize()) {
//                            RowOfTexts()
                            Spacer(modifier = Modifier.size(20.dp))
//                            RowOfTexts()
                            BonJoviImage()
                        }
                    }

                }
            }
        }
    }
}

@Composable
fun RoundImage() {
    Image(
        painter = painterResource(id = R.drawable.kitten_38),
        contentDescription = "kitten",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .clip(CircleShape)
            .size(60.dp)
    )
}

@Composable
fun RowOfTexts() {
    Row(
        Modifier
            .fillMaxSize()
            .padding(start = 16.dp)
    ) {
        Text(text = "Bon Jovi", modifier = Modifier.weight(1f))
        Text(text = "@BonJovi", modifier = Modifier.weight(1f))
        Text(text = "Date", modifier = Modifier.weight(1f))
    }
}

@Composable
fun BonJoviImage() {
    Image(
        painter = painterResource(id = R.drawable.bon_jovi),
        contentDescription = "image of Bon JOvi",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(100.dp)
            .clip(RectangleShape)
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyReto1Theme {
        RoundImage()
    }
}