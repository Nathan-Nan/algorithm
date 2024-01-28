package y_2024.m_01.d_28.problem_365;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 * 对于本题而言，BFS 和 DFS 均可，实现上仅区别于使用栈还是队列，这里使用栈即 DFS
 */
public class Solution2 {
    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        Deque<int[]> stack = new ArrayDeque<>();
        stack.push(new int[]{0, 0});
        Set<Long> seen = new HashSet<>();
        while (!stack.isEmpty()) {
            if (seen.contains(hash(stack.peek()))) {
                stack.pop();
                continue;
            }
            seen.add(hash(stack.peek()));

            int[] state = stack.pop();
            int x = state[0], y = state[1];
            if (x == targetCapacity || y == targetCapacity || x + y == targetCapacity) {
                return true;
            }
            stack.push(new int[]{jug1Capacity, y});
            stack.push(new int[]{x, jug2Capacity});
            stack.push(new int[]{x, 0});
            stack.push(new int[]{0, y});
            stack.push(new int[]{x - Math.min(x, jug2Capacity - y), y + Math.min(x, jug2Capacity - y)});
            stack.push(new int[]{x + Math.min(y, jug1Capacity - x), y - Math.min(y, jug1Capacity - x)});
        }
        return false;
    }

    private Long hash(int[] state) {
        return state[0] * 1000001L + state[1];
    }
}
