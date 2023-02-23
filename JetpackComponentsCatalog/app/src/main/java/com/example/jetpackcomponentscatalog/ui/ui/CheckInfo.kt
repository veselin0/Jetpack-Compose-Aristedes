package com.example.jetpackcomponentscatalog.ui.ui

data class CheckInfo(
    val title: String,
    var selected: Boolean = false,
    var onCheckedChange: (Boolean) -> Unit
) {

}