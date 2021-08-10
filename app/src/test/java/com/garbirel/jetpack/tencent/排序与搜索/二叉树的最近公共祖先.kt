package com.garbirel.jetpack.tencent.排序与搜索

import com.garbirel.jetpack.tencent.排序与搜索.BianryTree
import com.garbirel.jetpack.tencent.排序与搜索.TreeNode
import org.junit.Test

class 二叉树的最近公共祖先 {
    @Test
    fun test() {
        // 创建第二、三层节点(为了效率，第三层以具名参数形式赋值)
        val leftNode: TreeNode =
            TreeNode(
                TreeNode(`val` = 0),
                2,
                TreeNode(`val` = 4)
            )
        val rightNode: TreeNode =
            TreeNode(
                TreeNode(`val` = 7),
                8,
                TreeNode(`val` = 9)
            )
        // 创建根节点并添加2个子节点
        val rootNode: TreeNode =
            TreeNode(
                left = leftNode,
                `val` = 6,
                right = rightNode
            )
        // 创建树对象并添加根节点
        val tree: BianryTree =
            BianryTree(rootNode = rootNode)

        val index = lowestCommonAncestor(tree.rootNode,
            TreeNode(null, 2, null),
            TreeNode(null, 9, null)
        )
        println("---------->>>>>>>>   ${index?.`val`}")
    }

    /**
     * 递归思路
     * */
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        if(root == null || p == root || q == root) return root
        val left = lowestCommonAncestor(root.left,p,q)
        val right = lowestCommonAncestor(root.right,p,q)

        if(left != null && right != null) return root
        return left ?: right
    }

    /**
     * 非递归思路
     * */
    fun lowestCommonAncestor2(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        if(root == null || p == root || q == root) return root
        val left = lowestCommonAncestor(root.left,p,q)
        val right = lowestCommonAncestor(root.right,p,q)

        if(left != null && right != null) return root
        return left ?: right
    }
}