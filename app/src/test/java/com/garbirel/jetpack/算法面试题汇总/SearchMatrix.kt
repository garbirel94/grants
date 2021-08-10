package com.garbirel.jetpack.算法面试题汇总

import org.junit.Test
import java.lang.StringBuilder
import java.util.*
import kotlin.collections.ArrayList

class SearchMatrix {
    @Test
    fun test () {
        val index = calculate("3+5 / 2")
//        val index = searchMatrix2(arrayOf(intArrayOf(-5)),-5)
//        val index = searchMatrix(arrayOf(intArrayOf(1,4,7,11,15),intArrayOf(2,5,8,12,19),intArrayOf(3,6,9,16,22),intArrayOf(10,13,14,17,24),intArrayOf(18,21,23,26,30)),20)
        println("-------->>>>>>>>>>      $index")
    }

    private fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        for (index in matrix) {
            var low = 0
            var high = index.size - 1
            while (low <= high) {
                val mid = ((low + high) / 2.0).toInt()
                if (target == index[mid]){
                    return true
                } else if ( target < index[mid]) {
                    high = mid - 1
                } else if (target > index[mid]) {
                    low = mid + 1
                } else {
                    break
                }
            }
        }
        return false
    }

    //从左下角开始，左下角的值是这一行中最小，这一列最大的值
    private fun searchMatrix2(matrix: Array<IntArray>, target: Int): Boolean {
        if(matrix.isEmpty()) return false
        if(matrix[0].isEmpty()) return false
        var column = matrix[0].size - 1
        var row = 0
        while (row < matrix.size && column >= 0) {
            if(target == matrix[row][column]){
                return true
            } else {
                if(target > matrix[row][column]) row++ else column--
            }
        }
        return false
    }

    private fun calculate(s: String): Int {
        val sCharArray = s.trim().replace(" ","").split("")
        for (index in 1..(sCharArray.size - 2)) {

        }
        println("---------->>>>>>          ${sCharArray.toList()}")
        return -1
    }

    fun toSuffix(s: String) : StringBuilder{
        var sb = StringBuilder()
        var stack = Stack<Char>()

        for(index in s.indices) {
            if (isNumber(s[index])) {
                var result = getNumAndIndex(s,index)
                sb.append(result[0])
                sb.append(" ")
//                index = result[1]
            }
        }

        return sb
    }

    private fun isNumber(s: Char) : Boolean{
        return s in '0'..'9'
    }

    fun getNumAndIndex (s: String,i : Int) : ArrayList<Int>{
        var num = 0
        var index = i
        for (index in i until s.length) {
            if(isNumber(s.elementAt(index))) {
                num = num.times(10).toChar() + s.elementAt(index).toInt() - '0'
            } else break
        }
        var result = arrayListOf<Int>()
        result.add(num)
        result.add(index)
        return result
    }
}