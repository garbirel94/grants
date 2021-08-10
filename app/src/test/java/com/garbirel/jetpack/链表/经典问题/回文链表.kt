package com.garbirel.jetpack.链表.经典问题

import com.garbirel.jetpack.ListNode
import org.junit.Test

class 回文链表 {
    @Test
    fun test() {
        val l1 = ListNode(1)
        val l1_1 = ListNode(3)
        val l1_2 = ListNode(3)

        l1.next = l1_1
        l1_1.next = l1_2
        l1_2.next = null

        var index = isPalindrome(l1)
        println("--------->>>>>>>    $index")
    }

    fun isPalindrome(head: ListNode?): Boolean {
        // 取链表的长度
        var nodeTemp = head
        var length = 0
        while(nodeTemp != null) {
            length++
            nodeTemp = nodeTemp.next
        }
        // 根据长度进行循环。并进行链表反转
        var nodeTempSec = head
        var nodeTempThird : ListNode ?= null
        for(index in 0 until length/2) {
            nodeTemp = nodeTempSec?.next
            nodeTempSec?.next = nodeTempThird
            nodeTempThird = nodeTempSec
            nodeTempSec = nodeTemp
        }

        if(length % 2 == 1) {
            nodeTemp = nodeTemp?.next
        }

        while (nodeTemp != null && nodeTempThird != null) {
            if(nodeTemp.`val` != nodeTempThird.`val`)  return false
            nodeTemp = nodeTemp.next
            nodeTempThird = nodeTempThird.next
        }
        return true
    }
}