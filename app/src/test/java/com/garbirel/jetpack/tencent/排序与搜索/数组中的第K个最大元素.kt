package com.garbirel.jetpack.tencent.排序与搜索

import org.junit.Test


class 数组中的第K个最大元素 {
    /**
     * 1.首先想到的是硬解，直接排序，取第k大的数值
     * 2.基于堆排序的选择
     * */
    @Test
    fun test() {
        val index = findKthLargest2(intArrayOf(3,2,1,5,6,4,7),2)
        println("------->>>>>>    $index")
    }

    // 基于快速排序 取第k大的数值
    fun findKthLargest(nums: IntArray, k: Int): Int {
        return nums.sorted()[nums.size - k]
    }

    // 基于堆排序 取第k大的数值  建立最大堆（有时候堆排序选择建立最小堆，视情况而定）
    fun findKthLargest2(nums : IntArray,k : Int) : Int {
        var heapSize = nums.size
        buildMaxHeap(nums,heapSize)
        for (i in nums.size - 1 downTo nums.size - k + 1) {
            swap(nums, 0, i)
            --heapSize
            maxHeapify(nums, 0, heapSize)
        }
        return nums[0]
    }

    fun buildMaxHeap (a: IntArray,heapSize: Int) {
        for (i in heapSize / 2 downTo 0) {
            maxHeapify(a, i, heapSize)
        }
    }

    fun maxHeapify(a : IntArray,i : Int, heapSize : Int) {
        val l = i * 2 + 1
        val r = i * 2 + 2
        var largest = i
        if (l < heapSize && a[l] > a[largest]) {
            largest = l
        }
        if (r < heapSize && a[r] > a[largest]) {
            largest = r
        }
        if (largest != i) {
            swap(a, i, largest)
            maxHeapify(a, largest, heapSize)
        }
    }

    fun swap (a : IntArray,i : Int, j : Int) {
        val temp = a[i]
        a[i] = a[j]
        a[j] = temp
    }
}