package com.garbirel.jetpack.算法面试题汇总.递归

import org.junit.Test

/**
 * 1823
 * */
class 找出游戏的获胜者 {
    @Test
    fun test() {
        val index = findTheWinner(5,2)
        println("------------>>>>>>>>>       $index")
    }

    fun findTheWinner(n: Int, k: Int): Int {
        return circle(n,k) + 1
    }

    fun circle (num: Int,k: Int) : Int {
        return if (num == 1) {
            0
        } else {
            (circle(num-1,k) + k) % num
        }
    }
}