package com.garbirel.jetpack.tencent.数组与字符串

import org.junit.Test

class 字符串转换整数 {

    @Test
    fun test() {
        val index = myAtoi("-91283472332")
        println("-------->>>>>>>>>    $index")
    }

    fun myAtoi(s: String): Int {
        val s = s.trim()
        if(s.isEmpty()) return 0
        var charIndex = 0
        val positive = when(s[0]) {
            in '0' .. '9' -> true
            '+' -> {
                charIndex++
                true
            }
            '-' -> {
                charIndex++
                false
            }
            else -> return 0
        }
        var result = 0
        while (charIndex < s.length && s[charIndex] in '0'..'9') {
            val temp = result * 10
            if(temp / 10 == result) result = temp
            else  return if(positive) Int.MAX_VALUE else  Int.MIN_VALUE

            val num = s[charIndex ++] - '0'
            result += if(positive) num else -num

            if(positive && result < 0) return Int.MAX_VALUE
            if(!positive && result > 0) return Int.MIN_VALUE
        }
        return result
    }
}