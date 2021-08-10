package com.garbirel.jetpack.中级算法.数组和字符串

import org.junit.Test

class 最长回文子串 {
    @Test
    fun test() {
        val index = longestPalindrome("aabc")
        println("---------->>>>>>>    $index")
    }

    /**
     * 获取到最长回文子串的长度
     * */
    fun longestPalindrome(s: String): Int {
        val sb = StringBuffer()
        for(index in s) {
            sb.append("#")
            sb.append(index)
        }
        sb.append("#")
        val sChar = sb.toString().toCharArray()
        var max_len = 0
        for(index in sChar.indices) {
            max_len = Math.max(maxLength(sChar,index),max_len)
        }
        return max_len
    }

    fun maxLength(sChar: CharArray,index : Int) : Int {
        var length = 0
        for (indexNum  in 0..index) {
            if (indexNum < sChar.size - index) {
                if (sChar[index - indexNum] == sChar[index + indexNum])
                    length++
            } else break
        }
        return length - 1
    }

    /**
     * 获取到最长回文子串
     * */
    fun longestPalindrome2 (s: String) : String {

        return ""
    }
}