package com.garbirel.jetpack.中级算法.链表

import com.garbirel.jetpack.ListNode
import org.junit.Test

class 两数相加 {
    @Test
    fun test() {
        val l1 = ListNode(2)
        val l1_1 = ListNode(4)
        val l1_2 = ListNode(3)

        l1.next = l1_1
        l1_1.next = l1_2

        val l2 = ListNode(5)
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

    fun addTwoNumbers (l1: ListNode?, l2: ListNode?) : ListNode? {
        val listNode = ListNode(0)
        var head = listNode
        var l1 = l1
        var l2 = l2
        var addOne = 0
        while(l1 != null || l2 != null) {
            val temp1 = l1?.`val` ?: 0
            val temp2 = l2?.`val` ?: 0
            val sum = temp1 + temp2 + addOne

            head.next = ListNode(sum % 10)
            addOne = sum / 10

            head = head.next!!

            l1 = l1?.next
            l2 = l2?.next

            if(addOne > 0) {
                head.next = ListNode(addOne)
            }
        }
        return listNode.next
    }
}