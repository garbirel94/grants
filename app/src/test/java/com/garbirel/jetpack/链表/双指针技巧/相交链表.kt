package com.garbirel.jetpack.链表.双指针技巧

import com.garbirel.jetpack.ListNode
import org.junit.Test

class 相交链表 {
    @Test
    fun test() {

    }

    fun getIntersectionNode(headA: ListNode?, headB:ListNode?):ListNode? {
        /**
         * 只要有其中一个为空，则不相交
         * */
        if(headA == null || headB == null) return null

        var pA = headA
        var pB = headB
        /**
         * 在这里第一轮体现在pA和pB第一次到达尾部会移向另一链表的表头，而第二轮体现在如果
         * pA或pB相交就返回交点，不想交最后就是 null == null
         * */
        while(pA != pB) {
            pA = if(pA == null) headB else pA.next
            pB = if(pB == null) headA else pB.next
        }
        return pA
    }
}