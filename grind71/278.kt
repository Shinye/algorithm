// https://leetcode.com/problems/first-bad-version/description/

/* The isBadVersion API is defined in the parent class VersionControl.
      fun isBadVersion(version: Int) : Boolean {} */

      class Solution: VersionControl() {
        override fun firstBadVersion(n: Int) : Int {
            var start = 1
            var end = n
    
            while (start < end) {
                val mid = start + (end - start) / 2
    
                if (isBadVersion(mid)) {
                    end = mid
                } else {
                    start = mid + 1
                }
            }
    
            return start
        }
    }