package com.garbirel.jetpack.tencent.动态规划

import org.junit.Test

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
    机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
    问总共有多少条不同的路径？
 * */
class 不同路径 {
    @Test
    fun test() {
        val index = uniquePaths2(3,7)
        println("--------->>>>>>>     $index")
    }

    fun uniquePaths (m: Int, n: Int) : Int {
        val ways = Array(m){IntArray(n)}
        for(index in 0 until m) {
            for(indexNum in 0 until n) {
                if(index == 0 || indexNum == 0) ways[index][indexNum] = 1
                else ways[index][indexNum] = ways[index-1][indexNum] + ways[index][indexNum - 1]
            }
        }
        return ways[m-1][n-1]
    }

    /**
     * 减少空间复杂度
     * */
    fun uniquePaths2 (m: Int, n: Int) : Int {
        if(m <= 0 || n <= 0) return 0
        val ways = IntArray(n)
        ways[0] = 1
        for (index in 0 until m) {
            for (indexNum in 1 until n) {
                ways[indexNum] += ways[indexNum -1]
            }
        }
        return ways[n-1]
    }
}