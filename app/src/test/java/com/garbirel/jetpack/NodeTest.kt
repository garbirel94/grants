package com.garbirel.jetpack

import com.google.gson.JsonObject
import org.junit.Test
import java.util.*
import kotlin.collections.ArrayList

class NodeTest {
    @Test
    fun addition_isCorrect() {
        val index = buildTreeWithMidAndLast(intArrayOf(3,9,20,15,7), intArrayOf(9,3,15,20,7))
        println(index)
    }

    //前序遍历  根左右
    fun preOrderTraversal(root: TreeNode?): List<Int> {
        val info = arrayListOf<Int>()
        if (root == null) return info
        val stack = mutableListOf<TreeNode>()
        stack.add(root)
        while(stack.isNotEmpty()) {
            val p = stack.removeAt(stack.lastIndex)
            info.add(p.`val`)
            if(p.right != null) stack.add(p.right!!)
            if(p.left != null) stack.add(p.left!!)
        }
        return info
    }

    //中序遍历 左根右
    fun inOrderTraversal(root : TreeNode?) : List<Int> {
        val list: MutableList<Int> = ArrayList()
        if (root == null) return list
        val stack: Stack<TreeNode> = Stack()
        var cur = root
        while (cur != null || stack.isNotEmpty()) {
            while (cur != null) {
                stack.push(cur)
                cur = cur.left
            }
            cur = stack.pop()
            list.add(cur.`val`)
            cur = cur.right
        }
        return list
    }

    //后序遍历  左右根
    fun postOrderTraversal(root: TreeNode?): List<Int> {
        val list: MutableList<Int> = ArrayList()
        if (root == null) return list
        val stack: Stack<TreeNode> = Stack()
        var cur = root
        var preNode : TreeNode? = null
        while(cur != null || stack.isNotEmpty()) {
            while (cur != null) {
                stack.push(cur)
                cur = cur.left
            }
            cur = stack.peek()
            if (cur.right == null || cur.right == preNode) {
                cur = stack.pop()
                list.add(cur.`val`)
                preNode = cur
                cur = null
            } else {
                cur = cur.right
            }
        }
        return list
    }

