package com.garbirel.jetpack.tencent.回溯算法

import org.junit.Test

class 括号生成 {
    @Test
    fun test() {
        val index = generateParenthesis(3)
        println("------->>>>>    ${index.toList()}")
    }

    fun generateParenthesis(n: Int): List<String> {
        val ans = ArrayList<String>()
        backTrack(ans,"",0,0,n)
        return ans
    }

    fun backTrack(ans: ArrayList<String>,cur: String,open:Int,close: Int,max:Int) {
        if(cur.length == max*2) {
            ans.add(cur)
            return
        }
        if(open < max) {
            backTrack(ans, "$cur(",open+1,close,max)
        }
        if(close < open) {
            backTrack(ans, "$cur)",open,close+1,max)
        }
    }
}