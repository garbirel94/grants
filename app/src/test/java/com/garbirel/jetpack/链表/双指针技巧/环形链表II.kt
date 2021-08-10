package com.garbirel.jetpack.链表.双指针技巧

import com.garbirel.jetpack.ListNode
import org.junit.Test

class 环形链表II {
    @Test
    fun test() {

    }


    fun detectCycle(head: ListNode?): ListNode? {
        if(head?.next == null) return null
        var slow = head
        var fast = head

        while(fast?.next != null) {
            slow = slow?.next
            fast = fast.next?.next
            if(fast == slow) break
        }
        // 如果快节点到达了尾节点，则代表不是循环链表
        if(fast?.next == null) return null
        slow = head
        while(slow != fast) {
            slow = slow?.next
            fast = fast?.next
        }
        return fast
    }
}