package com.garbirel.jetpack.tencent.链表突击

import com.garbirel.jetpack.ListNode
import org.junit.Test

class 旋转链表 {
    @Test
    fun test() {
        val l1 = ListNode(1)
        val l1_1 = ListNode(2)
        val l1_2 = ListNode(3)
        val l1_3 = ListNode(4)
        val l1_4 = ListNode(5)

        l1.next = l1_1
        l1_1.next = l1_2
        l1_2.next = l1_3
        l1_3.next = l1_4
        l1_4.next = null

        var index = rotateRight2(l1,2)
        while(index != null) {
            println(index.`val`)
            index = index.next
        }
    }

    // 首先获取链表的长度，然后用k对链表的长度进行取余k，然后进行k次旋转
    fun rotateRight(head: ListNode?, k: Int): ListNode? {
        if(k == 0) return head
        var lengthNode = 1
        var cur = head
        while(cur?.next != null) {
            lengthNode ++
            cur = cur.next
        }
        val kNew = k % lengthNode

        var fast = head
        var slow = head
        for (index in 0 until kNew) {
            if(fast != null) fast = fast.next
        }

        if(fast == null) return head

        while(fast?.next != null) {
            fast = fast.next
            slow = slow?.next
        }

        fast?.next = head
        fast = slow?.next
        slow?.next = null
        return fast
    }

    // 首先获取链表的长度，然后把链表的头尾链接起来，再往后走lengthNode - k % lengthNode个节点就可以到达新链表的头节点的前一个节点，然后此时断开链表即可
    fun rotateRight2(head: ListNode?, k: Int): ListNode? {
        if(k == 0) return head
        var lengthNode = 1
        var cur = head
        while(cur?.next != null) {
            lengthNode ++
            cur = cur.next
        }
        val kNew = lengthNode - k % lengthNode

        cur?.next = head
        for (index in 0 until kNew) cur  = cur?.next
        val newHead = cur?.next
        cur?.next = null
        return newHead
    }
}