package com.garbirel.jetpack

import org.junit.Test
import java.util.*
import kotlin.collections.HashMap

/**
 * 二分查找
 * 前提条件为有序
 * */
class binarySearch {
    @Test
    fun test() {
//        var index = findMin(intArrayOf(4,5,6,7,0,1,2))
        var index = frequencySort("tree")
        println("---------->>>>>>>>>>     $index")
    }

    fun search(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.size -1
        while(left <= right) {
            val mid = (left + right) / 2
            if(nums[mid] == target) return mid
            if(nums[mid] > target) {
                right = mid -1
            } else {
                left = mid + 1
            }
        }
        return -1
    }

    // 需要考虑的事情是int的精度
    fun mySqrt(x: Int) : Int {
        var min = 0
        var max = x
        var mid = 0
        while(min <= max) {
            mid = (min + max) / 2
            if (mid * mid == x) return mid
            if (mid * mid > x) {
                max = mid - 1
            } else min = mid + 1
        }
        return if(mid * mid <= x) mid else mid -1
    }

    // 搜索旋转排序数组
    fun search1(nums: IntArray, target: Int) : Int {
        // 尝试在不先使用排序的情况下进行二分查找

        return target
    }

    // 寻找比目标字母大的最小字母
    fun nextGreatestLetter(letters: CharArray, target: Char): Char {
        var left = 0
        var right = 0
        return target
    }

    // 寻找最小值
    fun findMin(nums: IntArray): Int {
        Arrays.sort(nums)
        return nums[0]
        /*var left = 0
        var right = nums.size -1
        while(left < right) {
            var mid = (left + right) / 2
            if(mid == 0) {
                return if(nums[mid] < nums[mid + 1]) nums[mid] else -1
            } else {
                if(nums[mid] < nums[mid-1] && nums[mid] < nums[mid + 1]) {
                    return nums[mid]
                } else if (nums[mid] > nums[mid-1]) {
                    left = mid +1
                } else right = mid -1
            }
        }
        return -1*/
    }

    // 根据字符出现的频率排序
    fun frequencySort(s: String): String {
        val result = s.toCharArray()
        val hashMap = HashMap<Char,Int>()
        for (index in result) {
            hashMap[index] = if(hashMap.getOrDefault(index,0) == 0) 1 else hashMap.getOrDefault(index,0) + 1
        }
        val list: List<Map.Entry<Char, Int>> = ArrayList(hashMap.entries)

        Collections.sort(list, Comparator<Map.Entry<Char,Int>>() {
            o1, o2 ->  o2.value - o1.value
        })
        val sb = StringBuilder()
        for(indexs in list) {
            for(index in 0 until indexs.value) {
                sb.append(indexs.key)
            }
        }
        return sb.toString()
    }
}