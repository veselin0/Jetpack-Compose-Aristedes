package com.example.multiplestateshoisting

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.multiplestateshoisting.ui.theme.MultipleStatesHoistingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MultipleStatesHoistingTheme {
                val myOptions = getOptions(listOf("Gocho", "Bocho", "Mocho"))
                Column() {
                    myOptions.forEach {
                        MyCheckboxWithTextComplete(it)
                    }
                }
            }
        }
    }
}

data class CheckInfo(
    val title: String,
    var selected: Boolean = false,
    var onCheckedChange: (Boolean) -> Unit
)

@Composable
fun getOptions(titles: List<String>): List<CheckInfo> {
    return titles.map {
        var status by rememberSaveable {
            mutableStateOf(false)
        }
        CheckInfo(
            title = it,
            selected = status,
            onCheckedChange = { myNewStatus -> status = myNewStatus }
        )
    }
}

@Composable
fun MyCheckboxWithTextComplete(checkInfo: CheckInfo) {
    Row {
        Checkbox(
            checked = checkInfo.selected,
            onCheckedChange = { checkInfo.onCheckedChange(!checkInfo.selected) })
        Spacer(modifier = Modifier.width(2.dp))
        Text(text = checkInfo.title, Modifier.padding(12.dp))
    }

}


//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    MultipleStatesHoistingTheme {
//        MyCheckboxWithTextComplete()
//    }
//}