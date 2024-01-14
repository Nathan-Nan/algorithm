package y_2024.m_01.d_14.zh;

/**
 * <a href="https://leetcode.cn/problems/remove-duplicates-from-sorted-list/description/?envType=daily-question&envId=2024-01-14">...</a>
 */
public class Solution83 {

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

    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            while (cur.next != null && cur.val == cur.next.val) {
                cur.next = cur.next.next;
            }
            cur = cur.next;
        }
        return head;
    }

}
