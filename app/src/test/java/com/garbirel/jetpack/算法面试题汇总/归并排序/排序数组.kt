package com.garbirel.jetpack.算法面试题汇总.归并排序

import org.junit.Test

class 排序数组 {
    @Test
    fun test() {
        val index = sortArray(intArrayOf(5,2,2,2,3,1))
        println(index.toList())
    }

    fun sortArray(nums: IntArray): IntArray {
        return nums.sortedArray()
    }

    // 超出时间限制，冒泡排序适合数组长度比较短的
    fun sortArray1 (nums: IntArray) : IntArray {
        for (index in 0 until nums.size - 1) {
            for (indexS in (index + 1) until nums.size) {
                if(nums[index] > nums[indexS]) {
                    val temp = nums[index]
                    nums[index] = nums[indexS]
                    nums[indexS] = temp
                }
            }
        }
        return nums
    }

    // 快排
    fun sortArray2 (nums: IntArray) : IntArray {

        return nums
    }

    // 堆排序
    fun sortArray3 (nums: IntArray) : IntArray {

        return nums
    }

    fun generate (nums: IntArray) {
        // 构建大顶堆
        for (index in nums.size / 2 downTo  0) {

        }


    }

    fun adjustHeap (nums: IntArray,index: Int,length: Int) {

    }
}