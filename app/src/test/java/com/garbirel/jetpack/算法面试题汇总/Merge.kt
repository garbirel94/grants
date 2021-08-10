package com.garbirel.jetpack.算法面试题汇总

import org.junit.Test

/**
 * 合并两个有序数组
 * */
class Merge {
    @Test
    fun test () {
        val index = merge2(intArrayOf(2,1,3,3,2,4,0,0,0),6, intArrayOf(1,2,22),3)
//        println("-------->>>>>>>>>>      $index")
        println("-------->>>>>>>>>>      ${index.toList()}")
    }

    // 数组
    // 208ms    41.67%
    // 35.4mb   13.54%
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int):  IntArray {
        for(index in nums1.size-n until nums1.size) {
            nums1[index] = nums2[index - nums1.size + n]
        }
        nums1.sort()
        return nums1
    }

    // 双指针
    // 204ms    52.08%
    // 35.4mb   16.67%
    fun merge2(nums1: IntArray, m: Int, nums2: IntArray, n: Int):  IntArray {
        var left = m
        val right = nums1.size
        while(left < right) {
            nums1[left] = nums2[left + n - right]
            left ++
        }
        nums1.sort()
        return nums1
    }
}