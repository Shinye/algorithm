// https://leetcode.com/problems/binary-tree-level-order-traversal/?envType=problem-list-v2&envId=breadth-first-search

/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        // root가 null인 경우 early exit
        // node를 queue에 삽입
        // layer 내에서 순회한 배열 push
        
        val result: MutableList<List<Int>> = mutableListOf()
        if (root == null) {
            return result
        }
        val queue: Queue<TreeNode> = LinkedList()
        queue.add(root)

        while(queue.isNotEmpty()) {
            val level: MutableList<Int> = mutableListOf()
            val size = queue.size
            repeat(size) {
                val node = queue.poll()
                level.add(node.`val`)

                if (node.left != null) {
                    queue.add(node.left)
                }

                if (node.right != null) {
                    queue.add(node.right)
                }
            }

            result.add(level)
        }

        return result
    }
}