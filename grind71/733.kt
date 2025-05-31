// https://leetcode.com/problems/flood-fill/
class Solution {
    fun floodFill(image: Array<IntArray>, sr: Int, sc: Int, color: Int): Array<IntArray> {
        // 1. sr 혹은 sc가 0 미만이면 early exit
        // 2. 해당 cell의 값이 주어진 color 값으로 변경되어 있으면 early exit
        // 3. 해당 cell의 값이 최초 픽셀의 값과 일치하지 않으면 early exit
        // 4. sr, sc에 대해 각각 +,-1씩 해준다.
        return dfs(image, sr, sc, color, image[sr][sc])
    }

    fun dfs(image: Array<IntArray>, sr: Int, sc: Int, color: Int, initial: Int): Array<IntArray> {
        if (sr < 0 || sc < 0) {
            return image
        }
        if (sr > image.size - 1 || sc > image[0].size - 1) {
            return image
        }
        if (image[sr][sc] == color) {
            return image
        }
        if (image[sr][sc] != initial) {
            return image
        }
        
        image[sr][sc] = color

        dfs(image, sr + 1, sc, color, initial)
        dfs(image, sr - 1, sc, color, initial)
        dfs(image, sr, sc + 1, color, initial)
        dfs(image, sr, sc - 1, color, initial)

        return image
    }
}