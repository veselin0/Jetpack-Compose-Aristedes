package com.example.jetpackcomponentscatalog

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.jetpackcomponentscatalog.ui.theme.JetpackComponentsCatalogTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComponentsCatalogTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MyText()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComponentsCatalogTheme {
        MyText()
    }
}

@Composable
fun MyText() {
    Column(Modifier.fillMaxSize()) {
        Text(text = "This is an Example")
        Text(text = "This is an Example", color = Color.Blue)
        Text(text = "This is an Example", fontWeight = FontWeight.ExtraBold)
        Text(text = "This is an Example", fontWeight = FontWeight.Light)
        Text(text = "This is an Example", style = TextStyle(fontFamily = FontFamily.Cursive))
        Text(
            text = "This is an Example",
            style = TextStyle(textDecoration = TextDecoration.LineThrough)
        )
        Text(
            text = "This is an Example",
            style = TextStyle(textDecoration = TextDecoration.Underline)
        )
        Text(
            text = "This is an Example",
            style = TextStyle(
                textDecoration = TextDecoration.combine(
                    listOf(TextDecoration.LineThrough, TextDecoration.Underline)
                )
            )
        )
        Text(text = "This is an Example", fontSize = 30.sp)
    }

}