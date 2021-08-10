package com.garbirel.jetpack.tencent.数组与字符串

import org.junit.Test

class 三数之和 {
    @Test
    fun test() {
        val index  = threeSum(intArrayOf(-1,0,1,2,2,2,-1,-4))
        println("--------->>>>>>  ${index.toList()}")
    }

    fun threeSum(nums: IntArray): List<List<Int>> {
        nums.sort()
        val result = ArrayList<ArrayList<Int>>()
        var innerList = ArrayList<Int>()
        for(index in nums.indices) {
            if(nums[index] > 0) break
            if (index > 0 && nums[index] == nums[index -1]) continue
            val target = 0 - nums[index]
            var left  = index + 1
            var right = nums.size - 1

            while(left < right) {
                when {
                    nums[left] + nums[right] == target -> {
                        innerList.add(nums[index])
                        innerList.add(nums[left])
                        innerList.add(nums[right])
                        result.add(innerList)
                        innerList = ArrayList()

                        while(left < right && nums[left] == nums[left + 1]) left++
                        while(left < right && nums[right] == nums[right - 1]) right--
                        left ++
                        right --
                    }
                    nums[left] + nums[right] < target -> {
                        left ++
                    }
                    else -> right--
                }
            }
        }
        return result
    }
}