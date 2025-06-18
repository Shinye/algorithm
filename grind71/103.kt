// https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/?envType=problem-list-v2&envId=breadth-first-search

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
    fun zigzagLevelOrder(root: TreeNode?): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        if (root == null) return result

        val queue: Queue<TreeNode> = LinkedList()
        queue.add(root)
        var isForward = true

        while (queue.isNotEmpty()) {
            val level = LinkedList<Int>()

            val size = queue.size // 이렇게 repeat하는걸 생각을 못했다
            repeat(size) {
                val node = queue.poll()

                if (isForward) {
                    level.addLast(node.`val`)
                } else {
                    level.addFirst(node.`val`)
                }

                if (node.left != null) {
                    queue.add(node.left)
                }

                if (node.right != null) {
                    queue.add(node.right)
                }
            }

            result.add(level)
            isForward = !isForward // 방향 전환
        }

        return result
    }
}