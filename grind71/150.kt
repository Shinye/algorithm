// https://leetcode.com/problems/evaluate-reverse-polish-notation/

class Solution {
    fun evalRPN(tokens: Array<String>): Int {
        /**
        숫자가 들어오면 일단 stack에 쌓는다
        연산기호가 나오면, stack의 상위 2개를 pop하여 연산한다
        ㄴ 이를 직전 연산 결과를 저장하는 temp에 저장한다
        temp에 저장한 후, 배열을 다시 순회하여 연산기호가 나오면 stack에 있는 1개를 pop하여 temp와 연산한다
        ㄴ 이 결과를 다시 temp에 저장한다
        ㄴ 배열이 끝날 때 까지 반복한다
         */

        if (tokens.size == 1) {
            return tokens.first().toInt()
        }
        val stack: Stack<Int> = Stack()
        tokens.forEach {
            if (isNumber(it)) {
                stack.add(it.toInt())
            } else {
                val right = stack.pop()
                val left = stack.pop()
                val res = calculate(left, right, it)
                stack.add(res)
            }
        }

        return stack.pop()
    }

    private fun isNumber(s: String): Boolean =
        s.toIntOrNull() != null

    private fun calculate(left: Int, right: Int, operator: String): Int {
        return when (operator) {
            "+" -> left + right
            "-" -> left - right
            "*" -> left * right
            else -> left / right
        }
    }
}
