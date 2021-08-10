package com.garbirel.jetpack.算法面试题汇总.递归

import com.garbirel.jetpack.ListNode
import org.junit.Test

class 链表求和 {
    @Test
    fun test() {

    }

    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var l1 = l1
        var l2 = l2
        val dump = ListNode(0)
        var head = dump
        var addOne = 0

        while(l1 != null || l2 != null) {
            val val1 = l1?.`val` ?: 0
            val val2 = l2?.`val` ?: 0
            val sum = val1 + val2 + addOne

            addOne = sum / 10
            head.next = ListNode(sum % 10)

            if(l1 != null) l1 = l1.next
            if(l2 != null) l2 = l2.next

            head = head.next!!

            if(addOne > 0) {
                head.next = ListNode(addOne)
            }
        }
        return dump.next
    }
}