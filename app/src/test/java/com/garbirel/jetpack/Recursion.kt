package com.garbirel.jetpack

import org.junit.Test

class Recursion {
    @Test
    fun Test() {
        var index = longestSubstring("adassds", 5)
        println("--------->>>>>>>>   ${index.toList()}")
//        println("--------->>>>>>>>   $index")
    }

    fun reverseString(s: CharArray) : CharArray {
        return s.reversed().toCharArray()
    }

    fun swapPairs(head: ListNode?): ListNode? {
        return head
    }

    fun generate(numRows: Int): List<List<Int>> {
        val result =  ArrayList<ArrayList<Int>>()
        for(index in 1..numRows) {
            val listTemp = ArrayList<Int>()
            when (index) {
                1 -> {
                    listTemp.add(1)
                }
                2 -> {
                    listTemp.add(1)
                    listTemp.add(1)
                }
                else -> {
                    for(indexSecond in 1..index) {
                        when (indexSecond) {
                            1,index -> listTemp.add(1)
                            else -> listTemp.add(result[index - 2][indexSecond - 2] + result[index - 2][indexSecond - 1])
                        }
                    }
                }
            }
            result.add(listTemp)
        }
        return result
    }

    fun reverseList(head : ListNode?) : ListNode? {
        if(head?.next == null) return head
        val p = reverseList(head.next)
        head.next!!.next = head
        head.next = null
        return p
    }

    fun myPow(x: Double, n: Int) : Double {
        if(x == 1.0) return x
        var xTemp = x
        var nTemp = n
        if(n < 0) {
            xTemp = 1/x
            nTemp = if(n == -2147483648) -n-1 else -n
        }
        var result = 1.0
        for(index in 1..nTemp)
            result *= xTemp
        return result
    }

    fun myPow1(x: Double, n: Int) : Double {
        if(x == 1.0) return x
        var result = if(n > 0) myPowMemory(x,n) else 1.0/ myPowMemory(x,if(n == -2147483648) -n-1 else -n)
        return if(n % 2 == 0 || result == 0.0) Math.abs(result) else result
    }

    fun myPowMemory(x: Double, n: Int) : Double {
        if(n == 0) return 1.0
        val half = myPowMemory(x,n /2)
        return if(n % 2 == 0) half * half
        else half * half * x
    }

    fun kthGrammar(N: Int, K: Int): Int {
        if (N == 1) return 0
        return K.inv() and 1 xor kthGrammar(N - 1, (K + 1) / 2)
    }

    fun longestSubstring(s: String, k: Int): CharArray {
        var sTemp : CharArray = s.toCharArray()
        sTemp.sort()
        return sTemp
    }
}