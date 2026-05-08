package com.example.labo2.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun Home (
    onListaClick: () -> Unit,
    onSensorClick: () -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = onListaClick) {
            Text(text = "Lista")
        }
        Button(onClick = onSensorClick) {
            Text(text = "Sensor")
        }
    }
}

@Preview
@Composable
fun HomePreview() {
    Home(onListaClick = {}, onSensorClick = {})
}
