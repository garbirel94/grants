package com.garbirel.jetpack.tencent.排序与搜索

import org.junit.Test

class 搜索旋转排序数组 {
    @Test
    fun test() {
        val index = search(intArrayOf(4,5,6,7,0,1,2),1)
        println("------------>>>>>>>>>>      $index")
    }

    fun search(nums: IntArray, target: Int): Int {
        if(!nums.contains(target)) return -1
        if(nums.size == 1) return 0
        /**
         * 兜兜转转，最后跟这个无关，只能用于自己判断旋转后的数组
         * */
        var numNew = nums
        numNew = numNew.plus(nums.copyOfRange(0,target))
        numNew = numNew.copyOfRange(target,numNew.size)
        println("-------->>>>>>>>        ${numNew.toList()}")
        return nums.indexOf(target)
    }
}