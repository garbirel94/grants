package com.garbirel.jetpack.tencent.数组与字符串

import org.junit.Test

class 存在重复元素 {
    @Test
    fun test() {
        val index = containsDuplicate(intArrayOf(0,1,2,3))
        println("------->>>>>>>     $index")
    }

    fun containsDuplicate(nums: IntArray): Boolean {
        val hashMap = hashMapOf<Int,Int>()
        for(index in nums) {
            if(hashMap.getOrDefault(index,0) == 0) {
                hashMap[index] = 1
            } else return true
        }
        return false
    }
}