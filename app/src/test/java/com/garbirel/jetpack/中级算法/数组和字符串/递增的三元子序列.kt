package com.garbirel.jetpack.中级算法.数组和字符串

import org.junit.Test
import kotlin.math.min

/**
 * 做数字类型时，注意考虑int的范围
 * */
class 递增的三元子序列 {
    @Test
    fun test() {
//        [1,5,0,4,1,3]
//        [20,100,10,12,5,13]
//        [1,2,2147483647]
        val flag = increasingTriplets2(intArrayOf(2147483647,1,2,3))
        println("-------->>>>>>>   $flag")
    }

    /**
     * 递增的三元子序列，连续三元子序列
     * */
    fun increasingTriplet (nums: IntArray) : Boolean {
        if(nums.size < 3) return false
        var left = 1
        var maxSize = 3
        while(left <= nums.size - 1) {
            if (nums[left - 1] < nums[left]) {
                maxSize--
                if(maxSize == 1) return true
            } else maxSize = 3
            left++
        }
        return maxSize <= 1
    }

    /**
     * 非连续的三元子序列，未考虑int值的范围
     * */
    fun increasingTriplets (nums: IntArray) : Boolean {
        if (nums.size < 3) return false
        for (index in 2 until nums.size) {
            for (indexS in index until nums.size) {
                if (nums[index] < nums[indexS]) {
                    for (indexT in indexS until nums.size) {
                        if (nums[indexT] > nums[indexS -1]) {
                            return true
                        }
                    }
                }
            }
        }
        return false
    }

    fun increasingTriplets2 (nums: IntArray) : Boolean {
        var tempMax = Integer.MAX_VALUE
        var tempMin = Integer.MAX_VALUE
        if(nums.size < 3) return false
        for(index in nums.indices) {
            when {
                nums[index] > tempMax -> return true
                nums[index] > tempMin -> {
                    tempMax = nums[index]
                }
                else -> tempMin = nums[index]
            }
        }
        return false
    }
}