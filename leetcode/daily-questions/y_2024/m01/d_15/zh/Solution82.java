package y_2024.m01.d_15.zh;

/**
 * <a href="https://leetcode.cn/problems/remove-duplicates-from-sorted-list-ii/?envType=daily-question&envId=2024-01-15">...</a>
 */
public class Solution82 {

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

        @Override
        public String toString() {
            return val + (next == null ? "" : " -> " + next);
        }
    }

    /**
     * 迭代
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0, head), cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            int val = cur.next.val;
            if (cur.next.next.val == val)
                while (cur.next != null && cur.next.val == val)
                    cur.next = cur.next.next;
            else
                cur = cur.next;
        }
        return dummy.next;
    }


    /**
     * 递归
     */
    public ListNode deleteDuplicates1(ListNode head) {
        if (head == null) {
            return null;
        }
        // 遍历完成 p 指向与 head 值相同的最后一个节点
        ListNode p = head;
        while (p.next != null && p.next.val == head.val) {
            p = p.next;
        }
        // 如果相同，说明没有重复节点，递归下一个节点
        if (p == head) {
            head.next = deleteDuplicates1(head.next);
        } else {
            // 有相同，将下一个没有相同的节点赋给 head 达到删除相同节点的效果。
            head = deleteDuplicates(p.next);
        }
        return head;
    }


    public static void main(String[] args) {
        Solution82 solution = new Solution82();
        System.out.println(solution.deleteDuplicates(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3, new ListNode(4, new ListNode(4, new ListNode(5)))))))));
        System.out.println(solution.deleteDuplicates(new ListNode(1, new ListNode(2, new ListNode(2)))));
    }

}
