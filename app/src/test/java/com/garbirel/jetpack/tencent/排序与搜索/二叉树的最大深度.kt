package com.garbirel.jetpack.tencent.排序与搜索

import com.garbirel.jetpack.tencent.排序与搜索.BianryTree
import com.garbirel.jetpack.tencent.排序与搜索.TreeNode
import org.junit.Test

class 二叉树的最大深度 {
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
            TreeNode()
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

        val index = maxDepth(tree.rootNode)
        println("------->>>>>>>    $index")
    }


    fun maxDepth(root: TreeNode?): Int {
        if(root == null) return 0
        val leftDepth = maxDepth(root.left)
        val rightDepth = maxDepth(root.right)
        return Math.max(leftDepth,rightDepth) + 1
    }
}