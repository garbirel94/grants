package com.garbirel.jetpack.tencent.数组与字符串

import org.junit.Test

class 字符串相乘 {
    @Test
    fun test () {
        val index = multiply2("456","123")
        println("-------->>>>>>>>>     $index")
    }

    /**
     * 模拟人做乘法，两个数相乘，首先将第一个数和第二个数的最后一位相乘，然后将第一个数和第二个数的倒数第二位相乘并左移一位和之前的结果相加，这里就要用到大整数的加法。
     * */
    fun multiply(num1: String,num2: String) : String {
        if(num1 == "0" || num2 == "0") return "0"
        if(num1 == "1") return num2
        if(num2 == "1") return num1

        var args = ""
        var j = 0
        for (index in num2.length - 1 downTo 0) {
            var mulRes = mul(num1,num2[index])
            for(num in 0 until j) {
                mulRes += "0"
            }
            args = add(args,mulRes)
            j++
        }
        return args
    }

    fun mul(str : String, c : Char) : String {
        var carry = 0
        var res = ""
        for(index in str.length - 1 downTo 0) {
            val t = (str[index] - '0') * (c - '0') + carry
            res = (t % 10).toString() + res
            carry = t / 10
        }
        if(carry != 0) res = carry.toString() + res
        return res
    }

    fun add(s1: String,s2 : String) : String {
        if (s1 == "" || s1 == "0") return s2
        if (s2 == "" || s2 == "0") return s1

        var l1 = s1.length - 1
        var l2 = s2.length -1
        var carry = 0
        var ans = ""
        while(l1 >= 0 || l2 >= 0) {
            val x = if(l1 >= 0) s1[l1] else '0'
            val y = if(l1 >= 0) s2[l2] else '0'
            val s = (x -'0') + (y - '0') + carry
            ans = (s % 10).toString() + ans
            carry = s /10
            if(l1 >= 0) l1--
            if(l2 >= 0) l2--
        }
        if(carry != 0) ans = "1$ans"
        return ans
    }

    /**
     * 长为n的数和长为m的数相乘的结果最大长度为m+n;
     * 结果存在数组res中，num1[i]*num2[j]的结果为两位数tmp（0x或者xy），其中第一位位于res[i+j], 第二位位于res[i+j+1]
     * */
    fun multiply2(num1: String,num2: String) : String {
        if(num1 == "0" || num2 == "0") return "0"
        if(num1 == "1") return num2
        if(num2 == "1") return num1

        val result =  IntArray(num1.length + num2.length)
        for(index in num1.length - 1 downTo 0) {
            val n1 = num1[index] - '0'
            for(index2 in num2.length - 1 downTo 0) {
                val n2 = num2[index2] - '0'
                val s = result[index + index2 + 1] + n1 * n2
                result[index + index2 + 1] = s % 10
                result[index + index2] = s/ 10 + result[index + index2]
            }
        }
        var ans = ""
        for(index in 0 until (num1.length + num2.length)) {
            if(index == 0 && result[index] == 0) continue
            ans += result[index].toString()
        }
        return ans
    }
}