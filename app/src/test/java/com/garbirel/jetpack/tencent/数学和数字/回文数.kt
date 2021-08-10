package com.garbirel.jetpack.tencent.数学和数字

import org.junit.Test

class 回文数 {
    @Test
    fun test() {
        val index = isPalindrome2(0)
        println("--------->>>>>>>>    $index")
    }

    /**
     * 将整数转成字符串来计算,使用双指针进行判断
     * */
    fun isPalindrome(x: Int): Boolean {
        if (x < 0) return false
        var left = 0
        var right = x.toString().length - 1
        var temp = x.toString()
        while (left < right) {
            if (temp[left] != temp[right]) {
                return false
            } else {
                left++
                right--
            }
        }
        return true
    }

    /**
     * 取模或者取余
     * */
    fun isPalindrome2 (x: Int): Boolean {
        if (x < 0) return false
        var tempS = x
        var ret = 0
        while(tempS != 0) {
            val temp = ret * 10 + tempS % 10
            ret = temp
            tempS /= 10
        }
        return ret == x
    }
}