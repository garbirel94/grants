package com.garbirel.jetpack.链表.双链表

import org.junit.Test

/**
 * 选择使用双链表
 * */
class 设计链表 {
    @Test
    fun test() {
        val linkedList = MyLinkList()
        linkedList.addAtHead(2)
        linkedList.deleteAtIndex(1)
        linkedList.addAtHead(2)
        linkedList.addAtHead(7)
        linkedList.addAtHead(3)
        linkedList.addAtHead(2)
        linkedList.addAtHead(5)
        linkedList.addAtTail(9)
        linkedList.deleteAtIndex(6)
        linkedList.deleteAtIndex(4)
    }
}

class MyLinkList {
    /** Initialize your data structure here. */
    private var head : ListNode? = null
    private var tail : ListNode? = null
    private var length : Int = 0

    constructor() {
        head = ListNode()
        tail = ListNode()
        head?.next = tail
        tail?.prev = head
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    fun get(index: Int): Int {
        if(index < 0 || index >= length) return -1
        var pre : ListNode ?= null
        return if(index < length - index) {
            pre = head
            for(indexNum in 0 until (index + 1)) {
                pre = pre?.next
            }
            pre?.`val`!!
        } else {
            pre = tail
            for(indexNum in 0 until length - index) {
                pre = pre?.prev
            }
            pre?.`val`!!
        }
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    fun addAtHead(`val`: Int) {
        addAtIndex(0,`val`)
    }

    /** Append a node of value val to the last element of the linked list. */
    fun addAtTail(`val`: Int) {
        addAtIndex(length,`val`)
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    fun addAtIndex(index: Int, `val`: Int) {
        // 如果index < 0,则在头节点插入
        var tempIndex = index
        if(tempIndex < 0) tempIndex = 0
        else if(tempIndex > length) return
        var pre : ListNode ?= null
        if(tempIndex < length - tempIndex) {
            pre = head
            for(indexNum in 0 until tempIndex) {
                pre = pre?.next
            }
            val temp = ListNode(`val`)
            temp.prev = pre
            temp.next = pre?.next
            pre?.next?.prev = temp
            pre?.next = temp
        } else {
            pre = tail
            for(indexNum in 0 until length - tempIndex) {
                pre = pre?.prev
            }
            val temp = ListNode(`val`)
            temp.next = pre
            temp.prev = pre?.prev
            pre?.prev?.next = temp
            pre?.prev = temp
        }
        length++
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    fun deleteAtIndex(index: Int) {
        if(index < 0 || index >= length) return
        var pre : ListNode? = null
        if (index < length - index) {
            pre = head
            for(indexNum in 0 until index) {
                pre = pre?.next
            }
            pre?.next?.next?.prev = pre
            pre?.next = pre?.next?.next
        } else {
            pre = tail
            for(indexNumS in 0 until (length - index -1)) {
                pre = pre?.prev
            }
            pre?.prev?.prev?.next = pre
            pre?.prev = pre?.prev?.prev
        }
        length--
    }
}

class ListNode {
    var `val` = 0
    var next : ListNode? = null
    var prev : ListNode? = null
    constructor(`val`: Int,prev: ListNode?,next: ListNode?) {
        this.`val` = `val`
        this.prev = prev
        this.next = next
    }
    constructor(`val`: Int) {
        this.`val` = `val`
    }

    constructor() {
        this.`val` = 0
    }
}