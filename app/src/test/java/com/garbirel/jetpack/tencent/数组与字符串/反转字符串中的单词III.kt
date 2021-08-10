package com.garbirel.jetpack.tencent.数组与字符串

import org.junit.Test

class 反转字符串中的单词III {
    @Test
    fun test() {
        val index = reverseWords("Let's take LeetCode contest")
        println("-------->>>>>>>  $index")
    }

    private fun reverseWords(s: String): String {
        val arrayInfo = s.split(" ")
        var result = ""
        for (index in arrayInfo) {
            var left = 0
            var right = index.length -1
            val indexArray = index.toCharArray()
            while (left < right) {
                val temp = indexArray[left]
                indexArray[left] = indexArray[right]
                indexArray[right] = temp
                left ++
                right --
            }
            indexArray.forEach {
                result += it
            }
            result += " "
        }
        return result.trim()
    }

    // 有问题
    fun reverseWords2(s: String): String {
        val length = s.length
        var index = 0
        while (index < length) {
            var start = index
            while(start < length && s[index] != ' ') index++
            var left = start
            var right = index - 1
            while(left < right) {

            }
        }
        return ""
    }
}