package com.garbirel.jetpack.tencent.数学和数字

import org.junit.Test

class 只出现一次的数字 {
    @Test
    fun test() {
        var index = singleNumber(intArrayOf(1,2,3,2,1,0,0))
        println("-------->>>>>>>>      $index")
    }

    // 位运算  任何数与0都是其本身，任何数与本身都是0
    fun singleNumber(nums: IntArray): Int {
        var ret = 0
        for(index in nums) {
            ret = ret.xor(index)
        }
        return ret
    }
}