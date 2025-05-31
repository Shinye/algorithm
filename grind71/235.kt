// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int = 0) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

 class Solution {
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        // 1. p는 root보다 크고 q는 root보다 작다면 root 반환
        // 2. p 혹은 q가 root와 같다면 root 반환
        // 2. p와 q 모두 root보다 작다면 left로 간다
        // 3. p와 q 모두 root보다 크다면 right로 간다
        if (root == null) {
            return null
        }

        val rootValue = root?.`val` ?: 0
        val pValue = p?.`val` ?: 0
        val qValue = q?.`val` ?: 0

        if (pValue > rootValue && qValue < rootValue) {
            return root
        }

        if (pValue < rootValue && qValue > rootValue) {
            return root
        }

        if (pValue == rootValue || qValue == rootValue) {
            return root
        }

        if (pValue < rootValue && qValue < rootValue) {
            return lowestCommonAncestor(root.left, p, q)
        } else {
            return lowestCommonAncestor(root.right, p, q)
        }
    }
}