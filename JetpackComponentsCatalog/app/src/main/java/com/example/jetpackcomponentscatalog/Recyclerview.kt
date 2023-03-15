package com.example.jetpackcomponentscatalog

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun SimpleRecyclerView() {
    val myList = listOf("Gocho", "Bocho", "Docho", "Mocho")
    LazyColumn {
        item { Text(text = "Header") }
        items(myList) {
            Text(text = "Holi, me llamo $it!")
        }
        item { Text(text = "Footer") }
    }
}