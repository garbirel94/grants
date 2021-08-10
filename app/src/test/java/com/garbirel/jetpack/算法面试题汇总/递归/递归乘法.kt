package com.garbirel.jetpack.算法面试题汇总.递归

import org.junit.Test

class 递归乘法 {
    @Test
    fun test() {
        val index = multiply(3,4)
        println("------->>>>>    $index")
    }

    fun multiply(A: Int, B: Int): Int {
        return if(A>B) add(A,B,0) else add(B,A,0)
    }

    fun add(A: Int, B: Int,sum: Int) : Int{
        return if(B == 0) sum
        else {
            add(A,B-1,sum+A)
        }
    }
}