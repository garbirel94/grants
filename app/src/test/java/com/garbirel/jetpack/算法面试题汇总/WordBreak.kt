package com.garbirel.jetpack.算法面试题汇总

import org.junit.Test

class WordBreak {
    @Test
    fun test() {
        val index = wordBreak("leetcode", arrayListOf("leet", "code"))
        println("--------->>>>>>>>      $index")
    }

    fun wordBreak(s: String, wordDict: List<String>): Boolean {
        val sets = HashSet<String>(wordDict)
        val dp = Array<Boolean>(s.length + 1) {false}
        dp[0] = true
        for (index in 1 until s.length) {
            for (indexSecond in 0 until index) {
                if (dp[indexSecond] && sets.contains(s.substring(indexSecond,index))) {
                    dp[index] = true
                    break
                }
            }
        }

        return dp[s.length]
    }
}