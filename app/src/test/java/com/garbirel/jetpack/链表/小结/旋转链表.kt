package com.garbirel.jetpack.链表.小结

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

    fun rotateRight(head: ListNode?, k: Int): ListNode? {
        if (k == 0) return head
        var tempNode = head
        var lengthNode = 1
        // 获取链表的长度
        while (tempNode?.next != null) {
            lengthNode ++
            tempNode = tempNode.next
        }
        // 重置tempNode
        tempNode?.next = head

        // 链表经过 lengthNode - k % lengthNode获得链表的新的头节点
        val newK = lengthNode - k % lengthNode

        for (index in 0 until newK)
            tempNode = tempNode?.next

        val newHead = tempNode?.next
        tempNode?.next = null
        return newHead
    }

    /**
     * 使用双指针操作链表
     * */
    fun rotateRight2(head: ListNode?, k: Int): ListNode? {
        if (k == 0) return head
        var tempNode = head
        var lengthNode = 1
        while (tempNode?.next != null) {
            lengthNode++
            tempNode = tempNode.next
        }
        val newK = k % lengthNode
        var fast = head
        var slow = head
        for (index in 0 until newK)
            fast = fast?.next

        if (fast == null) return head

        while (fast?.next != null) {
            fast = fast.next
            slow = slow?.next
        }
        fast?.next = head
        fast = slow?.next
        // 不置为空将造成死循环
        slow?.next = null
        return fast
    }
}
