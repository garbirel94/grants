package com.garbirel.jetpack.tencent.动态规划

import org.junit.Test

class 最大子序和 {
    @Test
    fun test() {
        val index = maxSubArray(intArrayOf(-1))
        println("--------->>>>>>>     $index")
    }

    fun maxSubArray(nums: IntArray): Int {
        if(nums.isEmpty()) return 0
        var res = nums[0]
        var currentSum = nums[0]
        for(index in 1 until nums.size) {
            currentSum = if(currentSum > 0) nums[index] + currentSum else nums[index]
            res = Math.max(res,currentSum)
        }
        return res
    }
}