package com.garbirel.jetpack.tencent.链表突击

import com.garbirel.jetpack.ListNode
import org.junit.Test

class 删除链表中的节点 {
    @Test
    fun test() {

    }

    fun deleteNode(node: ListNode?) {
        node?.`val` = node!!.next!!.`val`
        node.next = node.next!!.next
    }
}