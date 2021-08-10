package com.garbirel.jetpack

import org.junit.Test


class ClimbStairs {
    @Test
    fun test() {
        val index =  convert("PAYPALISHIRING",3)
        println("----------->>>>>>>>>>   $index")
    }

    fun climbStairs (n: Int) : Int {
        if(n < 2) return n
        val result =  mutableListOf(1,2)
        for(index in 2 until n) {
            result.add(index,result[index -1] + result[index -2])
        }
        return result[n -1]
    }

    fun merge (nums1: IntArray, m: Int, nums2: IntArray, n: Int) : IntArray {
        for(index in 0 until n) {
            nums1[m+ index] = nums2[index]
        }
        nums1.sort()
        return nums1
    }

    private fun maxProfit (prices: IntArray) : Int {
        if (prices.size < 2) return 0
        val tempResult = mutableListOf<Int>()
        for (index in 1 until prices.size) {
            var firstTemp = prices[index - 1]
            var tempProfit = 0
            var tempIndex = index
            while (tempIndex < prices.size ) {
                if (prices[tempIndex] > firstTemp) {
                    tempProfit = if(prices[tempIndex] - firstTemp > tempProfit) prices[tempIndex] - firstTemp else tempProfit
                }
                tempIndex ++
            }
            tempResult.add(tempProfit)
        }
        tempResult.sort()
        return tempResult[tempResult.size -1]
    }

    private fun maxProfit2 (prices: IntArray) : Int {
        var minprice = Integer.MAX_VALUE
        var maxprofit = 0
        for (i in prices.indices) {
            if (prices[i] < minprice) {
                minprice = prices[i]
            } else if (prices[i] - minprice > maxprofit) {
                maxprofit = prices[i] - minprice
            }
        }
        return maxprofit
    }

    private fun convert(s: String, numRows: Int): String {
        if (numRows <= 1 || s.length < numRows) {
            return s
        }
        var i = 0
        val n: Int = s.length
        val result = arrayOfNulls<String>(numRows)
        while (i < n) {
            var pos1 = 0
            while (pos1 < numRows && i < n) {
                result[pos1] += s.toCharArray()[i++].toString()
                pos1++
            }
            var pos2 = numRows - 2
            while (pos2 >= 1 && i < n) {
                result[pos2] += s.toCharArray()[i++].toString()
                pos2--
            }
        }
        val builder = StringBuilder()
        for (stringItem in result) {
            builder.append(stringItem!!.substring(4))
        }
        return builder.toString()
    }
}