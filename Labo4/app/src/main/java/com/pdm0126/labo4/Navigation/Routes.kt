package com.pdm0126.labo4.Navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

sealed class  Routes: NavKey{
    @Serializable
    object Home: Routes()
    @Serializable
    object TaskList: Routes()
}