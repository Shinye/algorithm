/**
 * Definition for a Node.
 * class Node(var `val`: Int) {
 *     var neighbors: ArrayList<Node?> = ArrayList<Node?>()
 * }
 */

 class Solution {
    fun cloneGraph(node: Node?): Node? {
        if (node == null) {
            return null
        }

        val visited: MutableMap<Int, Node> = mutableMapOf()
        return clone(node, visited)
    }

    private fun clone(node: Node, visited: MutableMap<Int, Node>): Node {
        if (visited.containsKey(node.`val`)) {
            return visited[node.`val`]!!
        } else {
            val newNode = Node(node.`val`)
            visited[node.`val`] = newNode

            newNode.neighbors = node.neighbors.map {
                clone(it!!, visited)
            }.let { ArrayList(it) }

            return newNode
        }
    }
}