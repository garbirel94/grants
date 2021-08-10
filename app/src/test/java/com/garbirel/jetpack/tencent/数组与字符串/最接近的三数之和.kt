package com.garbirel.jetpack.tencent.数组与字符串

import org.junit.Test
import java.util.*

class 最接近的三数之和 {
    @Test
    fun test() {
        val index = threeSumClosest(intArrayOf(-1,2,1,-4),1)
        println("---------->>>>>>     $index")
    }

    fun threeSumClosest(nums: IntArray, target: Int): Int {
        var sum = 0
        var size = nums.size
        if(nums.size == 3) {
            return nums[0] + nums[1] + nums[2]
        }
        Arrays.sort(nums)
        var start: Int = 0
        var end = size - 1
        var sub = Integer.MAX_VALUE
        var firstIndex = 0
        for (index in 0 until nums.size -2 ) {
            firstIndex = index
            start = index + 1
            end = size -1
            while(start < end) {
                sum = nums[start] + nums[firstIndex] + nums[end] -target
                if(sum == 0) return target
                sub = if(Math.abs(sub) > Math.abs(sum)) sum else sub
                if(sum > 0) end-- else start++
            }
        }
        return target + sub
    }
}