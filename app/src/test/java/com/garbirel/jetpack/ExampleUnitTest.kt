package com.garbirel.jetpack

import org.junit.Test

class ExampleUnitTest {
    private var cache = mutableMapOf<Int,Int>()
    @Test
    fun addition_isCorrect() {
        val index = climbStairs(45)
        println(index)
    }

    fun myAtoi(s: String): Int {
        return s.toInt()
    }

    fun fib(n : Int) : Int {
        return if(n < 2) n
        else fib(n-1) + fib(n -2)
    }

    fun climbStairs(n: Int): Int {
        if(cache.containsKey(n)) return cache[n]!!
        val result = if(n <= 2) n
        else climbStairs(n-1) + climbStairs(n -2)
        cache[n] = result
        return result
    }
}
