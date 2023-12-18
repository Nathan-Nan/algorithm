package y_2023.m_12.d_18.zh;

/**
 * <a href="https://leetcode.cn/problems/find-peak-element/description/?envType=daily-question&envId=2023-12-18">...</a>
 */
public class Solution162 {

    /**
     * 时间复杂度：O(n)
     */
    public int findPeakElement(int[] nums) {
        if (nums.length == 1) return 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 && nums[i] > nums[i + 1]) {
                return i;
            }
            if (i == nums.length - 1 && nums[i] > nums[i - 1]) {
                return i;
            }
            if (i != 0 && i != nums.length - 1 && nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 时间复杂度：O(logN)
     * 虽然 nums 不是有序数组但是其具有二分性，即对于峰值当满足 nums[mid] > nums[mid + 1] 时，则必有 nums[i] > nums[i - 1]，故此时通过二分去左侧查找
     */
    public int findPeakElement1(int[] nums) {
        int left = -1, right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) >> 1;
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return right;
    }
}
