package zh;

/**
 * <a href="https://leetcode.cn/problems/minimum-deletions-to-make-array-beautiful/?envType=daily-question&envId=2023-11-21">...</a>
 */
public class Solution2216 {
    public int minDeletion(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int len = nums.length, deletion = 0;
        for (int i = 0; i < len - 1; i++) {
            if ((i - deletion) % 2 == 0 && i + 1 < len && nums[i] == nums[i + 1]) {
                deletion++;
            }
        }

        return (len - deletion) % 2 == 0 ? deletion : deletion + 1;
    }

    public static void main(String[] args) {
        Solution2216 solution = new Solution2216();
        System.out.println(solution.minDeletion(new int[]{1, 1, 2, 3, 5}));
        System.out.println(solution.minDeletion(new int[]{1, 1, 2, 2, 3, 3}));
    }
}
