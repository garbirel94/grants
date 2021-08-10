package com.garbirel.jetpack.tencent.数组与字符串

import org.junit.Test

class 最长公共前缀 {
    @Test
    fun test() {
        val index = longestCommonPrefix(arrayOf("",""))
        println("---------->>>>>>>>      $index")
    }

    // 二分法
    fun longestCommonPrefix(s: Array<String>): String {
        if(s.isEmpty()) return ""
        var min  = Integer.MAX_VALUE
        for(index in s) {
            min = Math.min(min,index.length)
        }
        var low = 1
        var high = min
        while (low <= high) {
            val middle = (low + high) / 2
            if (isCommonPrefix(s,middle)) {
                low = middle + 1
            } else high = middle - 1
        }
        return s[0].substring(0,(low + high)/2)
    }

    private fun isCommonPrefix (s: Array<String>, length : Int) : Boolean {
        val tmp = s[0].substring(0,length)
        for(index in s) {
            if(!index.startsWith(tmp)) {
                return false
            }
        }
        return true
    }
}