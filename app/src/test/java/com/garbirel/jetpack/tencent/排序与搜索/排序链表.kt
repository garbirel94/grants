package com.garbirel.jetpack.tencent.排序与搜索

import com.garbirel.jetpack.ListNode
import org.junit.Test

class 排序链表 {
    @Test
    fun test() {
        val l1 = ListNode(1)
        val l1_1 = ListNode(7)
        val l1_2 = ListNode(3)
        val l1_3 = ListNode(2)

        l1.next = l1_1
        l1_1.next = l1_2
        l1_2.next = l1_3

        var index = sortList(l1)
        while(index != null) {
            println(index.`val`)
            index = index.next
        }
    }

    fun sortList(head: ListNode?): ListNode? {
        return if(head == null) head else mergeSort(head)
    }

    /**
     * 链表的双指针
     * */
    fun mergeSort(head: ListNode) : ListNode {
        if(head.next == null) {
            return head
        }
        var slow : ListNode? = head
        var fast : ListNode? = head
        var sign : ListNode? = null
        while(fast?.next != null) {
            sign = slow
            slow = slow?.next
            fast = fast.next?.next
        }
        sign?.next = null
        val left = mergeSort(head)
        val right = mergeSort(slow!!)
        return merge(left,right)
    }

    fun merge(l1: ListNode,l2: ListNode) : ListNode {
        var l : ListNode? = l1
        var r : ListNode? = l2
        val dummyHead = ListNode(0)
        var cur : ListNode? = dummyHead
        while(l != null && r != null) {
            if(l.`val` <= r.`val`) {
                cur?.next = l
                cur = cur?.next
                l = l.next
            } else {
                cur?.next = r
                cur = cur?.next
                r = r.next
            }
        }
        if(l != null) cur?.next = l
        if(r != null) cur?.next = r
        return dummyHead.next!!
    }
}