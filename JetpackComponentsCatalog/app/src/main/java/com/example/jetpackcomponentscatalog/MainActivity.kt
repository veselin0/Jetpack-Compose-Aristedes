package com.example.jetpackcomponentscatalog

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.rounded.Star
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomponentscatalog.ui.ui.CheckInfo
import com.example.jetpackcomponentscatalog.ui.ui.JetpackComponentsCatalogTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterialApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComponentsCatalogTheme {
                SuperHeroWithSpecialControlsView()
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComponentsCatalogTheme {
        MyDivider()
    }
}

@Composable
fun MyDropdownMenu() {

    var selectedText by rememberSaveable {
        mutableStateOf("")
    }
    var expanded by rememberSaveable {
        mutableStateOf(false)
    }
    val desserts = listOf("Helado", "Chocolate", "Coffeee", "Natillas", "Chilaquiles")

    Column(Modifier.padding(20.dp)) {
        OutlinedTextField(
            value = selectedText,
            onValueChange = { selectedText = it },
            enabled = false,
            readOnly = true,
            modifier = Modifier
                .clickable { expanded = true }
                .fillMaxWidth()
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.fillMaxWidth()
        ) {
            desserts.forEach { dessert ->
                DropdownMenuItem(onClick = {
                    expanded = false
                    selectedText = dessert
                }) {
                    Text(text = dessert)
                }
            }
        }
    }
}

@Composable
fun MyDivider() {
    Divider(
        Modifier
            .fillMaxWidth()
            .padding(16.dp), color = Color.Red
    )
}

