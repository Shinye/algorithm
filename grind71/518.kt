// https://leetcode.com/problems/coin-change-ii
class Solution {
    fun change(amount: Int, coins: IntArray): Int {
        val dp = IntArray(amount+1) { 0 }
        dp[0] = 1

        for (coin in coins) {
            for (i in coin..amount) {
                dp[i] = dp[i] + dp[i-coin]
            }
        }

        return dp[amount]
    }
}