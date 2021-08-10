package com.garbirel.jetpack.链表.经典问题

import com.garbirel.jetpack.ListNode
import org.junit.Test

class 奇偶链表 {
    @Test
    fun test() {
        val l1 = ListNode(1)
        val l1_1 = ListNode(3)
        val l1_2 = ListNode(7)

        l1.next = l1_1
        l1_1.next = l1_2
        l1_2.next = null

        var index = oddEvenList(l1)
        while(index != null) {
            println(index.`val`)
            index = index.next
        }
    }

    fun oddEvenList(head: ListNode?): ListNode? {
        if(head?.next == null) return head
        var odd = head
        var even = head.next
        val temp = even
        while (even?.next != null) {
            odd?.next = even.next
            odd = odd?.next
            even.next = odd?.next
            even = even.next
        }
        odd?.next = temp
        return head
    }
}