@Composable
fun MyBadgeBox() {
    BottomNavigation {
        BottomNavigationItem(
            icon = {
                BadgedBox(badge = {
                    Badge() {
                        val badgeNumber = "800"
                        Text(
                            badgeNumber,
                            modifier = Modifier.semantics {
                                contentDescription = "$badgeNumber new notifications"
                            }
                        )
                    }
                }) {
                    Icon(
                        Icons.Filled.Star,
                        contentDescription = "Star"
                    )
                }
            },
            selected = false,
            onClick = {}
        )
    }

    @Composable
    fun MyCard() {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            elevation = 12.dp,
            shape = MaterialTheme.shapes.small,
            backgroundColor = Color.Red,
            contentColor = Color.Green,
            border = BorderStroke(4.dp, Color.Blue)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = "Gocho")
                Text(text = "Bocho")
                Text(text = "Docho")
            }
        }
    }


    @Composable
    fun MyRadioButton() {
        Row(Modifier.fillMaxSize()) {
            RadioButton(
                selected = false,
                onClick = { /*TODO*/ },
                enabled = false,
                colors = RadioButtonDefaults.colors(
                    selectedColor = Color.Red,
                    unselectedColor = Color.Yellow,
                    disabledColor = Color.Green

                )
            )
            Text(text = "Gocho 1")
        }

    }

    @Composable
    fun MyTriStatusCheckBox() {
        var status by rememberSaveable {
            mutableStateOf(ToggleableState.Off)
        }
        TriStateCheckbox(state = status, onClick = {
            status = when (status) {
                ToggleableState.On -> ToggleableState.Off
                ToggleableState.Off -> ToggleableState.Indeterminate
                ToggleableState.Indeterminate -> ToggleableState.On
            }
        })
    }

    @Composable
    fun getOptions(titles: List<String>): List<CheckInfo> {
        return titles.map {
            var status by rememberSaveable {
                mutableStateOf(false)
            }
            CheckInfo(
                title = it,
                selected = status,
//                        onCheckedChange = { status = it } // it is the iterator (the Boolean from CheckInfo)
                onCheckedChange = { myNewStatus ->
                    status = myNewStatus
                } // another way to do the same
            )
        }
    }

    @Composable
    fun MyCheckboxWithTextCompleted(checkInfo: CheckInfo) {

        Row(Modifier.padding(8.dp)) {
            Checkbox(
                checked = checkInfo.selected,
                onCheckedChange = { checkInfo.onCheckedChange(!checkInfo.selected) })
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = checkInfo.title,
                modifier = Modifier.padding(top = 12.dp)
            )
        }
    }


    @Composable
    fun MyCheckboxWithText() {

        var state by rememberSaveable {
            mutableStateOf(false)
        }

        Row(Modifier.padding(8.dp)) {
            Checkbox(checked = state, onCheckedChange = { state = !state })
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = "Employee 1",
                modifier = Modifier.padding(top = 12.dp)
            )
        }
    }

    @Composable
    fun MyCheckbox() {
        var state by rememberSaveable {
            mutableStateOf(false)
        }

        Checkbox(
            checked = state,
            onCheckedChange = { state = !state },
            enabled = true,
            colors = CheckboxDefaults.colors(
                checkedColor = Color.Red,
                uncheckedColor = Color.Green,
                checkmarkColor = Color.Blue
            )
        )
    }

    @Composable
    fun MySwitch() {
        var state by rememberSaveable {
            mutableStateOf(false)
        }

        Switch(
            checked = state,
            onCheckedChange = { state = !state },
            enabled = false,
            colors = SwitchDefaults.colors(
                uncheckedThumbColor = Color.Red,
                checkedThumbColor = Color.Green,
                uncheckedTrackColor = Color.Magenta,
                checkedTrackColor = Color.Cyan,
                checkedTrackAlpha = 0.1f,
                uncheckedTrackAlpha = 0.1f,
                disabledCheckedTrackColor = Color.Yellow,
                disabledCheckedThumbColor = Color.Yellow,
                disabledUncheckedTrackColor = Color.Yellow,
                disabledUncheckedThumbColor = Color.Yellow
            )
        )
    }

    @Composable
    fun MyProgressBarrAdvanced() {

        var progressStatus by rememberSaveable { mutableStateOf(0f) }

        Column(
            Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CircularProgressIndicator(progress = progressStatus)

            Row(Modifier.fillMaxWidth()) {
                Button(onClick = { progressStatus += 0.1f }) {
                    Text(text = "Increment")
                }

                Button(onClick = { progressStatus -= 0.1f }) {
                    Text(text = "Reduce")
                }
            }

            LinearProgressIndicator(progress = progressStatus)

            Row(Modifier.fillMaxWidth()) {
                Button(onClick = { progressStatus += 0.1f }) {
                    Text(text = "Increment")
                }

                Button(onClick = { progressStatus -= 0.1f }) {
                    Text(text = "Reduce")
                }
            }
        }
    }

    @Composable
    fun MyProgressBar() {

        var showLoading by rememberSaveable { mutableStateOf(false) }

        Column(
            Modifier
                .padding(24.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (showLoading) {
                CircularProgressIndicator(color = Color.Red, strokeWidth = 10.dp)
                LinearProgressIndicator(
                    modifier = Modifier.padding(top = 32.dp),
                    color = Color.Red,
                    backgroundColor = Color.Green
                )
            }
            Button(onClick = { showLoading = !showLoading }) {
                Text(text = "Load Profile")
            }
        }
    }

    @Composable
    fun MyIcon() {
        Icon(
            imageVector = Icons.Rounded.Star,
            contentDescription = "Icon",
            tint = Color.Red
        )
// implementation "androidx.compose.material:material-icons-extended:1.3.1"
//    This library is too large: don't use if not needed

//    Icon(
//        painter = painterResource(id = R.drawable.baseline_star_half_24),
//        contentDescription = null,
//        tint = Color.Green,
//        modifier = Modifier.size(80.dp)
//
//    )
    }

    @Composable
    fun MyImageAdvanced() {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "example",
            modifier = Modifier
                .clip(CircleShape)
                .border(5.dp, Color.Red, CircleShape)
        )
    }

    @Composable
    fun MyImage() {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "example",
            alpha = 0.5f
        )
    }

    @Composable
    fun MyButtonExample() {

        var enabled by rememberSaveable() {
            mutableStateOf(true)
        }

        Column(
            Modifier
                .fillMaxSize()
                .padding(24.dp)
        ) {
            Button(
                onClick = { enabled = false },
                enabled = enabled,
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.Magenta,
                    contentColor = Color.Blue
                ),
                border = BorderStroke(5.dp, Color.Green)
            ) {
                Text(text = "Hello")
            }

            OutlinedButton(
                onClick = { enabled = false },
                enabled = enabled,
                modifier = Modifier.padding(top = 8.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.Magenta,
                    contentColor = Color.Blue,
                    disabledBackgroundColor = Color.Blue,
                    disabledContentColor = Color.Red
                ),
            ) {
                Text(text = "Hello")
            }

            TextButton(onClick = { /*TODO*/ }) {
                Text(text = "Hello")
            }
        }
    }

    @Composable
    fun MyTextFieldOutlined() {
        var myText by remember { mutableStateOf("") }
        OutlinedTextField(
            value = myText,
            onValueChange = { myText = it },
            modifier = Modifier.padding(24.dp),
            label = { Text(text = "Hi there!") },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.Cyan,
                unfocusedBorderColor = Color.Green
            )
        )
    }

    @Composable
    fun MyTextFieldAdvanced() {
        var myText by remember { mutableStateOf("") }

        TextField(
            value = myText,
            onValueChange = {
                myText =
                    if (it.contains("a")) {
                        it.replace("a", "")
                    } else {
                        it
                    }
            },
            label = { Text(text = "Insert your name") })
    }

    @Composable
    fun MyTextField(name: String, onValueChanged: (String) -> Unit) {

        TextField(value = name, onValueChange = { onValueChanged(it) })
    }

    @Composable
    fun MyText() {
        Column(Modifier.fillMaxSize()) {
            Text(text = "This is an Example")
            Text(text = "This is an Example", color = Color.Blue)
            Text(text = "This is an Example", fontWeight = FontWeight.ExtraBold)
            Text(text = "This is an Example", fontWeight = FontWeight.Light)
            Text(
                text = "This is an Example",
                style = TextStyle(fontFamily = FontFamily.Cursive)
            )
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
}


@Composable
fun MyRadioButtonList(name: String, onItemSelected: (String) -> Unit) {

    Column(Modifier.fillMaxWidth()) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = name == "Gocho",
                onClick = { onItemSelected("Gocho") },
            )
            Text(text = "Gocho")
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = name == "Bocho",
                onClick = { onItemSelected("Bocho") },
            )
            Text(text = "Bocho")
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = name == "Docho",
                onClick = { onItemSelected("Docho") },
            )
            Text(text = "Docho")
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = name == "Mocho",
                onClick = { onItemSelected("Mocho") },
            )
            Text(text = "Mocho")
        }
    }
}