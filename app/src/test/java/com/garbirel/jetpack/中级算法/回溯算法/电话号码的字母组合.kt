package com.garbirel.jetpack.中级算法.回溯算法

import org.junit.Test
import java.lang.StringBuilder

class 电话号码的字母组合 {
    @Test
    fun test() {
        val index = letterCombinations("23")
        println("-------->>>>>>>>    ${index.toList()}")
    }

    fun letterCombinations(digits: String): List<String> {
        val result = ArrayList<String>()
        if(digits.isEmpty()) return result
        val tempInfo = arrayListOf<CharArray>(charArrayOf('a','b','c'), charArrayOf('d','e','f'),charArrayOf('g','h','i'),charArrayOf('j','k','l'),charArrayOf('m','n','o'),
            charArrayOf('p','q','r','s'),charArrayOf('t','u','v'),charArrayOf('w','x','y','z'))

        val list1 = letterCombinations(digits.substring(1,digits.length))
        val ch = tempInfo[digits.elementAt(0) - '2']

        if (list1.isEmpty()) {
            for (c in ch) {
                val sb = StringBuilder()
                sb.append(c)
                result.add(sb.toString())
            }
        } else {
            for (c in ch) {
                for (c1 in list1) {
                    val sb = StringBuilder()
                    sb.append(c)
                    sb.append(c1)
                    result.add(sb.toString())
                }
            }
        }
        return result
    }
}