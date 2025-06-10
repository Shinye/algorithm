// https://leetcode.com/problems/implement-queue-using-stacks/
class MyQueue() {

    val inStack = Stack<Int>()
    val outStack = Stack<Int>()

    fun push(x: Int) {
        inStack.push(x)
    }

    fun pop(): Int {
        if (outStack.isEmpty()) {
            while(!inStack.isEmpty()) {
                val res = inStack.pop()
                outStack.push(res)
            }
        }
        return outStack.pop()
    }

    fun peek(): Int {
        if (outStack.isEmpty()) {
            while(!inStack.isEmpty()) {
                val res = inStack.pop()
                outStack.push(res)
            }
        }
        return outStack.peek()
    }

    fun empty(): Boolean {
        return inStack.isEmpty() && outStack.isEmpty()
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * var obj = MyQueue()
 * obj.push(x)
 * var param_2 = obj.pop()
 * var param_3 = obj.peek()
 * var param_4 = obj.empty()
 */