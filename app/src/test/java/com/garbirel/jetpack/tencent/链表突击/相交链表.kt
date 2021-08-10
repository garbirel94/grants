package com.garbirel.jetpack.tencent.链表突击

import com.garbirel.jetpack.ListNode
import org.junit.Test

/**
 * 根据相交时，路程相等原理。两个指针分别指向两链表的头结点，同时遍历链表，到达尾节点后指向另一个链表的头结点，直至两结点相等（相交），即为相交的起始结点
 * */
class 相交链表 {
    @Test
    fun test() {
        val l1 = ListNode(2)
        val l1_1 = ListNode(3)
        val l1_2 = ListNode(9)

        l1.next = l1_1
        l1_1.next = l1_2

        val l2 = ListNode(1)
        val l2_1 = ListNode(3)
        val l2_2 = ListNode(9)

        l2.next = l2_1
        l2_1.next = l2_2

        var index = getIntersectionNode(l1,l2)
        while(index != null) {
            println(index.`val`)
            index = index.next
        }
    }

    fun getIntersectionNode(headA: ListNode?, headB:ListNode?):ListNode? {
        /**
         * 定义两个指针，第一轮让两个到达末尾的节点指向另一个链表的头部，最后如果相遇则为交点
         * 两个指针等于移动了相同的距离，有交点就返回，无交点就是各走了两条指针的长度
         * */
        if(headA == null || headB == null) {
            return null
        }
        var pA = headA
        var pB = headB
        /**
         * 在这里第一轮体现在pA和pB第一次到达尾部会移向另一链表的表头，而第二轮体现在如果
         * pA或pB相交就返回交点，不想交最后就是null == null
         * */
        while (pA != pB) {
            pA = if(pA == null) headB else pA.next
            pB = if(pB == null) headA else pB.next
        }
        return pA
    }
}