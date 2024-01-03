package y_2024.m_01.d_03.zh;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.cn/problems/remove-nodes-from-linked-list/description/?envType=daily-question&envId=2024-01-03">...</a>
 */
public class Solution2487 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * 解法一：维护一个单调栈
     */
    public ListNode removeNodes(ListNode head) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.add(head.val);
        while (head.next != null) {
            head = head.next;
            while (!stack.isEmpty() && stack.peek() < head.val) {
                stack.pop();
            }
            stack.push(head.val);
        }
        ListNode dummy = new ListNode();
        while (!stack.isEmpty()) {
            dummy.next = new ListNode(stack.pop(), dummy.next);
        }
        return dummy.next;
    }


    /**
     * 解法二：递归
     */
    public ListNode removeNodes1(ListNode head) {
        if (head == null) {
            return null;
        }
        head.next = removeNodes1(head.next);
        if (head.next != null && head.val < head.next.val) {
            return head.next;
        }
        return head;
    }


    /**
     * 解法三：翻转链表
     */
    public ListNode removeNodes2(ListNode head) {
        ListNode tail = reverse(head), next = tail.next, cur = tail;
        while (next != null) {
            if (next.val < cur.val) {
                next = next.next;
                continue;
            }
            cur.next = next;
            cur = next;
            next = next.next;
        }
        cur.next = null;
        return reverse(tail);
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head, next, pre = null;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
