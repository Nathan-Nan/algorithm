package y_2024.m_01.d_06.zh;

/**
 * <a href="https://leetcode.cn/problems/insert-greatest-common-divisors-in-linked-list/?envType=daily-question&envId=2024-01-06">...</a>
 */
public class Solution2807 {

    public static class ListNode {
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

    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            ListNode next = cur.next;
            cur.next = new ListNode(gcd(cur.val, next.val), next);
            cur = next;
        }
        return head;
    }

    /**
     * 求 a，b 的最大公约数
     * 递归实现
     */
    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    /**
     * 求 a，b 的最大公约数
     * 迭代实现
     */
    private int gcd1(int a, int b) {
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
}
