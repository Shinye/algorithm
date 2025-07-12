/*
    <어려웠음 다시풀기>
    경우의 수를 생각해야한다.

    1. interval > newInterval
    2. interval < newInterval
    3. interval과 newInterval가 완전 겹침
    -> newInterval을 기존 interval과 병합한다. 이 병합된 원소를 다시 다음 interval과 비교한다.
    4. newInterval가 모든 interval의 경우의 수보다 더 큰 경우
 */

 class Solution {
    fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
        val result: MutableList<IntArray> = mutableListOf()
        var isNewInserted: Boolean = false

        for (interval in intervals) {
            when {
                interval[1] < newInterval[0] -> {
                    result.add(intArrayOf(interval[0], interval[1]))
                }
                interval[0] > newInterval[1] -> {
                    if (!isNewInserted) {
                        result.add(intArrayOf(newInterval[0], newInterval[1]))
                        isNewInserted = true
                    }
                    result.add(intArrayOf(interval[0], interval[1]))
                }
                else -> {
                    newInterval[0] = minOf(interval[0], newInterval[0])
                    newInterval[1] = maxOf(interval[1], newInterval[1])
                }
            }
        }

        if (!isNewInserted) { 
            result.add(intArrayOf(newInterval[0], newInterval[1]))
        }

        return result.toTypedArray()
    }
}
