package y_2023.m_11.d_29.zh;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * <a href="https://leetcode.cn/problems/smallest-number-in-infinite-set/?envType=daily-question&envId=2023-11-29">...</a>
 */
public class Solution2336 {
    class SmallestInfiniteSet {

        private PriorityQueue<Integer> queue;
        private Set<Integer> set;

        public SmallestInfiniteSet() {
            queue = new PriorityQueue<>();
            set = new HashSet<>();
            for (int i = 1; i < 1001; i++) {
                set.add(i);
                queue.offer(i);
            }
        }

        public int popSmallest() {
            set.remove(queue.peek());
            return queue.poll();
        }

        public void addBack(int num) {
            if (set.contains(num)) {
                return;
            }
            set.add(num);
            queue.offer(num);
        }
    }
}
