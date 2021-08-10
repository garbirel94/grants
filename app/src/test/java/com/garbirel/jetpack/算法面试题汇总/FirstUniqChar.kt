package com.garbirel.jetpack.算法面试题汇总

import org.junit.Test

class FirstUniqChar {
    @Test
    fun test() {
        val index = firstUniqChar("loveleetcode")
        println("------------>>>>>>>>>       $index")
    }

    fun firstUniqChar(s: String): Int {
        val hashMap = mutableMapOf<Char,Int>()
        val tempArray = s.toCharArray()
        for (index in tempArray.indices) {
            hashMap[tempArray[index]] = if(hashMap.getOrDefault(tempArray[index],0) == 0) 1 else hashMap.getOrDefault(tempArray[index],0) + 1
        }
        for (index in tempArray.indices) {
            if (hashMap.getOrDefault(tempArray[index],0) == 1) {
                return index
            }
        }
        return -1
    }

    fun superEggDrop(k: Int, n: Int) : Int {
        return -1
    }
}