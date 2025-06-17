// https://leetcode.com/problems/reverse-linked-list/

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    fun reverseList(head: ListNode?): ListNode? {
        var currentNode: ListNode? = head
        var prev: ListNode? = null
        while (currentNode != null) {
            val nextNode = currentNode.next
            currentNode.next = prev
            prev = currentNode
            currentNode = nextNode
        }

        return prev
    }
}