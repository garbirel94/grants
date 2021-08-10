package com.garbirel.jetpack.链表.双指针技巧

import com.garbirel.jetpack.ListNode
import org.junit.Test

class 删除链表中的倒数第N个节点 {
    @Test
    fun test() {
    }

    /**
     * 反转链表，然后遍历出第N个节点进行删除
     * */
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        if(head == null) return null
        var num = reverse(head)
        var temp = num
        var count = 0
        var prev : ListNode? = null

        while(temp != null) {
            if(count + 1 == n) {
                val tempSec = temp.next
                if(prev != null) {
                    prev.next = tempSec
                } else {
                    num = tempSec
                }
                break
            }
            count++
            prev = temp
            temp = temp.next
        }
        return reverse(num)
    }

    fun reverse(head: ListNode?) : ListNode? {
        if(head?.next == null) return head
        val p = reverse(head.next)
        head.next!!.next = head
        head.next = null
        return p
    }

    /**
     * 使用题目推荐的双指针
     * */
    fun removeNthFromEnd2(head: ListNode?, n: Int): ListNode? {
        var slow = head
        var fast = head
        var count = n
        while (count >= 0) {
            fast = fast?.next
            count--
        }
        while(fast != null) {
            slow = slow?.next
            fast = fast.next
        }
        val pre = slow
        pre?.next = slow?.next?.next
        return head
    }
}