package com.garbirel.jetpack.链表.双指针技巧

import com.garbirel.jetpack.ListNode
import org.junit.Test

class 环形链表 {
    @Test
    fun test() {

    }


    fun hasCycle(head: ListNode?): Boolean {
        if(head?.next == null) {
            return false
        }
        var slow = head
        var fast = head.next
        while(slow != fast) {
            if(fast?.next == null) return  false
            slow = slow?.next
            fast = fast.next?.next
        }
        return true
    }
}