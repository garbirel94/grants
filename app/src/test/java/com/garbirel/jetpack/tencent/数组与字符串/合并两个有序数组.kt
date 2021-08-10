package com.garbirel.jetpack.tencent.数组与字符串

import org.junit.Test

class 合并两个有序数组 {
    @Test
    fun test() {
        val result = merge(intArrayOf(1,2,3,0,0,0),3, intArrayOf(2,5,6),3)
        println("-------->>>>>>>>     ${result.toList()}")
    }

    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): List<Int> {
        for(index in nums1.size - n until nums1.size) {
            nums1[index] = nums2[index - nums1.size + n]
        }
        var result = nums1.sorted()
        return result
    }
}