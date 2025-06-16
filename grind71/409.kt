// https://leetcode.com/problems/longest-palindrome/description/
class Solution {
    fun longestPalindrome(s: String): Int {
        // s를 순회하며 각 알파벳 별 개수를 hashmap에 담는다
        val alphabetMap: MutableMap<Char, Int> = mutableMapOf()
        var length = 0
        var hasOdd = false
        s.forEach {
            alphabetMap[it] = alphabetMap.getOrDefault(it, 0) + 1
        }

        alphabetMap.values.forEach { count ->
            if (count % 2 == 1) {
                length += (count - 1)
                hasOdd = true
            } else {
                length += count
            }
        }

        if (hasOdd == true) {
            length += 1
        }

        return length
    }
}