// https://leetcode.com/problems/partition-string/

class Solution {
    fun partitionString(s: String): List<String> {
        val seenSegmentsMap: MutableMap<String, Boolean> = mutableMapOf()
        var target = ""
        val result: MutableList<String> = mutableListOf()

        s.forEach {
            target += it
            if (seenSegmentsMap.containsKey(target).not()) {
                result.add(target)
                seenSegmentsMap.put(target, true)
                target = ""   
            }
        }

        return result
    }
}