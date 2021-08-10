package com.garbirel.jetpack.tencent.设计

import org.junit.Test

/**
 * 实现 LRUCache 类：
 * LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上限时，
 * 它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间（删除尾节点的前置节点，即可完成删除最久未使用的数据值）
 * */
class LRU缓存机制 {
    @Test
    fun test() {
        val lruCache = LRUCache(2)
        lruCache.put(1,1)
        lruCache.put(2,2)
        val indexFir = lruCache.get(1)
        println("--------->>>>>>>   $indexFir")
        lruCache.put(3,3)
        val indexSec = lruCache.get(2)
        println("--------->>>>>>>   $indexSec")
        lruCache.put(4,4)
        val indexThird = lruCache.get(1)
        println("--------->>>>>>>   $indexThird")
        val indexForth = lruCache.get(3)
        println("--------->>>>>>>   $indexForth")
        val indexFifth = lruCache.get(4)
        println("--------->>>>>>>   $indexFifth")
    }
}

/**
 * ["LRUCache","put","put","get","put","get","put","get","get","get"]
 * [[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]
 */
class LRUCache {
    class Node {
        var key = 0
        var value = 0
        var pre: Node?= null
        var next: Node?= null
        constructor() {}
        constructor(key: Int,value : Int) {
            this.key = key
            this.value = value
        }
    }

    private var dummyHead = Node()
    private var dummyTail = Node()
    private var capacity = 0
    private var size = 0
    private var hashMap = HashMap<Int, Node>()

    constructor(capacity: Int) {
        dummyHead.next = dummyTail
        dummyTail.pre = dummyHead
        this.capacity = capacity
        size = 0
    }

    fun add(node : Node) {
        val originHead = dummyHead.next
        dummyHead.next = node
        node.pre = dummyHead
        node.next = originHead
        originHead?.pre = node
    }

    fun delete(node: Node) {
        val preNode = node.pre
        val nextNode = node.next
        preNode?.next = nextNode
        nextNode?.pre = preNode
        node.pre = null
        node.next = null
    }



    fun get(key: Int): Int {
        val node : Node = hashMap[key] ?: return -1
        delete(node)
        add(node)
        return node.value
    }

    fun put(key: Int, value: Int) {
        val node : Node? = hashMap[key]
        if(null != node) {
            node.value = value
            delete(node)
            add(node)
        } else {
            if(size < capacity) {
                size++
            } else {
                val deleteNode : Node? = dummyTail.pre
                hashMap.remove(deleteNode?.key)
                deleteNode?.let { delete(it) }
            }
            val newNode =
                Node(key, value)
            add(newNode)
            hashMap[key] = newNode
        }
    }
}