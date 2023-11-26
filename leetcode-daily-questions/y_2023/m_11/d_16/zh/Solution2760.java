package y_2023.m_11.d_16.zh;

/**
 * <@link rel="<a href="https://leetcode.cn/problems/longest-even-odd-subarray-with-threshold/?envType=daily-question&envId=2023-11-16"/@link>
 */
public class Solution2760 {

    /**
     * 暴力解法
     *
     * @param nums
     * @param threshold
     * @return
     */
    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = nums.length - 1; j >= i; j--) {
                if (isValid(nums, i, j, threshold)) {
                    ans = Math.max(ans, j - i + 1);
                    break;
                }
            }
        }
        return ans;
    }

    private boolean isValid(int[] nums, int l, int r, int threshold) {
        if (nums[l] % 2 != 0 || nums[r] > threshold) {
            return false;
        }
        for (int k = l; k <= r; k++) {
            if (nums[k] > threshold) {
                return false;
            }
            if (k < r && (nums[k] & 1) == (nums[k + 1] & 1)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 双指针解法
     *
     * @param nums
     * @param threshold
     * @return
     */
    public int longestAlternatingSubarray2(int[] nums, int threshold) {
        int ans = 0, left = 0, right = 0;
        while (left < nums.length) {
            while (left < nums.length && (nums[left] % 2 != 0 || nums[left] > threshold)) {
                left++;
            }
            if (left >= nums.length) {
                break;
            }
            right = left + 1;
            while (right < nums.length && (nums[right] & 1) != (nums[right - 1] & 1) && nums[right] <= threshold) {
                right++;
            }
            ans = Math.max(ans, right - left);
            left = right;
        }
        return ans;
    }

    /**
     *
     *
     * @param nums
     * @param threshold
     * @return
     */
    public int longestAlternatingSubarray3(int[] nums, int threshold) {
        int ans = 0, mod = 0, count = 0;
        for (int num : nums) {
            if (num > threshold) {
                count = 0;
                mod = 0;
            } else {
                if ((num & 1) == mod) {
                    count++;
                    ans = Math.max(ans, count);
                    mod ^= 1;
                } else if ((num & 1) == 0) {
                    count = 1;
                    mod = 1;
                } else {
                    count = 0;
                    mod = 0;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution2760 solution = new Solution2760();
        System.out.println(solution.longestAlternatingSubarray(new int[]{3, 2, 5, 4}, 5));
        System.out.println(solution.longestAlternatingSubarray(new int[]{1, 2}, 2));
        System.out.println(solution.longestAlternatingSubarray(new int[]{2, 3, 4, 5}, 4));
        System.out.println(solution.longestAlternatingSubarray(new int[]{2, 2}, 18));
        System.out.println(solution.longestAlternatingSubarray2(new int[]{3, 2, 5, 4}, 5));
        System.out.println(solution.longestAlternatingSubarray2(new int[]{1, 2}, 2));
        System.out.println(solution.longestAlternatingSubarray2(new int[]{2, 3, 4, 5}, 4));
        System.out.println(solution.longestAlternatingSubarray2(new int[]{2, 2}, 18));
        System.out.println(solution.longestAlternatingSubarray3(new int[]{3, 2, 5, 4}, 5));
        System.out.println(solution.longestAlternatingSubarray3(new int[]{1, 2}, 2));
        System.out.println(solution.longestAlternatingSubarray3(new int[]{2, 3, 4, 5}, 4));
        System.out.println(solution.longestAlternatingSubarray3(new int[]{2, 2}, 18));
    }
}
