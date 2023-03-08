package com.example.test_app

import android.os.Bundle
import android.telephony.mbms.MbmsErrors.InitializationErrors
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.test_app.ui.theme.TestAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column(Modifier.fillMaxSize()) {
                        var userInput by remember { mutableStateOf("Write here:") }
                        var enabled by remember { mutableStateOf(true) }
                        UserTextField(userInput) { userInput = it }
                        UserButton(enabled) { enabled = it }
                        UserText(text = userInput)

                    }
                }
            }
        }
    }
}

@Composable
fun UserButton(enabled: Boolean, onPress: (Boolean) -> Unit) {

    Button(
        onClick = { onPress(enabled) },
        enabled = enabled
    ) {
        Text(text = "Click me!")
    }
}

@Composable
fun UserText(text: String) {
    Text(text = text)
}

@Composable
fun UserTextField(text: String, onValueChange: (String) -> Unit) {
    TextField(value = text, onValueChange = { onValueChange(it) })
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TestAppTheme {

    }
}