package com.garbirel.jetpack.tencent.数组与字符串

import org.junit.Test

class 两数之和 {
    @Test
    fun test () {
        val index = twoSum(intArrayOf(2,3,7,1,15),9)
        println("-------------->>>>>>>>      ${index.toList()}")
    }

    fun twoSum(nums: IntArray, target: Int): IntArray {
        var result = IntArray(2)
        for (index in nums.indices) {
            var count = index+ 1
            while (count < nums.size) {
                if (nums[count] == target - nums[index]) {
                    result[0] = index
                    result[1] = count
                    break
                }
                count++
            }
        }
        return result
    }
}