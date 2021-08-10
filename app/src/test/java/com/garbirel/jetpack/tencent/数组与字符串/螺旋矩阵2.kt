package com.garbirel.jetpack.tencent.数组与字符串

import org.junit.Test
import kotlin.Array

class 螺旋矩阵2 {
    @Test
    fun test() {
        val result = generateMatrix(3)
        println(result[0].toList())
        println(result[1].toList())
        println(result[2].toList())
    }

    fun generateMatrix (n: Int) : Array<IntArray>{
        var left = 0
        var right = n - 1
        var top = 0
        var bottom = n - 1
        val nums = n * n
        var count = 1
        val matrix = Array(size = n, init = { IntArray(n) })
        while (true) {
            for(index in left..right) {
                matrix[top][index] = count++
            }
            if(count > nums) break
            for(index in top+1..bottom) {
                matrix[index][right] = count++
            }
            if(count > nums) break
            for(index in right-1 downTo left) {
                matrix[bottom][index] = count++
            }
            if(count > nums) break
            for(index in bottom-1 downTo top+1) {
                matrix[index][left] = count++
            }
            if(count > nums) break
            left += 1
            top += 1
            right -= 1
            bottom -= 1
        }
        return matrix
    }
}