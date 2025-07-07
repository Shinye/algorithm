// https://leetcode.com/problems/maximum-subarray/
// 카데인 알고리즘 (다시 공부 필요)
// 1. maxEndingHere = maxOf(nums[i], maxEndingHere + nums[i])
// 2. maxSoFar = maxOf(maxSoFar, maxEndingHere)
// 3. return maxSoFar

// brute force
// class Solution {
//     fun maxSubArray(nums: IntArray): Int {
//         val size = nums.size

//         if (size == 1) {
//             return nums[0]
//         }

//         var maxSubArraySize = Integer.MIN_VALUE

//         // subarray size
//         for (i in 0 until size) {
//             // loop
//             var currentArraySize = 0
//             for (j in i until size) {
//                 currentArraySize += nums[j]
//                 maxSubArraySize = maxOf(maxSubArraySize, currentArraySize)
//             }
//         }

//         return maxSubArraySize
//     }
// }

// class Solution {
//     fun maxSubArray(nums: IntArray): Int {
//         // 카데인 알고리즘 - maxOf(nums[i], maxSumArray[i-1] + nums[i])
//         // nums를 순회한다
//         /*
//         maxEndingHere / maxSoFar은 nums[0]로 초기화
//         nums를 순회하며
//         1. 지금까지의 maxEndingHere + num[i] < num[i]인 경우 maxEndingHere의 값을 num[i]로 초기화
//           - 그 말인 즉 maxEndingHere이 지금까지 마이너스였다는 말이니, 이게 없이 nums[i]부터 시작하는게 최대값을 만드는데에 더 용이함.
//         2. 지금까지의 maxSoFar과 maxEndingHere를 비교하여 maxSoFar이 더 큰 경우 갱신한다.
//          */

//         var maxEndingHere = 0
//         var maxSoFar = 0
//         nums.forEachIndexed { index, current ->
//             if (index == 0) {
//                 maxEndingHere = current
//                 maxSoFar = current
//             } else {
//                 maxEndingHere = maxOf(current, maxEndingHere + current)
//                 maxSoFar = maxOf(maxEndingHere, maxSoFar)
//             }
//         }

//         return maxSoFar
//     }
// }

class Solution {
    // 그 subarray의 형태를 구해야 할 경우
    fun maxSubArray(nums: IntArray): Int {
        
        var tempStartIndex = 0
        var startIndex = 0
        var endIndex = 0
        var maxSoFar = 0
        var maxEndingHere = 0

        nums.forEachIndexed { index, current ->
            if (index == 0) {
                maxSoFar = current
                maxEndingHere = current
            } else {
                if (maxEndingHere + current < current) {
                    maxEndingHere = current
                    tempStartIndex = index
                } else {
                    maxEndingHere += current
                }

                if (maxEndingHere > maxSoFar) {
                    maxSoFar = maxEndingHere
                    startIndex = tempStartIndex
                    endIndex = index
                }
            }
        }

        var sum = 0
        for (i in startIndex..endIndex) {
            sum += nums[i]
        }

        return sum
    }
}