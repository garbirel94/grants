package com.garbirel.jetpack.tencent.数学和数字

import org.junit.Test

class 整数反转 {
    @Test
    fun test() {
        // 1534236469
        val index = reverse2(1534236469)
        println("------->>>>>>>     $index")
    }

    //  容易溢出
    fun reverse(x: Int): Int {
        var result = ""
        val flag = x < 0
        val nums = if(flag) x.toString().substring(1).toCharArray() else x.toString().toCharArray()
        for(index in nums.reversed()) {
            result += index
        }
        result.toBigInteger()
        val resultSum = if(flag) result.toInt() * (-1) else result.toInt()
        if(resultSum > Int.MAX_VALUE || resultSum < Int.MIN_VALUE) return -1
        return resultSum
    }

    // 先计算新一轮的结果，再除以10， 如果没有溢出，那么得到的值，还会是上一次计算的结果， 如果溢出，那么就会不相等
    fun reverse2 (x : Int) : Int {
        var x = x
        var ret = 0
        while (x != 0) {
            val temp = ret * 10 + x % 10
            if(temp / 10 != ret) return 0
            ret = temp
            x /= 10
        }
        return ret
    }
}