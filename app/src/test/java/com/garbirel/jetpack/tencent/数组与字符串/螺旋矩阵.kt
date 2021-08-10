package com.garbirel.jetpack.tencent.数组与字符串

import org.junit.Test

class 螺旋矩阵 {
    @Test
    fun test() {
        val index = spiralOrder(arrayOf(intArrayOf(1,2,3,4), intArrayOf(5,6,7,8), intArrayOf(9,10,11,12)))
        println("---------->>>>>>>    ${index.toList()}")
    }

    private fun spiralOrder(matrix : Array<IntArray>): List<Int> {
        var result = listOf<Int>()
        if(matrix.isEmpty() || matrix[0].isEmpty()) return result
        var left = 0
        var right = matrix[0].size - 1
        var up = 0
        var down = matrix.size - 1

        while(true) {
            for(index in left..right) result = result.plus(matrix[up][index])
            if(++up > down) break

            for(index in up..down) result = result.plus(matrix[index][right])
            if(--right < left) break

            for(index in right downTo left) result = result.plus(matrix[down][index])
            if(--down < up) break

            for(index in down downTo up) result = result.plus(matrix[index][left])
            if(++left > right) break
        }
        return result
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
                matrix[index][left] = count ++
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