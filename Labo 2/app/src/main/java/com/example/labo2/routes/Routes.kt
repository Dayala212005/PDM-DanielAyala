package com.example.labo2.routes

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

sealed class Routes: NavKey {
    @Serializable
    data object Home: Routes()
    @Serializable
    data object Lista: Routes()
    @Serializable
    data object Sensor: Routes()

}