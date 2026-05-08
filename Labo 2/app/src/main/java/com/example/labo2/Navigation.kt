package com.example.labo2

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.example.labo2.routes.Routes
import com.example.labo2.screen.LightSensor
import com.example.labo2.screen.Home
import com.example.labo2.screen.ListaApp

@RequiresApi(Build.VERSION_CODES.VANILLA_ICE_CREAM)
@Composable
fun Navigation() {
    val backStack = rememberNavBackStack(Routes.Home)

    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLast() },
        entryProvider = entryProvider {
            entry<Routes.Home> {
                Home(
                    onListaClick = { backStack.add(Routes.Lista) },
                    onSensorClick = { backStack.add(Routes.Sensor) }
                )
            }
            entry<Routes.Lista> {
                ListaApp(onBack = { backStack.removeLast() })
            }
            entry<Routes.Sensor> {
                LightSensor(onBack = { backStack.removeLast() })
            }
        }
    )
}