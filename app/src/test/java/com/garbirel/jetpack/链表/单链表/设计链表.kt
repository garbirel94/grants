package com.garbirel.jetpack.链表.单链表

import com.garbirel.jetpack.ListNode
import org.junit.Test
import java.util.*

/**
 * get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
 * addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
 * addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
 * addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val  的节点。如果 index 等于链表的长度，则该节点将附加到链表的末尾。如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
 * deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。
 * */
class 设计链表 {
    @Test
    fun test() {
        val linkedList = MyLinkedList()
        linkedList.addAtHead(4)
        val indexSec = linkedList.get(1)
        println("--------->>>>>>   $indexSec")

        /*linkedList.addAtHead(1)
        linkedList.addAtTail(3)
        linkedList.addAtIndex(1,2)   //链表变为1-> 2-> 3
        val indexFirst = linkedList.get(1)            //返回2
        println("--------->>>>>>   $indexFirst")
        linkedList.deleteAtIndex(1)  //现在链表是1-> 3
        val indexSec = linkedList.get(1)
        println("--------->>>>>>   $indexSec")*/

//        ["MyLinkedList","addAtHead","addAtTail","addAtHead","addAtTail","addAtHead","addAtHead","get","addAtHead","get","get","addAtTail"]
//        [[],[7],[7],[9],[8],[6],[0],[5],[0],[2],[5],[4]]
        /*linkedList.addAtHead(7)
        linkedList.addAtTail(7)
        linkedList.addAtHead(9)
        linkedList.addAtTail(8)
        linkedList.addAtHead(6)
        linkedList.addAtHead(0)
        val r1 = linkedList.get(5)
        println("--------->>>>>>   $r1")
        linkedList.addAtHead(0)
        val r2 = linkedList.get(2)
        println("--------->>>>>>   $r2")
        val r3 = linkedList.get(5)
        println("--------->>>>>>   $r3")
        linkedList.addAtTail(4)*/
    }
}

class MyLinkedList() {
    /** Initialize your data structure here. */
    private var linkNode : ListNode? = null

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    fun get(index: Int): Int {
        if(linkNode == null) return -1
        var count = 0
        var str = linkNode
        while(str != null) {
            if(count == index) {
                return str.`val`
            }
            count++
            str = str.next
        }
        return 0
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    fun addAtHead(`val`: Int) {
        val newNode = ListNode(`val`)
        newNode.next = this.linkNode
        this.linkNode = newNode
    }

    /** Append a node of value val to the last element of the linked list. */
    fun addAtTail(`val`: Int) {
        var temp = linkNode
        var last : ListNode? = null
        var newNode = ListNode(`val`)
        while(temp != null) {
            if(temp.next == null) last = temp
            temp = temp.next
        }
        if(last != null) {
            last.next = newNode
        } else this.linkNode = newNode
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    fun addAtIndex(index: Int, `val`: Int) {
        if(index <= 0) addAtHead(`val`)
        else  {
            var temp = this.linkNode
            var count = 0
            val newNode = ListNode(`val`)
            while(temp != null) {
                if(count + 1 == index) {
                    val tempSec = temp.next
                    temp.next = newNode
                    if(tempSec != null)
                        newNode.next = tempSec
                    break
                }
                count++
                temp = temp.next
            }
        }
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    fun deleteAtIndex(index: Int) {
        var temp = this.linkNode
        var count = 0
        var prev : ListNode ?= null
        while(temp != null) {
            if(count == index) {
                val tempSec = temp.next
                if(prev != null) {
                    prev.next = tempSec
                } else {
                    this.linkNode = tempSec
                }
                break
            }
            count++
            prev = temp
            temp = temp.next
        }
    }
}

class ListNode {
    private var `val` = 0
    private var next : ListNode ?= null
    constructor(`val`: Int) {
        this.`val` = `val`
    }
}