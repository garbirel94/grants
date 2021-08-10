package com.garbirel.jetpack.tencent.排序与搜索

import org.junit.Test
import java.util.*
import kotlin.collections.ArrayList

class 二叉搜索树中第K小的元素 {
    @Test
    fun test() {
        // 创建第二、三层节点(为了效率，第三层以具名参数形式赋值)
        val leftNode: TreeNode =
            TreeNode(
                TreeNode(`val` = 4),
                2,
                TreeNode(`val` = 5)
            )
        val rightNode: TreeNode =
            TreeNode(
                TreeNode(`val` = 6),
                3,
                TreeNode(`val` = 7)
            )
        // 创建根节点并添加2个子节点
        val rootNode: TreeNode =
            TreeNode(
                left = leftNode,
                `val` = 1,
                right = rightNode
            )
        // 创建树对象并添加根节点
        val tree: BianryTree =
            BianryTree(rootNode = rootNode)

        val index = kthSmallest3(tree.rootNode,2)
        println("--------->>>>>>>     $index")
    }

    /**
     * 遍历树得到一个list，然后进行有序排序，最后获得第K小的元素
     * */
    fun kthSmallest(root: TreeNode?, k: Int): Int {
        val listInfo = arrayListOf<Int>()
        if(root == null) return -1
        val stack = mutableListOf<TreeNode>()
        stack.add(root)
        while (stack.isNotEmpty()) {
            val  p = stack.removeAt(stack.lastIndex)
            listInfo.add(p.`val`!!)
            if (p.right != null) stack.add(p.right!!)
            if (p.left != null) stack.add(p.left!!)
        }
        return listInfo.sorted()[k-1]
    }

    /**
     *  使用递归的的方式去获取
     * */
    fun kthSmallest2(root: TreeNode?, k: Int): Int {
        val num = inOrder(root,ArrayList())
        return num[k-1]
    }

    fun inOrder (root: TreeNode?, res: ArrayList<Int>) : ArrayList<Int>{
        if (root == null) return res
        inOrder(root.left,res)
        res.add(root.`val`!!)
        inOrder(root.right,res)
        return res
    }

    /**
     *  使用迭代的方式去获取
     * */
    fun kthSmallest3(root: TreeNode?, k: Int): Int {
        val stack = LinkedList<TreeNode>()
        var k = k
        var root = root
        while (true) {
            while(root != null) {
                stack.add(root)
                root = root.left
            }
            root = stack.removeLast()
            if( --k == 0) return root.`val`!!
            root = root.right
        }
    }
}

/**
 * @des 链式存储二叉树Bean
 * @param rootNode : 二叉树的根节点
 * */
data class BianryTree(var rootNode: TreeNode)

/**
 * @des 链式存储节点Bean
 * @param leftNode : 左子节点
 * @param value : 节点的权
 * @param rightNode : 右子节点
 * */
data class TreeNode(var left: TreeNode? = null, var `val`:Int? = null, var right: TreeNode? = null)





