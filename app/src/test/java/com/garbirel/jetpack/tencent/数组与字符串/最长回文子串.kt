package com.garbirel.jetpack.tencent.数组与字符串

import org.junit.Test

//"回文串”是一个正读和反读都一样的字符串，比如“level”或者“noon”等等就是回文串。
class 最长回文子串 {
    @Test
    fun test() {
        val index = longestPalindrome("ac")
        println("---------->>>>>>>       $index")
    }

    fun longestPalindrome(s: String): Int {
//        if(s.length < 2) return s
        var sb = StringBuffer()
        for(index in s) {
            sb.append("#")
            sb.append(index)
        }
        sb.append("#")
        val chs = sb.toString().toCharArray()
        println("-------->>>>>>>>  ${chs.toList()}")
        var max_len = 0
        for(index in chs.indices) {
            max_len = Math.max(subpalidromelen(chs,index),max_len)
        }
        return max_len
    }

    fun subpalidromelen (chs : CharArray,i : Int) : Int {
        var len=0
        for (index in 0..i) {
            if (index < chs.size - i) {
                if (chs[i - index] == chs[i + index]) {
                    len ++
                }
            } else break
        }
        return len-1
    }

    fun longestPalindrome2 (s: String): String {
        if(s.length < 2) return s
        var strStart = 0    // 最长回文子串起始位置
        var strEnd = 0      // 最长回文子串终止位置
        var startIndex = 0  // 当前子串起始索引
        var endIndex = 0    // 当前子串终止索引
        var nowIndex = 0    // 记录探索的位置

        // 检查回文子串长度
        fun checkLength() {
            while (0 <= startIndex && endIndex < s.length && s[startIndex] == s[endIndex]) {
                if ((strEnd-strStart) < (endIndex - startIndex)) {
                    strEnd = endIndex
                    strStart = startIndex
                }
                startIndex--
                endIndex++
            }
        }

        while (nowIndex < s.length) {
            // 奇数个回文字符
            startIndex = nowIndex - 1
            endIndex = nowIndex + 1
            checkLength()
            // 偶数个回文字符
            startIndex = nowIndex
            endIndex = nowIndex + 1
            checkLength()
            nowIndex++
        }
        return s.substring(strStart, strEnd+1)
    }

    fun longestPalindrome3 (s: String): String {
        val len = s.length
        if(len < 2) return s
        var maxLen = 1
        var res = s.substring(0,1)
        for(index in 0 until len -1) {
            val oddStr = centerSpread(s,index,index)
            val evenStr = centerSpread(s,index,index + 1)
            val maxLenStr = if(oddStr.length > evenStr.length) oddStr else evenStr
            if(maxLenStr.length > maxLen) {
                maxLen = maxLenStr.length
                res = maxLenStr
            }
        }
        return res
    }

    fun centerSpread(s: String,left : Int,right : Int) : String {
        // left = right 的时候，此时回文中心是一个空隙，回文串的长度是奇数
        // right = left + 1 的时候，此时回文中心是任意一个字符，回文串的长度是偶数
        val length = s.length
        var left = left
        var right = right
        while (left >= 0 && right < length) {
            if(s.elementAt(left) == s.elementAt(right)) {
                left--
                right++
            } else break
        }
        return s.substring(left + 1,right)
    }
}