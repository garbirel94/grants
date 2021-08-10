package com.garbirel.jetpack.tencent.排序与搜索

import com.garbirel.jetpack.tencent.排序与搜索.BianryTree
import com.garbirel.jetpack.tencent.排序与搜索.TreeNode
import org.junit.Test

class 二叉树中的最大路径和 {
    var res = Integer.MIN_VALUE

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

        val index = maxPathSum(tree.rootNode)
        println("--------->>>>>>>     $index")
    }

    /**
     * 递归
     * */
    fun maxPathSum(root: TreeNode?): Int {
        helper(root)
        return res
    }

    fun helper(root: TreeNode?) : Int{
        if(root == null) return 0
        var left = helper(root.left)
        var right = helper(root.right)
        res = Math.max(left + right + root.`val`!!,res)
        return Math.max(0,Math.max(left ,right) + root.`val`!!)
    }
}