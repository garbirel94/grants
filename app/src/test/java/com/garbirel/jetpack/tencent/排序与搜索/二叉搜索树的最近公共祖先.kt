package com.garbirel.jetpack.tencent.排序与搜索

import com.garbirel.jetpack.tencent.排序与搜索.BianryTree
import com.garbirel.jetpack.tencent.排序与搜索.TreeNode
import org.junit.Test

class 二叉搜索树的最近公共祖先 {
    /**
     * 二叉搜索树的特点：左节点小于根节点，右节点大于根节点
     * */
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

        val index = lowestCommonAncestor2(tree.rootNode,
            TreeNode(null, 2, null),
            TreeNode(null, 4, null)
        )
        println("------->>>>>>>>   ${index?.`val`}")
    }

    /**
     * 使用递归的思路开始遍历
     * */
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        if(root == null || p == root || q == root) return root
        val num = root.`val`!!
        return if(num > p?.`val`!! && num > q?.`val`!!) {
            lowestCommonAncestor(root.left,p,q)
        } else if (num < p.`val`!! && num < q?.`val`!!) {
            lowestCommonAncestor(root.right,p,q)
        } else root
    }

    /**
     * 使用非递归的思路获取
     * */
    fun lowestCommonAncestor2 (root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        if(root == null || p == root || q == root) return root
        var cur = root
        var num : Int
        while (cur != null) {
            num = cur.`val`!!
            cur = if (num > p?.`val`!! && num > q?.`val`!!) {
                cur.left
            } else if (num < p.`val`!! && num < q?.`val`!!) {
                cur.right
            } else return cur
        }
        return null
    }
}