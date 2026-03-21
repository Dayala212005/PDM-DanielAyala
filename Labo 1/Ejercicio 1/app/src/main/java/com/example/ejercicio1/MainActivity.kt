package com.example.ejercicio1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ejercicio1.models.Computadora
import android.util.Log

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val programas = listOf("Notion 2026","Facebook 2024", "Spotify 2026", "Doulongo 2025")
        val compu = Computadora(
            ram = 16,
            almacenamiento = 256,
            sistemaOperativo = "Linux",
            programasInstalados = programas
        )

        compu.encender()

        Log.d("PRUEBA", "--Datos iniciales--")
        Log.d("Prueba", "RAM: ${compu.ram} GB")
        Log.d("PRUEBA", "Almacenamiento: ${compu.almacenamiento} GB")
        Log.d("PRUEBA", "SO ${compu.sistemaOperativo}")
        Log.d("PRUEBA", "Proramas del 2026: ${compu.obtenerProgramas()}")

        compu.actualizar("Ubuntu",32,512)
        Log.d("PRUEBA", "--Datos actualizados--")
        Log.d("Prueba", "RAM: ${compu.ram} GB")
        Log.d("PRUEBA", "Almacenamiento: ${compu.almacenamiento} GB")
        Log.d("PRUEBA", "SO ${compu.sistemaOperativo}")
        Log.d("PRUEBA", "Proramas del 2026: ${compu.obtenerProgramas()}")

        compu.apagar()

    }
}
