package com.garbirel.jetpack.tencent.链表突击

import com.garbirel.jetpack.ListNode
import org.junit.Test

class 环形链表 {
    @Test
    fun test() {
        val l1 = ListNode(1)
        val l1_1 = ListNode(3)
        val l1_2 = ListNode(7)
        val l1_3 = ListNode(8)

        l1.next = l1_1
        l1_1.next = l1_2
        l1_2.next = l1_3
        l1_3.next = l1_2

        val index = hasCycle(l1)
        println("------->>>>>>>      $index")
    }

    fun hasCycle(head: ListNode?): Boolean {
        if(head?.next == null) {
            return false
        }
        var slow = head
        var fast = head.next
        while(slow != fast) {
            if(fast?.next == null) return false
            slow = slow?.next
            fast = fast.next!!.next
        }
        return true
    }
}