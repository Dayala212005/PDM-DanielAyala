package com.pdm0126.labo4.screens.Home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun Home(
    onNavigationToTask: () -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Box(modifier = Modifier.weight(1f), contentAlignment = androidx.compose.ui.Alignment.Center) {
            Button(onClick = { onNavigationToTask() }) {
                Text(text = "Ir a tareas")
            }
        }
    }
}
