// https://leetcode.com/problems/climbing-stairs/description/

class Solution {
    fun climbStairs(n: Int): Int {
        var oneStepBefore = 1
        var twoStepBefore = 1
        var result = 1

        for (i in 0..n) {
            if (i <= 1) {
                continue
            }

            result = oneStepBefore + twoStepBefore
            twoStepBefore = oneStepBefore
            oneStepBefore = result
        }
        return result
    }
}