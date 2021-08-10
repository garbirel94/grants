package com.garbirel.jetpack.tencent.链表突击

import com.garbirel.jetpack.ListNode
import org.junit.Test

class 两数相加 {
    @Test
    fun test() {
        val l1 = ListNode(9)
        val l1_1 = ListNode(9)
        val l1_2 = ListNode(9)

        l1.next = l1_1
        l1_1.next = l1_2

        val l2 = ListNode(9)
        val l2_1 = ListNode(6)
        val l2_2 = ListNode(4)

        l2.next = l2_1
        l2_1.next = l2_2

        var index = addTwoNumbers(l1, l2)
        while(index != null) {
            println(index.`val`)
            index = index.next
        }
    }

    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var tempL1 = l1
        var tempL2 = l2
        val dump = ListNode(0)
        var head = dump
        var addOne = 0

        while(tempL1 != null || tempL2 != null) {
            val val1 = tempL1?.`val` ?: 0
            val val2 = tempL2?.`val` ?: 0
            val sum = val1 + val2 + addOne

            addOne = sum / 10
            head.next = ListNode(sum % 10)

            if(tempL1 != null) tempL1 = tempL1.next
            if(tempL2 != null) tempL2 = tempL2.next

            head = head.next!!

            if(addOne > 0) {
                head.next = ListNode(addOne)
            }
        }

        return dump.next
    }
}