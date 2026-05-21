package com.pdm0126.labo4.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.pdm0126.labo4.screens.GreetingScreen.TaskListScreen
import com.pdm0126.labo4.screens.Home.Home

@Composable
fun AppNavigation() {
    val backStack = rememberNavBackStack(Routes.Home)

    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryProvider = entryProvider {
            entry<Routes.Home> {
                Home (
                    onNavigationToTask = { backStack.add(Routes.TaskList) }
                )
            }
            entry<Routes.TaskList> {
                TaskListScreen(
                    onBack = { backStack.removeLastOrNull() }
                )
            }
        }
    )
}