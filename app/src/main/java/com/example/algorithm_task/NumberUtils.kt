package com.example.algorithm_task

object NumberUtils {
    fun isOdd(number: Int): Boolean {
        return number % 2 != 0
    }

    fun isEven(number: Int): Boolean {
        return number % 2 == 0
    }

    fun isPrime(number: Int): Boolean {
        if (number <= 1) return false
        if (number <= 3) return true
        if (number % 2 == 0 || number % 3 == 0) return false
        var i = 5
        while (i * i <= number) {
            if (number % i == 0 || number % (i + 2) == 0) return false
            i += 6
        }
        return true
    }

    fun getFibonacciNumbersUpTo(limit: Int): MutableSet<Int?> {
        val fibonacciNumbers: MutableSet<Int?> = HashSet<Int?>()
        var a = 0
        var b = 1
        while (a <= limit) {
            fibonacciNumbers.add(a)
            val next = a + b
            a = b
            b = next
        }
        return fibonacciNumbers
    }
}