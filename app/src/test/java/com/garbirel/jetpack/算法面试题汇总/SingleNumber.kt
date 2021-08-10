package com.garbirel.jetpack.算法面试题汇总

import org.junit.Test
import kotlin.math.pow
import kotlin.random.Random

class SingleNumber {
    @Test
    fun test () {
        val index = isAnagram("anagram","nagaram")
        println("-------->>>>>>>>>>      $index")
    }

    // 哈希表
    fun singleNumber(nums: IntArray): Int {
        val hashMap = mutableMapOf<Int,Int>()
        var result = 0
        for(index in nums.indices) {
            hashMap[nums[index]] = if(hashMap.getOrDefault(nums[index],0) == 0)  1 else hashMap.getOrDefault(nums[index],0) + 1
        }
        for(index in nums.indices) {
            if(hashMap.getOrDefault(nums[index],0) == 1) {
                result = index
                break
            }
        }
        return nums[result]
    }

    // 位运算  一个数字与0异或等于本身，一个数字与本身异或等于0；把所有数字进行异或就能得到结果。
    fun singleNumber2(nums: IntArray) : Int {
        var num = 0
        for(index in nums.indices) {
            num = num.xor(nums[index])
        }
        return num
    }

    fun titleToNumber (columnTitle: String) : Int {
        val allResult = arrayOf('A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z')
        val tempResult = columnTitle.reversed().toCharArray()
        var gameResult = 0
        for(index in tempResult.indices) {
            gameResult += 26f.pow(index).toInt() * (allResult.indexOf(tempResult[index]) + 1)
        }
        return gameResult
    }

    fun largestNumber(nums: IntArray): String {
        for (index in nums.indices) {

        }
        return ""
    }

    fun longestSubstring(s: String, k: Int): Int {
        val tempArray = s.toCharArray()
        val hashMap = mutableMapOf<Char,Int>()
        for (index in tempArray.indices) {
            hashMap[tempArray[index]] = if(hashMap.getOrDefault(tempArray[index],0) == 0) 1 else hashMap.getOrDefault(tempArray[index],0) + 1
        }
        val tempResult = mutableListOf<Int>()
        for (index in tempArray.indices) {
            tempResult.add(hashMap[tempArray[index]]!!)
        }
        var sum = k
        var tempSum = -1
        for (index in tempResult.indices) {
            while(tempResult[index] > 2) {
                sum--
            }
            if(sum == 0)
                tempSum = index
                break
        }
        return if (tempSum == -1) -1
        else {
            var tempIndex = tempArray.indexOf(tempArray[tempResult.indexOf(tempSum)])
            -1
        }
    }

    fun isAnagram (s: String, t: String) : Boolean {
        if(s.length != t.length) return false
        var flag = true
        val sCharArray = s.toCharArray()
        val tCharArray = t.toCharArray()
        val hashMap = mutableMapOf<Char,Int>()
        val hashMapT = mutableMapOf<Char,Int>()
        for (index in sCharArray) {
            hashMap[index] = hashMap.getOrDefault(index,0) + 1
        }
        for (index in tCharArray) {
            hashMapT[index] = hashMapT.getOrDefault(index,0) + 1
        }
        for (index in tCharArray) {
            if(hashMap.getOrDefault(index,0) < hashMapT.getOrDefault(index,0)) {
                flag = false
                break
            }
        }
        return flag
    }

    fun findKthLargest(nums: IntArray, k: Int): Int {

        return -1
    }
}

class RandomizedSet() {
    /** Initialize your data structure here. */
    var list = arrayListOf<Int>()
    var hashMap = mutableMapOf<Int,Int>()

    fun RandomizedSet() {
        hashMap = HashMap()
        list = ArrayList()
    }
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    fun insert(`val`: Int): Boolean {
        if (hashMap.containsKey(`val`)) return false
        hashMap[`val`] = list.size
        list.add(list.size, `val`)
        return true
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    fun remove(`val`: Int): Boolean {
        if (!hashMap.containsKey(`val`)) return false
        val lastElement = list[list.size -1]
        val idx = hashMap[`val`]
        list[idx!!] = lastElement
        hashMap[lastElement] = idx
        list.remove(list.size - 1)
        hashMap.remove(`val`)
        return true
    }

    /** Get a random element from the set. */
    fun getRandom(): Int {
        return list[Random.nextInt(list.size)]
    }
}

class MedianFinder() {
    /** initialize your data structure here. */
    var arrayList = arrayListOf<Int>()

    fun MedianFinder() {
        arrayList = ArrayList<Int>()
    }

    fun addNum(num: Int) {
        arrayList.add(num)
        arrayList.sort()
    }

    fun findMedian(): Double {
        if(arrayList.isEmpty()) return 0.0
        return if(arrayList.size % 2 == 0) {
            (arrayList[arrayList.size / 2 - 1] + arrayList[arrayList.size / 2]) / 2.0
        }
        else arrayList[arrayList.size / 2].toDouble()
    }
}