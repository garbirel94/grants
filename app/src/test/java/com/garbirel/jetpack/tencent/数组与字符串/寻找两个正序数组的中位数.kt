package com.garbirel.jetpack.tencent.数组与字符串

import org.junit.Test

class 寻找两个正序数组的中位数 {
    @Test
    fun test () {
        val index = findMedianSortedArrays(intArrayOf(1,3), intArrayOf(2,4))
        println("-------------->>>>>>>>      $index")
    }

    // 暴力解法
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        var newArray = nums1.plus(nums2).toList()
        newArray = newArray.sorted()
        return if(newArray.size % 2 == 0) {
            val mid = newArray.size / 2
            (newArray[mid] + newArray[mid -1]) / 2.0
        } else {
            val mid = newArray.size / 2
            newArray[mid].toDouble()
        }
    }

    // 二分查找
    fun findMedianSortedArrays2 (nums1: IntArray, nums2: IntArray) : Double {
        val allLength = nums1.size + nums2.size
        return if(allLength % 2 == 1) {
            getKthElement(nums1,nums2,allLength / 2 + 1).toDouble()
        } else {
            (getKthElement(nums1,nums2,allLength / 2) + getKthElement(nums1,nums2,allLength / 2 + 1)) / 2.0
        }
    }

    /**
     *  主要思路：要找到第 k (k>1) 小的元素，那么就取 pivot1 = nums1[k/2-1] 和 pivot2 = nums2[k/2-1] 进行比较
     * 这里的 "/" 表示整除
     * nums1 中小于等于 pivot1 的元素有 nums1[0 .. k/2-2] 共计 k/2-1 个
     * nums2 中小于等于 pivot2 的元素有 nums2[0 .. k/2-2] 共计 k/2-1 个
     * 取 pivot = min(pivot1, pivot2)，两个数组中小于等于 pivot 的元素共计不会超过 (k/2-1) + (k/2-1) <= k-2 个
     * 这样 pivot 本身最大也只能是第 k-1 小的元素
     * 如果 pivot = pivot1，那么 nums1[0 .. k/2-1] 都不可能是第 k 小的元素。把这些元素全部 "删除"，剩下的作为新的 nums1 数组
     * 如果 pivot = pivot2，那么 nums2[0 .. k/2-1] 都不可能是第 k 小的元素。把这些元素全部 "删除"，剩下的作为新的 nums2 数组
     * 由于我们 "删除" 了一些元素（这些元素都比第 k 小的元素要小），因此需要修改 k 的值，减去删除的数的个数
     */
    private fun getKthElement (nums1: IntArray, nums2: IntArray,k : Int) : Int {
        val length1 = nums1.size
        val length2 = nums2.size
        var index1 = 0
        var index2 = 0
        var k = k
        while (true) {
            if (index1 == length1) return nums2[index2 + k -1]
            if (index2 == length2) return nums1[index1 + k -1]
            if (k == 1) return Math.min(nums1[index1],nums2[index2])
            val half = k / 2
            val newIndex1 = Math.min(index1 + half,length1) - 1
            val newIndex2 = Math.min(index2 + half,length2) - 1
            val pivot1 = nums1[newIndex1]
            val pivot2 = nums2[newIndex2]
            if(pivot1 <= pivot2) {
                k -= newIndex1 - index1 + 1
                index1 = newIndex1 + 1
            } else {
                k -= newIndex2 - index2 + 1
                index2 = newIndex2 + 1
            }
        }
    }
}