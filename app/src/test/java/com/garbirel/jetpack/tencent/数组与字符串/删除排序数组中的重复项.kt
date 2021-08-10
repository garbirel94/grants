package com.garbirel.jetpack.tencent.数组与字符串

import org.junit.Test

class 删除排序数组中的重复项 {
    @Test
    fun test () {
        var index = removeDuplicates(intArrayOf(1,2,2,3,4,4,5,6))
        println("-------------->>>>>>>>      $index")
    }

    fun removeDuplicates(nums: IntArray): Int {
        var left = 0
        var right = 0
        while (right < nums.size) {
            if(nums[left] != nums[right]) {
                left ++
                nums[left] = nums[right]
            }
            right ++
        }
        return left+1
    }
}