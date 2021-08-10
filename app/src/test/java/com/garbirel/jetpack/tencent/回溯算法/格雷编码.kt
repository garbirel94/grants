package com.garbirel.jetpack.tencent.回溯算法

import org.junit.Test


class 格雷编码 {
    @Test
    fun test() {
        val info = grayCode(2)
        println("------->>>>>>>    ${info.toList()}")
    }

    fun grayCode(n: Int): List<Int> {
        val res = ArrayList<Int>()
        var i = 0
        while (i < Math.pow(2.0, n.toDouble())) {
            res.add(i shr 1 xor i)
            i++
        }
        return res
    }
}