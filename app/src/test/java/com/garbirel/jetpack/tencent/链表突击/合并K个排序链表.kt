package com.garbirel.jetpack.tencent.链表突击

import com.garbirel.jetpack.ListNode
import org.junit.Test
import java.util.*

/**
 * 利用优先队列先把每个链表加入队列，然后依次出列
 * */
class 合并K个排序链表 {
    @Test
    fun test() {
        val l1 = ListNode(1)
        val l1_1 = ListNode(3)
        val l1_2 = ListNode(7)

        l1.next = l1_1
        l1_1.next = l1_2

        val l2 = ListNode(4)
        val l2_1 = ListNode(6)
        val l2_2 = ListNode(9)

        l2.next = l2_1
        l2_1.next = l2_2

        var index = mergeKLists(arrayOf(l1,l2))
        while(index != null) {
            println(index.`val`)
            index = index.next
        }
    }

    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        val queue = PriorityQueue<ListNode>(kotlin.Comparator { o1, o2 ->
            o1.`val` - o2.`val`
        })
        if(lists.isEmpty()) return null
        for (index in lists.indices) {
            if(lists[index] != null) queue.add(lists[index])
            lists[index] = lists[index]?.next
        }
        val head = ListNode(0)
        var curr = head
        while(queue.isNotEmpty()) {
            val nowNode = queue.poll()
            curr.next = nowNode
            curr = curr.next!!
            if(nowNode.next != null) {
                queue.add(nowNode.next)
            }
        }
        return head.next
    }
}