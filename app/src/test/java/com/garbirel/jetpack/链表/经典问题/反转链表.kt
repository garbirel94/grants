package com.garbirel.jetpack.链表.经典问题

import com.garbirel.jetpack.ListNode
import org.junit.Test

class 反转链表 {
    @Test
    fun test() {

    }

    fun reverseList(head: ListNode?): ListNode? {
        if(head?.next == null) return head
        val p = reverseList(head.next)
        head.next?.next = head
        head.next = null
        return p
    }
}