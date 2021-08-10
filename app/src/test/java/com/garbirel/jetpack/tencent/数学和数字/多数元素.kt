package com.garbirel.jetpack.tencent.数学和数字

import org.junit.Test

class 多数元素 {
    @Test
    fun test() {
        val index = majorityElement(intArrayOf(1))
        println("------->>>>>>>        $index")
    }

    private fun majorityElement(nums: IntArray): Int {
        val hashMap = mutableMapOf<Int,Int>()
        for (index in nums) {
            if(hashMap.getOrDefault(index,0) == 0) {
                hashMap[index] = 1
            } else {
                hashMap[index] = hashMap.getOrDefault(index,0) + 1
            }
            if(hashMap.getOrDefault(index,0) > nums.size / 2) return index
        }
        return 0
    }
}