package com.garbirel.jetpack.中级算法.链表

import com.garbirel.jetpack.ListNode
import org.junit.Test

class 相交链表 {
    @Test
    fun test() {
        val l1 = ListNode(2)
        val l1_1 = ListNode(4)
        val l1_2 = ListNode(3)

        l1.next = l1_1
        l1_1.next = l1_2

        val l2 = ListNode(5)
        val l2_1 = ListNode(4)
        val l2_2 = ListNode(3)
        val l2_3 = ListNode(2)

        l2.next = l2_1
        l2_1.next = l2_2
        l2_2.next = l2_3

        var index = getIntersectionNode(l1, l2)
        while(index != null) {
            println(index.`val`)
            index = index.next
        }
    }

    fun getIntersectionNode(headA:ListNode?, headB:ListNode?): ListNode? {
        if (headA == null || headB == null) return null

        var p1 = headA
        var p2 = headB

        while (p1 != p2) {
            p1 = if(p1 == null) headB else p1.next
            p2 = if(p2 == null) headA else p2.next
        }
        return p1
    }
}