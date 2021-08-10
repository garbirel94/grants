package com.garbirel.jetpack.tencent.设计

import java.util.*

class 最小栈 {
    fun test() {

    }
}

/**
 * 使用一个栈➕最小值  目前有一点问题
 *
    ["MinStack","push","push","push","push","getMin","pop","getMin","pop","getMin","pop","getMin"]
    [[],[2],[0],[3],[0],[],[],[],[],[],[],[]]
 * */
class MinStack() {
    var stack = Stack<Int>()
    var minVal : Int = Integer.MAX_VALUE

    /** initialize your data structure here. */
    fun MinStack() {
        minVal = Integer.MAX_VALUE
    }

    fun push(`val`: Int) {
        if(`val` <= minVal) {
            stack.push(minVal)
            minVal = `val`
        }
        stack.push(`val`)
    }

    fun pop() {
        val index = stack.peek()
        stack.pop()
        if(index == minVal) {
            minVal = stack.peek()
            stack.pop()
        }
    }

    fun top(): Int {
        return stack.peek()
    }

    fun getMin(): Int {
        return minVal
    }
}

/**
 * 使用2个栈
 *
["MinStack","push","push","push","push","getMin","pop","getMin","pop","getMin","pop","getMin"]
[[],[2],[0],[3],[0],[],[],[],[],[],[],[]]
 * */
class MinStack2() {
    var stack = Stack<Int>()
    var helper = Stack<Int>()

    /** initialize your data structure here. */
    fun MinStack2(){}


    fun push(`val`: Int) {
        stack.push(`val`)
        if(helper.isEmpty() || helper.peek() >= `val`) {
            helper.add(`val`)
        } else {
            helper.add(helper.peek())
        }
    }

    fun pop() {
        if (stack.isNotEmpty()) {
            stack.pop()
            helper.pop()
        }
    }

    fun top(): Int {
        if(stack.isNotEmpty()) {
            return stack.peek()
        }
        throw RuntimeException("栈为空")
    }

    fun getMin(): Int {
        if(helper.isNotEmpty()) {
            return helper.peek()
        }
        throw RuntimeException("栈为空")
    }
}