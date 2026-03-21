package com.example.ejercicio3

fun main() {
    val Ciclo01 = listOf(
        Estudiante("Daniel","00045824","PDM"),
        Estudiante("Pepito","000748384","PDM"),
        Estudiante("Juanito","00327382","PDM"),
        Estudiante("Chepito","00001213","PDM"),

        Estudiante("Daniel","00045824","AN"),
        Estudiante("Pepito","000748384","AN"),
        Estudiante("Juanito","00327382","AN"),
        Estudiante("Chepito","00001213","AN")
    )

    println("--Estudiantes en Dispositivos Moviles--")
    val dispositivosMoviles = Ciclo01.filter { it.asignatura == "PDM" }

    dispositivosMoviles.forEach {
        println("Nombre: ${it.nombre} | Carnet: ${it.carnet}" )
    }

    println("\nTotal: ${dispositivosMoviles.size} estudiantes")
}