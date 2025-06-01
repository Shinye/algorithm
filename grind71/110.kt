// https://leetcode.com/problems/balanced-binary-tree/
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
    fun isBalanced(root: TreeNode?): Boolean {
        if (root == null) {
            return true
        }

        return checkHeight(root) != -1
    }

    fun checkHeight(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }
        // 트리의 높이는 leaf에서부터 거슬러 올라가며 세는 것이다.

        // 왼쪽 순회
        val left = checkHeight(root.left)
        // 오른쪽 순회
        val right = checkHeight(root.right)

        // 불일치 케이스 발생 시 추가 순회 하지 말고 early exit 한다
        if (left == -1 || right == -1) {
            return -1
        }
        if (Math.abs(left-right) > 1) {
            return -1
        }

        // left, right 중 더 깊은 곳의 높이 + 1이 현재 나의높이
        return max(left, right) + 1
    }

}