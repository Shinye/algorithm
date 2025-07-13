// https://leetcode.com/problems/01-matrix/description/ 다시 풀어보기
class Solution {
    fun updateMatrix(mat: Array<IntArray>): Array<IntArray> {
        /**
            0에서부터 접근하는 것이 좋다. -> 각 cell에 대하여 불필요한 추가적 접근을 막을 수 있다.
            queue에 0인 친구들을 쌓고(이 0인 애들의 값은 그대로 0으로 유지), 1인 친구들은 -1로 초기화한다 (거리를 업데이트 하기 위함)
            각 cell의 동서남북을 접근하여 거리를 입력하고, 각 동서남북 cell들을 또 queue에 쌓는다.
            queue가 empty될 때 까지 반복한다
        */

        val queue: Queue<Pair<Int, Int>> = LinkedList()
        val rowSize = mat.size
        val colSize = mat[0].size

        for (i in 0 until rowSize) {
            for (j in 0 until colSize) {
                if (mat[i][j] == 0) {
                    queue.add(Pair(i,j))
                } else {
                    mat[i][j] = -1
                }
            }
        }

        // 상, 하, 좌, 우
        val directions = listOf(Pair(0,-1), Pair(0,1), Pair(-1,0), Pair(1,0))

        while (queue.isNotEmpty()) {
            val (x, y) = queue.poll()
            val currentValue = mat[x][y]
            for ((dx, dy) in directions) {
                val newX = x + dx
                val newY = y + dy
                if (
                    (newX in 0 until rowSize) && 
                    (newY in 0 until colSize) 
                ) {
                    val targetValue = mat[newX][newY]
                    if (targetValue == -1) {
                        mat[newX][newY] = currentValue + 1
                        queue.add(Pair(newX, newY))
                    }
                }
            }          
        }

        return mat
    }
}