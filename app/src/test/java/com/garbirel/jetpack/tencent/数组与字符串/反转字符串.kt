package com.garbirel.jetpack.tencent.数组与字符串

import org.junit.Test

class 反转字符串 {
    @Test
    fun test() {
        val index = reverseString(charArrayOf('r','e','f','d','d'))
        println("------->>>>>>    ${index.toList()}")
    }

    fun reverseString(s: CharArray): CharArray {
        var left = 0
        var right = s.size - 1
        while(left< right) {
            val temp = s[left]
            s[left] = s[right]
            s[right] = temp
            left++
            right--
        }
        return s
    }
}