package com.garbirel.jetpack.tencent.动态规划

import org.junit.Test
import java.util.*

class 买卖股票的最佳时机II {
    @Test
    fun test() {
        val index  = maxProfit2(intArrayOf(1,2))
        println("--------->>>>>>>>>    $index")
    }

    fun maxProfit(prices: IntArray): Int {
        var sum = 0
        if(prices.size < 2) return sum
        val stack = Stack<Int>()
        for(index in 1 until prices.size) {
            if (prices[index] < prices[index -1]) {
                if(stack.isEmpty()) {
                    stack.push(prices[index])
                } else {
                    sum += prices[index - 1] - stack.pop()
                    stack.push(prices[index])
                }
            } else {
                if(stack.isEmpty()) {
                    if(index == prices.size - 1) sum += prices[index] - prices[index -1 ]
                    else stack.push(prices[index -1])
                } else if (index == prices.size - 1 && stack.isNotEmpty()){
                    sum += prices[index] - stack.pop()
                }
            }
        }
        return sum
    }

    /**
     * 贪心算法
     * */
    fun maxProfit2(prices: IntArray): Int {
        if(prices.size < 2) return 0
        var sum = 0
        for(index in 0 until prices.size -1) {
            val temp = prices[index + 1] - prices[index]
            if(temp > 0) sum += temp
        }
        return sum
    }
}