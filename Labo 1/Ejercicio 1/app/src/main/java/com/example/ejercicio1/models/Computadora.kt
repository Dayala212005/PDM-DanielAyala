package com.example.ejercicio1.models

import android.util.Log


class Computadora(
    val programasInstalados: List<String>,
    var ram: Int,
    var almacenamiento: Int,
    var sistemaOperativo: String ) {

    fun encender() {
        Log.d("PRUEBA","Computadora encendida")
    }
    fun apagar() {
        Log.d("PRUEBA","Computadora apagada")
    }

    fun actualizar(nuevoSO: String,nuevaRam: Int,nuevoAlmacenamiento: Int) {
        sistemaOperativo = nuevoSO
        ram = nuevaRam
        almacenamiento = nuevoAlmacenamiento
        Log.d("PRUEBA", "Computadora actualizada")
    }

    fun obtenerProgramas(): List<String> {
        return programasInstalados.filter { it.contains("2026") }
    }

}