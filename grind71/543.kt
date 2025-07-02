// https://leetcode.com/problems/diameter-of-binary-tree/
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
    var maxDiameter = 0
    fun diameterOfBinaryTree(root: TreeNode?): Int {
        dfs(root)
        return maxDiameter
    }

    // 후위순회: 깊이 계산하며 지름 갱신
    fun dfs(node: TreeNode?): Int {
        if (node == null) {
            return 0
        }
        val leftDepth = dfs(node.left)
        val rightDepth = dfs(node.right)

        // 해당 노드 기준의 지름 = left깊이 + right깊이
        maxDiameter = maxOf(maxDiameter, leftDepth + rightDepth)

        return maxOf(rightDepth, leftDepth) + 1
    }
}