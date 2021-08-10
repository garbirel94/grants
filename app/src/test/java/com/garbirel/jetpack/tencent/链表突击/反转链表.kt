package com.garbirel.jetpack.tencent.链表突击

import com.garbirel.jetpack.ListNode
import org.junit.Test

class 反转链表 {
    @Test
    fun test() {
        val l1 = ListNode(1)
        val l1_1 = ListNode(3)
        val l1_2 = ListNode(7)

        l1.next = l1_1
        l1_1.next = l1_2
        l1_2.next = null

        var index = reverseList(l1)
        while(index != null) {
            println(index.`val`)
            index = index.next
        }
    }

    //  递归 时间复杂度O(n) 空间复杂度O(n)
    fun reverseList (head: ListNode?) : ListNode? {
        if(head?.next == null) return head
        val p = reverseList(head.next)
        head.next!!.next = head
        head.next = null
        return p
    }

    //  迭代 时间复杂度O(n) 空间复杂度O(1)
    fun reverseList2(head: ListNode?) : ListNode? {
        var pre : ListNode? = null
        var curr = head
        while (curr != null) {
            val next = curr.next
            curr.next = pre
            pre = curr
            curr = next
        }
        return curr
    }
}