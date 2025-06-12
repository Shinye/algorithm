// https://leetcode.com/problems/ransom-note/
class Solution {
    fun canConstruct(ransomNote: String, magazine: String): Boolean {
        val counts = mutableMapOf<Char, Int>()

        // magazine 문자 개수 카운트
        for (c in magazine) {
            counts[c] = counts.getOrDefault(c, 0) + 1
        }

        // ransomNote 문자 소비
        for (c in ransomNote) {
            counts[c] = counts.getOrDefault(c, 0) - 1
            if (counts[c]!! < 0) return false
        }

        return true
    }
}
