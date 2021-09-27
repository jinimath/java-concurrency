package ai.qanda.ch1

import kotlin.concurrent.thread

class UnsafeSequence {
    private var value: Int = 0

    @Synchronized
    fun getNext(): Int {
        return value++
    }
}

fun main() {
    val sequence = UnsafeSequence()
    repeat(10) {
        thread {
            Thread.sleep(10)
            println("value = ${sequence.getNext()}")
        }
    }
}