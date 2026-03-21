package com.example.ejercicio2

fun main() {
    val cal = Calculadora(
        marca = "Apple",
        aniosDeVida = 5,
        precio = 25.99
    )
    println("--Calculadora ${cal.marca} ---")
    println("Años de vida: ${cal.aniosDeVida}")
    println("Precio: \$${cal.precio}")

    println("\n---Operaciones---")
    println("10 + 5 = ${cal.sumar(10.0,5.0)}" )
    println("10 - 5 = ${cal.restar(10.0,5.0)}" )
    println("10 * 5 = ${cal.multiplicar(10.0,5.0)}" )
    println("10 / 5 = ${cal.dividir(10.0,5.0)}" )

}