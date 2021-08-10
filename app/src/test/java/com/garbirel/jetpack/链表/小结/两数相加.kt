package com.garbirel.jetpack.链表.小结

import com.garbirel.jetpack.ListNode
import org.junit.Test

class 两数相加 {
    @Test
    fun test() {

    }

    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        val tempNode = ListNode(0)
        var dumpNode = tempNode
        var tempL1 = l1
        var tempL2 = l2
        var addOne = 0
        while(tempL1 != null || tempL2 != null) {
            val num1 = tempL1?.`val` ?: 0
            val num2 = tempL2?.`val` ?: 0
            val sum = num1 + num2 + addOne

            addOne = sum / 10
            dumpNode.next = ListNode(sum % 10)

            tempL1 = tempL1?.next
            tempL2 = tempL2?.next

            dumpNode = dumpNode.next!!

            if(addOne > 0) {
                dumpNode.next = ListNode(addOne)
            }
        }
        return tempNode.next
    }
}