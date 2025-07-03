// https://leetcode.com/problems/middle-of-the-linked-list/description/
import kotlin.math.floor

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
    fun middleNode(head: ListNode?): ListNode? {
        val resultArray: MutableList<ListNode> = mutableListOf()
        var node = head
        while(node != null) {
            resultArray.add(node)
            node = node.next
        }
        val size = resultArray.size
        if (size % 2 == 0) {
            val index = (size/2).let { floor(it.toDouble()).toInt()}
            return resultArray[index]
        } else {
            val index = size/2
            return resultArray[index]
        }
    }
}