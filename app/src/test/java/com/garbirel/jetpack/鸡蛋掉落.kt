package com.garbirel.jetpack

import org.junit.Test

class 鸡蛋掉落 {
    @Test
    fun test() {
        val index = superEggDrop(100,2)
        println("-------->>>>>>      $index")
    }

    fun superEggDrop (k: Int, n: Int) : Int {
        var remainTestCount = 1
        while(getConfirmFloors(remainTestCount,k) < n) {
            ++remainTestCount
        }
        return remainTestCount
    }

    fun getConfirmFloors(remainTestCount : Int, eggsCount : Int) : Int{
        if(remainTestCount == 1 || eggsCount == 1) {
            return remainTestCount
        }
        return getConfirmFloors(remainTestCount -1,eggsCount -1) + 1 + getConfirmFloors(remainTestCount -1 ,eggsCount)
    }
}