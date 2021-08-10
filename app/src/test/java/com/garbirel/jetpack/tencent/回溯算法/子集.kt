package com.garbirel.jetpack.tencent.回溯算法

import org.junit.Test

class 子集 {
    @Test
    fun test() {
        val index = subsets(intArrayOf(1))
        for(num in index) {
            println("------->>>>>>>>   ${num.toList()}")
        }
    }

    fun subsets(nums: IntArray): List<List<Int>> {
        val ans = ArrayList<ArrayList<Int>>()
        ans.add(ArrayList())
        for(num in nums) {
            val size = ans.size
            for(index in 0 until size) {
                val subset = ArrayList<Int>(ans[index])
                subset.add(num)
                ans.add(subset)
            }
        }
        return ans
    }
}