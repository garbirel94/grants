package com.garbirel.jetpack.tencent.动态规划

import org.junit.Test

class 买卖股票的最佳时机 {
    @Test
    fun test() {
        val index = maxProfit(intArrayOf(7,1,5,3,6,4))
        println("------>>>>>>     $index")
    }

    // 一次交易
    fun maxProfit(prices: IntArray): Int {
        var lowPrice = Int.MAX_VALUE
        var maxPrice = 0
        for (index in prices) {
            if (index < lowPrice) {
                lowPrice = index
            } else if (index - lowPrice > maxPrice) {
                maxPrice = index - lowPrice
            }
        }
        return maxPrice
    }

    // 可以一次交易，也可以多次交易。升级版，追求最大的收益
    fun maxProfit2 (prices: IntArray) : Int {
        if(prices.size < 2)  return 0

        return 0
    }
}