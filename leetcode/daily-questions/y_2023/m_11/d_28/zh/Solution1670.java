package y_2023.m_11.d_28.zh;

import java.util.LinkedList;

/**
 * <a href="https://leetcode.cn/problems/design-front-middle-back-queue/description/?envType=daily-question&envId=2023-11-28">...</a>
 */
public class Solution1670 {
    static class FrontMiddleBackQueue {
        private LinkedList<Integer> q;

        public FrontMiddleBackQueue() {
            q = new LinkedList<>();
        }

        public void pushFront(int val) {
            q.addFirst(val);
        }

        public void pushMiddle(int val) {
            q.add(q.size() / 2, val);
        }

        public void pushBack(int val) {
            q.addLast(val);
        }

        public int popFront() {
            if (q.isEmpty()) {
                return -1;
            }
            return q.removeFirst();
        }

        public int popMiddle() {
            if (q.isEmpty()) {
                return -1;
            }
            return q.remove((q.size() - 1) / 2);
        }

        public int popBack() {
            if (q.isEmpty()) {
                return -1;
            }
            return q.removeLast();
        }
    }
}
