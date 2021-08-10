package com.garbirel.jetpack.tencent.链表突击

import com.garbirel.jetpack.ListNode
import org.junit.Test

class 环形链表2 {
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

        var index = detectCycle(l1)
        while(index != null) {
            println(index.`val`)
            index = index.next
        }
    }

    fun detectCycle(head: ListNode?): ListNode? {
        if(head?.next == null) {
            return null
        }
        var slow = head
        var fast = head
        while(fast?.next != null) {
            slow = slow?.next
            fast = fast.next!!.next
            if (fast == slow) break
        }
        if(fast?.next == null) return null
        slow = head
        while (fast != slow) {
            slow = slow?.next
            fast = fast?.next
        }
        return fast
    }
}