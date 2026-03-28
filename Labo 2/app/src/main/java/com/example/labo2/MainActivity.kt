package com.example.labo2

import android.graphics.drawable.ShapeDrawable
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.labo2.ui.theme.Labo2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Labo2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ListaApp()
                }
            }
        }
    }
}

@Composable
fun ListaApp() {
    val entries = remember { mutableStateListOf<String>() }
    val usuario: MutableState<String> = remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(5.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,

        ) {
        TextField(
                    value = usuario.value,
                    onValueChange = {
                        usuario.value = it },
                        placeholder = {Text("Nombre")},
                        modifier = Modifier.fillMaxWidth()
                )
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = {
                entries.add(usuario.value)
                usuario.value = ""
            }
        ) {
            Text(text = "Guardar")
        }
        Row(
            modifier = Modifier.fillMaxWidth().height(100.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
            ) {
            Box(modifier = Modifier.weight(1f)) {
                Text(text = "Listado de nombres y posicion en la lista",
                    modifier = Modifier.width(200.dp))
            }
            Button(
                modifier = Modifier,
                onClick = {entries.clear()}
            ) {
                Text(text = "Limpiar")
            }
        }
        LazyColumn(modifier = Modifier.border(width = 2.dp, color = Color.Blue, shape = RoundedCornerShape(16.dp))) {
            itemsIndexed(entries.toList()) { index, item ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = item
                    )
                    Text(
                        text = (index + 1).toString()
                    )
                }
            }
        }
        }
}

@Preview(showBackground = true)
@Composable
fun ListaAppPreview() {
    Labo2Theme {
       ListaApp()
    }
}