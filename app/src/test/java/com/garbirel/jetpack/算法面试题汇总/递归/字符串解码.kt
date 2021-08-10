package com.garbirel.jetpack.算法面试题汇总.递归

import org.junit.Test
import java.lang.StringBuilder

class 字符串解码 {
    @Test
    fun test() {

    }

    fun decodeString(s: String): String {
        val sb = StringBuilder()
        while (sb.indexOf("[") != -1) {
            var leftIndex = sb.lastIndexOf("[")
            var rightIndex = sb.indexOf("]",leftIndex)
            var str = sb.substring(leftIndex + 1,rightIndex)
            var i = leftIndex - 1
            var count = 0
            var base = 1
            while (i >= 0) {

            }
        }
        return ""
    }
}