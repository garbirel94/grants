package com.garbirel.jetpack.链表.小结

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
        l1_2.next = null

        val l2 = ListNode(2)
        val l2_1 = ListNode(8)
        val l2_2 = ListNode(9)
        l2.next = l2_1
        l2_1.next = l2_2
        l2_2.next = null

        var index = mergeTwoLists(l1,l2)
        while(index != null) {
            println(index.`val`)
            index = index.next
        }
    }

    fun mergeTwoLists (l1: ListNode?, l2: ListNode?) : ListNode? {
        val tempNode = ListNode(0)
        var dumpNode = tempNode
        var l1 = l1
        var l2 = l2
        return when {
            l1 == null -> l2
            l2 == null -> l1
            else -> {
                while (l1 != null || l2 != null) {
                    val temp1 = l1?.`val` ?: 101
                    val temp2 = l2?.`val` ?: 101
                    if(temp1 <= temp2) {
                        dumpNode.next = ListNode(temp1)
                        l1 = l1?.next
                    } else {
                        dumpNode.next = ListNode(temp2)
                        l2 = l2?.next
                    }
                    dumpNode = dumpNode.next!!
                }
                tempNode.next
            }
        }
    }
}