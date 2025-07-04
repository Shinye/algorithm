// https://leetcode.com/problems/contains-duplicate/

class Solution {
    fun containsDuplicate(nums: IntArray): Boolean {
        val duplicateMap: MutableMap<Int, Boolean> = mutableMapOf()
        nums.forEach {
            if (duplicateMap[it] == null) {
                duplicateMap[it] = true
            } else {
                return true
            }
        }

        return false
    }
}