// https://leetcode.com/problems/linked-list-cycle/

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
    // solution1: hashmap 사용하는 방법
    // fun hasCycle(head: ListNode?): Boolean {
    //     // 노드를 방문한 이력이 있는지 유무를 기록해야 함.
    //     // 그런데 그 노드의 val만으로는 충분치 않고, 이 node의 index 정보도 같이 저장을 해야함
    //     // 따라서 (key) index <-> (value) val 의 구조의 해시맵 구조로 방문 기록을 저장하면 될 것 같음.
    //     // 근데.. 위치정보는 어떻게 알지? 주어진 ListNode 클래스에는 인덱스 정보가 없는 것 같은데?
    //     // -> index일 필요 없다! 그냥 노드 그 자체를 저장하면 되지. 노드 그 자체는 객체니까.
    //     // 그렇다면 (key) node <-> (value) true 로 하면 될까?

    //     val visitedMap: MutableMap<ListNode, Boolean> = mutableMapOf()
    //     var result = false
    //     var node = head
    //     if (node == null || node.next == null) {
    //         return false
    //     }

    //     while(node != null) {
    //         if (visitedMap.get(node!!) == true) {
    //             result = true
    //             break
    //         }
    //         visitedMap.put(node, true)
    //         node = node.next
    //     }

    //     return result
    // }

    // solution2: floyd's cycle finding algorithm (토끼와 거북이 ㅋ_ㅋ)

    fun hasCycle(head: ListNode?): Boolean {
        // 거북이는 한번에 한칸만
        // 토끼는 한번에 두칸만
        // 이렇게 순회하다 보면, 사이클이 있는 경우(graph, linkedlist..) 거북이와 토끼가 동일한 노드에서 만나는 경우가 반드시 존재

        if (head == null) {
            return false
        }
        var turtle = head
        var rabbit = head
        var result = false

        while(rabbit?.next != null) {
            turtle = turtle?.next
            rabbit = rabbit?.next?.next
            if (turtle == rabbit) {
                result = true
                break
            }
        }
        return result
    }
}