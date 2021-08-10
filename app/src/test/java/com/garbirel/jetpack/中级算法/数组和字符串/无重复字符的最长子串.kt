package com.garbirel.jetpack.中级算法.数组和字符串

import org.junit.Test

class 无重复字符的最长子串 {
    @Test
    fun test() {
        val index = lengthOfLongestSubstring("zwnigfunjwz")
        println("-------->>>>>    $index")
    }

    fun lengthOfLongestSubstring(s: String): Int {
        // 存在一种情况
        /*if(s.isEmpty()) return 0
        val arrays = s.toCharArray()
        var max = 0
        var tempSize = 0
        var slow = 0
        val hashMap = HashMap<Char,Int>()
        for (index in arrays.indices) {
            if (hashMap.containsKey(arrays[index])) {
                max = Math.max(max,tempSize)
                tempSize = index - Math.max(hashMap[arrays[index]]!!,slow)
                slow = hashMap[arrays[index]]!!
            } else {
                tempSize++
            }
            hashMap[arrays[index]] = index
        }
        return Math.max(max,tempSize)*/
        // 使用双指针 + 哈希表
        if(s.isEmpty()) return 0
        val arrays = s.toCharArray()
        var max = 0
        for(index in arrays.indices) {
            val hashMap = HashMap<Char,Int>()
            for (indexS in index until arrays.size) {
                if(hashMap.containsKey(arrays[indexS])) break
                hashMap.put(arrays[indexS],0)
                max = Math.max(hashMap.size,max)
            }
        }
        return max
    }
}