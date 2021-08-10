package com.garbirel.jetpack.tencent.回溯算法

import org.junit.Test

class 全排列 {
    @Test
    fun test() {
        val nums = intArrayOf(1,2,3,5)
        val result = permute(nums)
        println(result.size)
        for(index in result) {
            println("------->>>>>>>  ${index.toList()}")
        }
    }

    fun permute(nums: IntArray) : List<List<Int>> {
        val ans = ArrayList<List<Int>>()
        val size = nums.size
        permutation(nums,ans,0,size)
        return ans
    }

    fun permutation(nums: IntArray,ans : ArrayList<List<Int>>,start: Int,end: Int) {
        if (start == end) {
            ans.add(nums.toList())
            return
        } else {
            for (index in start until end) {
                swap(nums,start,index)
                permutation(nums,ans,start+ 1,end)
                swap(nums,start,index)
            }
        }
    }

    fun swap(nums: IntArray,k: Int,i: Int) {
        val temp = nums[k]
        nums[k] = nums[i]
        nums[i] = temp
    }
}