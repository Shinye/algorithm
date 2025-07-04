// https://leetcode.com/problems/maximum-depth-of-binary-tree/

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
    fun maxDepth(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }

        val left = root.left
        val right = root.right
        var leftDepth = 0
        var rightDepth = 0

        if (left == null && right == null) {
            return 1            
        }
        if (left != null) {
            leftDepth = dfs(left, 2)
        }
        if (right != null) {
            rightDepth = dfs(right, 2)
        }

        return maxOf(leftDepth, rightDepth)
    }

    fun dfs(node: TreeNode?, currentDepth: Int): Int {
        if (node == null) {
            return currentDepth
        }
        val left = node.left
        val right = node.right
        
        var leftDepth = 0
        var rightDepth = 0
        
        if (left == null && right == null) {
            return currentDepth         
        }

        if (left != null) {
            leftDepth = dfs(left, currentDepth + 1)
        } 
        if (right != null) {
            rightDepth = dfs(right, currentDepth + 1)
        }

        return maxOf(leftDepth, rightDepth)
    }
}