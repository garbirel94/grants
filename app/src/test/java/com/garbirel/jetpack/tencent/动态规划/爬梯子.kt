package com.garbirel.jetpack.tencent.动态规划

import org.junit.Test

class 爬梯子 {
    @Test
    fun test() {
        val index = climbStairs2(3)
        println("--------->>>>>>>>       $index")
    }

    // 此方法解起来不知为何效率比较低下，空间复杂度高了点
    fun climbStairs(n: Int): Int {
        if(n < 2) return n
        val result = mutableListOf<Int>(1,2)
        for(index in 2 until n) {
            result.add(index,result[index - 1] + result[index -2])
        }
        return result[n - 1]
    }

    // 空间复杂度降低到O(1) 跟上面方法差不多
    fun climbStairs2(n: Int): Int {
        var p = 0
        var q = 0
        var r = 1
        for(index in 1..n) {
            p = q
            q = r
            r = p + q
        }
        return r
    }

    // 矩阵快速幂  这个关系到齐次和非齐次线性方程
    // 通项公式
}