// https://leetcode.com/problems/transform-array-to-all-equal-elements/
class Solution {
    fun canMakeEqual(nums: IntArray, k: Int): Boolean {
        return isAvailable(nums, k, 1) || isAvailable(nums, k, -1)
    }

    fun isAvailable(nums: IntArray, k: Int, target: Int): Boolean {
        var count = 0
        var newArray = nums.copyOf()
        for(i in 0 until nums.size - 1) {
            if (newArray[i] != target) {
                newArray[i] *= -1
                newArray[i+1] *= -1
                count++
                if (count > k) {
                    return false
                }
            }
        }
        return newArray.all { it == target }
    }
}
