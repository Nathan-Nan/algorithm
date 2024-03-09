package y_2024.m_03.d_04.problem232;

import java.util.Stack;

/**
 * <a href="https://leetcode.cn/problems/implement-queue-using-stacks/description/?envType=daily-question&envId=2024-03-04">...</a>
 */
public class MyQueue {

    private Stack<Integer> input;
    private Stack<Integer> output;

    public MyQueue() {
        input = new Stack<>();
        output = new Stack<>();
    }

    public void push(int x) {
        input.push(x);
    }

    public int pop() {
        if (!output.isEmpty()) {
            return output.pop();
        }
        while (!input.isEmpty()) {
            output.push(input.pop());
        }
        return output.pop();
    }

    public int peek() {
        if (!output.isEmpty()) {
            return output.peek();
        }
        while (!input.isEmpty()) {
            output.push(input.pop());
        }
        return output.peek();
    }

    public boolean empty() {
        return input.isEmpty() && output.isEmpty();
    }
}
