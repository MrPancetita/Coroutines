package net.iessochoa.sergiocontreras.coroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.random.Random

/**
 * Project: Coroutines
 * From: net.iessochoa.sergiocontreras.coroutines
 * Created by: Contr
 * On: 15/10/2025 at 22:11
 * Creado en Settings -> Editor -> File and Code Templates
 */

// Corutinas es mucho más rápido que Thread.

val limit = 10_000

fun main() {
    //threads()
    //coroutines()
    job()

}

fun job() {
    newTopic("job")
    runBlocking {
        val time = someTime()
        val job = launch {
            println("Inicia proceso...")
            delay(time)
            println("Finaliza proceso...")
        }

        println("isActive: ${job.isActive}")
        println("isCancelled: ${job.isCancelled}")
        println("isCompleted: ${job.isCompleted}")

        job.cancel()
        delay(time * 2)
        println("isActive: ${job.isActive}")
        println("isCancelled: ${job.isCancelled}")
        println("isCompleted: ${job.isCompleted}")

    }
}

fun threads() {
    newTopic("Threads")
    val start = System.currentTimeMillis()
    (1..limit).forEach {
        Thread {
            print("*")
            if (it == limit) {
                val timeSpent = (System.currentTimeMillis() - start)
                println("\nTime Threads: $timeSpent milisegundos")
            }
            Thread.sleep(someTime())
        }.start()
    }
}
fun coroutines() {
    newTopic("Coroutines")
    val start = System.currentTimeMillis()
    runBlocking {
        (1..limit).forEach {
            launch {
                print("*")
                if (it == limit) {
                    val timeSpent = (System.currentTimeMillis() - start)
                    println("\nTime Coroutines: $timeSpent milisegundos")
                }
                delayRandom()
            }
        }
    }
}

fun suspendFun() {
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