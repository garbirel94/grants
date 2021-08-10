package com.garbirel.jetpack.tencent.数组与字符串

import org.junit.Test

class 除自身以外数组的乘积 {
    @Test
    fun test() {
        val index = productExceptSelf2(intArrayOf(1,2,3,4,0))
        println("------->>>>>>>     ${index.toList()}")
    }

    // 不使用除法
    fun productExceptSelf(nums: IntArray): IntArray {
        var resultLeft = intArrayOf()
        var resultRight = intArrayOf()
        for(index in nums) {
            resultLeft = resultLeft.plus(1)
            resultRight = resultRight.plus(1)
        }
        var size = nums.size - 1
        for (index in 1 until nums.size) {
            size--
            resultLeft[index] = resultLeft[index- 1] * nums[index -1]
            resultRight[size] = resultRight[size + 1] * nums[size +1]
        }
        for (index in nums.indices) {
            resultLeft[index] = resultLeft[index] * resultRight[index]
        }
        return resultLeft
    }

    // 尝试空间复杂度
    fun productExceptSelf2(nums: IntArray): IntArray {
        var result = intArrayOf(1)
        for(index in 1 until nums.size) {
            result = result.plus(nums[index -1] * result[index -1])
        }
        var sum = 1
        for(index in nums.size - 1 downTo 0) {
            result[index] = result[index] * sum
            sum *= nums[index]
        }
        return result
    }
}