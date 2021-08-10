package com.garbirel.jetpack.tencent.数学和数字

import org.junit.Test

class `2的幂` {
    @Test
    fun test() {
        val index = isPowerOfTwo(   8)
        println("------->>>>>>      $index")
    }

    /**
     * O(logN),也算是一种硬解
     * */
    fun isPowerOfTwo(n: Int): Boolean {
        if (n == 0) return false
        var n = n
        while(n % 2 == 0) {
            n /= 2
        }
        return n == 1
    }


}