    //层序遍历 超出时间限制
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        var result : ArrayList<ArrayList<Int>> = ArrayList<ArrayList<Int>>()
        if(root == null) return result
        val info = ArrayList<TreeNode>()
        info.add(root)
        while (info.isNotEmpty()) {
            var size = info.size
            var firstInfo = ArrayList<Int>()
            for (index in 0 until size) {
                var remove = info.first()
                firstInfo.add(remove.`val`)
                if(remove.left != null) info.add(remove.left!!)
                if(remove.right != null) info.add(remove.right!!)
            }
            result.add(firstInfo)
        }
        return result
    }

    //层序遍历
    fun levelOrderFirst(root: TreeNode?): List<List<Int>> {
        val result = ArrayList<ArrayList<Int>>()
        if (root == null) return result //边界条件
        val q: Queue<TreeNode?> = LinkedList() //创建的队列用来存放结点，泛型注意是TreeNode
        q.add(root)
        while (q.isNotEmpty()) {//队列为空说明已经遍历完所有元素，while语句用于循环每一个层次
            var count: Int = q.size
            val list = ArrayList<Int>()
            while (count > 0) {//遍历当前层次的每一个结点，每一层次的Count代表了当前层次的结点数目
                val temp = q.peek()
                q.poll() //遍历的每一个结点都需要将其弹出
                list.add(temp!!.`val`)
                if (temp.left != null) q.add(temp.left) //迭代操作，向左探索
                if (temp.right != null) q.add(temp.right)
                count--
            }
            result.add(list)
        }
        return result
    }

    //二叉树最大深度
    fun maxDepth(root: TreeNode?): Int {
        if(root == null) return 0
        val left_depth = maxDepth(root.left)
        val right_depth = maxDepth(root.right)
        return Math.max(left_depth,right_depth) +1
    }

    // 对称二叉树
    fun isSymmetric(root: TreeNode?): Boolean {
        return isMirror(root,root)
    }

    fun isMirror(node1 : TreeNode?,node2 : TreeNode?) : Boolean{
        if(node1 == null && node2 == null) return true
        if(node1 == null || node2 == null) return false
        return (node1.`val` == node2.`val`) && isMirror(node1.left,node2.right) && isMirror(node2.left,node1.right)
    }

    //路径总和 前序遍历
    fun hasPathSum(root: TreeNode?, targetSum: Int): Boolean {
        if(root == null) return false
        if(root.left == null && root.right == null) return root.`val` == targetSum
        return hasPathSum(root.right,targetSum - root.`val`) || hasPathSum(root.left,targetSum - root.`val`)
    }

    //根据中序跟后序构造二叉树 左根右 左右根
    fun buildTreeWithMidAndLast (inorder: IntArray, postorder: IntArray): TreeNode? {
        if(inorder.isEmpty()) return null
        return difWithMidAndLast(inorder,postorder,0,inorder.size -1,0,postorder.size -1)
    }

    private fun difWithMidAndLast (inorder: IntArray, postorder: IntArray, head1: Int, tail1 : Int, head2: Int, tail2: Int) : TreeNode? {
        if(head2 > tail2) return null
        val `val` = postorder[tail2]
        val node = TreeNode(`val`)
        if (head2 == tail2) return node
        var mid = 0
        while (inorder[head1 + mid] != `val`) mid++
        node.left = difWithMidAndLast(inorder,postorder,head1,head1 + mid -1,head2,head2 + mid -1)
        node.right = difWithMidAndLast(inorder,postorder,head1 + mid + 1,tail1,head2 + mid,tail2 - 1)
        return node
    }

    //根据前序跟中序构造二叉树 根左右 左根右
    fun buildTreeWithFrontAndMid(preorder: IntArray, inorder: IntArray) : TreeNode? {
        if(inorder.isEmpty()) return null
        return difWithFrontAndMid(preorder,inorder,0,preorder.size -1,0,inorder.size -1)
    }

    private fun difWithFrontAndMid(preorder: IntArray, inorder: IntArray, head1: Int, tail1 : Int, head2: Int, tail2: Int) : TreeNode? {
        if(head1 > tail1 || head2 > tail2) return null
        val `val` = preorder[head1]
        val node = TreeNode(`val`)
        if(head1 == tail1) return node
        var mid = 0
        while(inorder[head2 + mid] != `val`) mid++
        //左子树的前序遍历数组位置为h1+1,h1+mid（根据遍历特点），中序遍历数组为h1+mid位置的左边
        node.left = difWithFrontAndMid(preorder,inorder,head1 + 1,head1 + mid, head2,head2 + mid -1)
        //右子树的前序遍历位置为遍历完根节点和左子树之后：h1+mid+1至t1；中序遍历为根节点的右边：h2+mid+1至t2
        node.right = difWithFrontAndMid(preorder,inorder,head1 + mid + 1, tail1,head2 + mid + 1,tail2)
        return node
    }

    //填充每个节点的下一个右侧节点指针
    fun connect(root: Node?): Node? {
        return null
    }

    private fun createTree (node: TreeNode, i: Int): TreeNode? {
        if (0 == TreeValue.TREE_VALUE[i]) {
            return null
        } else {
            node.`val` = TreeValue.TREE_VALUE[i]
        }
        val leftChild = TreeNode(1)
        node.left = createTree(leftChild, ++TreeValue.index)
        val rightChild = TreeNode(1)
        node.right = createTree(rightChild, ++TreeValue.index)
        return node
    }
}

class ListNode(var `val` : Int) {
    var next: ListNode? = null
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

object TreeValue {
    var index = 0
    val TREE_VALUE = intArrayOf(1, 2, 3, 0, 4, 5, 0, 0, 6, 0, 0, 7, 0, 0, 8, 0, 9, 10, 0, 0, 0)
}

class Node(var `val`: Int) {
    var left: Node? = null
    var right: Node? = null
    var next: Node? = null
}