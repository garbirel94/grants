package com.garbirel.jetpack.中级算法.数组和字符串

import org.junit.Test

class 矩阵置零 {
    @Test
    fun test() {

    }

    /**
     * 使用 m+n 的空间，
     * */
    fun setZeroes(matrix: Array<IntArray>): Unit {
        val rowSize = matrix.size
        val columnSize = matrix[0].size
        val zeros = BooleanArray(rowSize + columnSize)

        for (indexRow in 0 until rowSize) {
            for (indexColumn in 0 until columnSize) {
                if(matrix[indexRow][indexColumn] == 0) {
                    zeros[indexRow] = true
                    zeros[rowSize + indexColumn] = true
                }
            }
        }

        for (indexRow in 0 until rowSize) {
            for (indexColumn in 0 until columnSize) {
                if(zeros[indexRow]) {
                    matrix[indexRow][indexColumn] = 0
                }
                if(zeros[indexColumn + rowSize]) {
                    matrix[indexRow][indexColumn] = 0
                }
            }
        }
    }
}