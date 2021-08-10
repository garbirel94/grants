package com.garbirel.jetpack.链表.小结

import org.junit.Test

/**
    给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
    请你将两个数相加，并以相同形式返回一个表示和的链表。
    你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * */
class 扁平化多级双向链表 {
    @Test
    fun test() {

    }

    /**
     * 层层遍历，获取当前节点进行记录
     * */
    fun flatten(root: Node?): Node? {
        var tempNode = root
        while(tempNode != null) {
            if (tempNode.child != null) {
                flatten_child(tempNode,tempNode.child,tempNode.next)
            }
            tempNode = tempNode.next
        }
        return root
    }

    fun flatten_child(pre: Node?,child: Node?,next: Node?) {
        pre?.next = child
        child?.prev = pre
        pre?.child = null

        var nowNode = child
        while (nowNode?.next != null) nowNode = nowNode.next

        nowNode?.next = next
        if (next != null) next.prev = nowNode
    }

    /**
     * 深度优先搜索
     * */
    fun flatten2(root: Node?) : Node? {
        return null
    }

    class Node(var `val`: Int) {
        var prev: Node? = null
        var next: Node? = null
        var child: Node? = null
    }
}
