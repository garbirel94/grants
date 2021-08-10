package com.garbirel.jetpack.中级算法.数组和字符串

import org.junit.Test
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

class 字母异位词分组 {
    @Test
    fun test() {
        val index = groupAnagrams(arrayOf("eat", "tea", "tan", "ate", "nat", "bat"))

    }

    fun groupAnagrams(strs: Array<String>) : List<List<String>> {
        if(strs.isEmpty()) return ArrayList<ArrayList<String>>()
        val hashMap = HashMap<String,ArrayList<String>>()
        for (index in strs) {
            val ch = index.toCharArray()
            // 字符串转char数组，排序，只要是字母异位词经过排序后就完全符合规则。
            Arrays.sort(ch)
            // 将排序后的数组转化成字符串
            val strKey = ch.toList().toString()
            // 只要是排序后在hashmap中不包含对应的key，则创建一个对应key的空数组
            if(!hashMap.containsKey(strKey)) {
                hashMap[strKey] = ArrayList()
            }
            hashMap[strKey]?.add(index)
        }
        return ArrayList<ArrayList<String>>(hashMap.values)
    }
}