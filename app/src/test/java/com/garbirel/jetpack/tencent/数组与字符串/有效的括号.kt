package com.garbirel.jetpack.tencent.数组与字符串

import org.junit.Test
import java.util.*

class 有效的括号 {
    @Test
    fun test () {
        var index = isValid("]]")
        println("-------------->>>>>>>>      $index")
    }

    fun isValid(s: String): Boolean {
        val stack = Stack<Char>()
        for(index in s.toCharArray()) {
            if(index == '{' || index == '(' || index == '[') {
                stack.push(index)
            } else {
               if(stack.isEmpty()) return false
               if((index == '}' && stack.pop() == '{') || (index == ')' && stack.pop() == '(') || (index == ']' && stack.pop() == '[')) {
                   continue
               } else return false
            }
        }
        return stack.isEmpty()
    }
}