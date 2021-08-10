package com.garbirel.jetpack.算法面试题汇总.递归

import org.junit.Test

/**
 * 包含4的幂，类似的
 * */
class `3的幂` {
    @Test
    fun test() {
        val index = isPowerOfThree(1)
        println("------->>>>>    $index")
    }

    fun isPowerOfThree(n: Int): Boolean {
        if(n==0) return false
        if(n == 1 || n == -1) return true
        return f4(n)
    }

    fun f3(n: Int) : Boolean {
        return if (n % 3 == 0) {
            if(n / 3 == 1) {
                true
            } else f3(n/3)
        } else {
            false
        }
    }

    fun f4(n: Int) : Boolean {
        return if (n % 4 == 0) {
            if(n / 4 == 1) {
                true
            } else f4(n/4)
        } else {
            false
        }
    }
}