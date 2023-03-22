package com.example.jetpackcomponentscatalog.model

sealed class Routes(val route: String) {
    object View1 : Routes("screen1")
    object View2 : Routes("screen2")
    object View3 : Routes("screen3")
}