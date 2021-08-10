package com.garbirel.jetpack.tencent.附加

import org.junit.Test

/**
 * 感觉是找规律，然后得出最终的结论
 * */
class Nim游戏 {
    @Test
    fun test() {

    }

    fun canWinNim(n: Int): Boolean {
        return n % 4 != 0
    }
}