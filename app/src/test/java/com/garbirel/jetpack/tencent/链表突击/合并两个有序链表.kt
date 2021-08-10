package com.garbirel.jetpack.tencent.链表突击

import com.garbirel.jetpack.ListNode
import org.junit.Test

class 合并两个有序链表 {
    @Test
    fun test() {
        val l1 = ListNode(1)
        val l1_1 = ListNode(3)
        val l1_2 = ListNode(7)

        l1.next = l1_1
        l1_1.next = l1_2

        val l2 = ListNode(2)
        val l2_1 = ListNode(8)
        val l2_2 = ListNode(9)
        l2.next = l2_1
        l2_1.next = l2_2

        var index = mergeTwoLists(l1,l2)
        while(index != null) {
            println(index.`val`)
            index = index.next
        }
    }

    fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
        val tempNode = ListNode(0)
        var dump = tempNode
        var tempL1 = l1
        var tempL2 = l2
        return when {
            l1 == null -> l2
            l2 == null -> l1
            else -> {
                while (tempL1 != null || tempL2 != null) {
                    val temp1 = tempL1?.`val` ?: 101
                    val temp2 = tempL2?.`val` ?: 101
                    if (temp1 > temp2) {
                        dump.next = ListNode(temp2)
                        if (tempL2 != null) tempL2 = tempL2.next
                    } else {
                        dump.next = ListNode(temp1)
                        if (tempL1 != null) tempL1 = tempL1.next
                    }
                    dump = dump.next!!
                }
                tempNode.next
            }
        }
    }
}