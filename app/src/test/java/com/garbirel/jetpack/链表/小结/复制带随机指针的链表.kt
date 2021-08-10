package com.garbirel.jetpack.链表.小结

import org.junit.Test

class 复制带随机指针的链表 {
    @Test
    fun test() {

    }

    val visitNode = HashMap<Node,Node>()

    fun copyRandomList(node: Node?): Node? {
        if(node == null) return null
        if(visitNode.containsKey(node)) {
            return visitNode[node]
        }
        val newNode = Node(node.`val`)
        visitNode[node] = newNode
        newNode.next = copyRandomList(node.next)
        newNode.random = copyRandomList(node.random)
        return newNode
    }
}

/**
    var node = node
    val tempNode = Node(0)
    var dumpNode : Node? = tempNode
    while(node != null) {
        dumpNode?.next = node
        dumpNode?.next?.random = node.random
        node = node.next
        dumpNode = dumpNode?.next
    }
*/

class Node(var `val`: Int) {
    var next: Node? = null
    var random: Node? = null
}