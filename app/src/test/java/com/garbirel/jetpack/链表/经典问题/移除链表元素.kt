package com.garbirel.jetpack.链表.经典问题

import com.garbirel.jetpack.ListNode
import org.junit.Test

class 移除链表元素 {
    @Test
    fun test() {
        val l1 = ListNode(7)
        val l1_1 = ListNode(7)
        val l1_2 = ListNode(7)
        val l1_3 = ListNode(7)

        l1.next = l1_1
        l1_1.next = l1_2
        l1_2.next = l1_3
        l1_3.next = null

        var index = removeElements(l1,7)
        while(index != null) {
            println(index.`val`)
            index = index.next
        }

    }

    fun removeElements(head: ListNode?, `val`: Int): ListNode? {
        var result = head
        var pre : ListNode? = null
        var temp = head
        while (temp != null) {
            if(temp.`val` == `val`) {
                val tempSec = temp.next
                if(pre != null) {
                    pre.next = tempSec
                } else result = tempSec
            } else {
                pre = temp
            }
            temp = temp.next
        }
        return result
    }
}