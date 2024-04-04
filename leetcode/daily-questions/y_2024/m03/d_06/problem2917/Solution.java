package y_2024.m03.d_06.problem2917;

/**
 * <a href="https://leetcode.cn/problems/find-the-k-or-of-an-array/description/?envType=daily-question&envId=2024-03-06">...</a>
 */
public class Solution {
    public int findKOr(int[] nums, int k) {
        int ans = 0;
        for (int i = 0; i < 31; i++) {
            int cnt1 = 0;
            for (int x : nums) {
                cnt1 += x >> i & 1;
            }
            if (cnt1 >= k) {
                ans |= 1 << i;
            }
        }
        return ans;
    }
}
