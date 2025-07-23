//https://leetcode.com/problems/split-array-by-prime-indices/description/
class Solution {
    fun splitArray(nums: IntArray): Long {
        var primeSum = 0L
        var nonPrimeSum = 0L

        nums.forEachIndexed { index, value ->
            if (isPrime(index)) {
                primeSum += value
            } else {
                nonPrimeSum += value
            }
        }

        return abs(primeSum - nonPrimeSum)
    }

    fun isPrime(n: Int): Boolean {
        if (n < 2) return false
        for (i in 2..Math.sqrt(n.toDouble()).toInt()) {
            if (n % i == 0) return false
        }
        return true
    }
}