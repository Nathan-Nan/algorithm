package y_2024.m_03.d_03.problem225;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <a href="https://leetcode.cn/problems/implement-stack-using-queues/description/?envType=daily-question&envId=2024-03-03">...</a>
 */
public class MyStack {
    private final Queue<Integer> queue_;

    public MyStack() {
        queue_ = new LinkedList<>();
    }

    public void push(int x) {
        int size = queue_.size();
        queue_.offer(x);
        for (int i = 0; i < size; i++) {
            queue_.offer(queue_.poll());
        }
    }

    public int pop() {
        return queue_.poll();
    }

    public int top() {
        return queue_.peek();
    }

    public boolean empty() {
        return queue_.isEmpty();
    }
}
