package com.garbirel.jetpack.算法面试题汇总

import org.junit.Test

class MajorityElement {
    @Test
    fun test () {
        val index = majorityElement(intArrayOf(2,1,3,3,2,4,3,3,3))
        println("-------->>>>>>>>>>      $index")
    }

    // 哈希表
    fun majorityElement(nums: IntArray): Int {
        val hashMap = mutableMapOf<Int,Int>()
        for(index in nums.indices) {
            hashMap[nums[index]] = if(hashMap.getOrDefault(nums[index],0) == 0) 1 else hashMap.getOrDefault(nums[index],0) + 1
        }
        var result = -1
        for(index in nums.indices) {
            if(hashMap.getOrDefault(nums[index],0) > nums.size / 2) {
                result = index
                break
            }
        }
        return if(result == -1) result else nums[result]
    }

    // 位运算
    fun majorityElement2 (nums: IntArray) : Int {
        return -1
    }
}