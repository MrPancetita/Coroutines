package net.iessochoa.sergiocontreras.coroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.random.Random

/**
 * Project: Coroutines
 * From: net.iessochoa.sergiocontreras.coroutines
 * Created by: Contr
 * On: 15/10/2025 at 22:11
 * Creado en Settings -> Editor -> File and Code Templates
 */

fun main() {
    newTopic("Coroutines")
    println("time: ${someTime()}")
    //Esto es solo para pruebas never in prod
    runBlocking {
        println("Delay: ${delayRandom()}")
    }
}

suspend fun delayRandom() {
    delay(someTime())
}

fun someTime(): Long = Random.nextLong(500, 2000)

fun newTopic(topic: String) {
    val separator = "=".repeat(20)
    println("\n $separator $topic $separator")
}