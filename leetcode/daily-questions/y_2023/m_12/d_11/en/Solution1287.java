package y_2023.m_12.d_11.en;

/**
 * <a href="https://leetcode.cn/problems/element-appearing-more-than-25-in-sorted-array/description/">...</a>
 */
public class Solution1287 {

    /**
     * 暴力解法
     */
    public int findSpecialInteger(int[] arr) {
        int ans = arr[0], cnt = 0, len = arr.length / 4;
        for (int num : arr) {
            if (ans == num) {
                cnt++;
            } else {
                ans = num;
                cnt = 1;
            }

            if (cnt > len) {
                break;
            }
        }

        return ans;
    }

    /**
     * 双指针解法
     */
    public int findSpecialInteger1(int[] arr) {
        int offset = arr.length / 4, len = arr.length;
        for (int i = 0; i < len - offset; i++) {
            if (arr[i] == arr[i + offset]) {
                return arr[i];
            }
        }
        return -1;
    }

    /**
     * 二分解法，有序数组
     */
    public int findSpecialInteger2(int[] arr) {
        int n = arr.length;
        int distance = n / 4;
        for (int i = 0; i < n; i += distance) {
            int left = lowerBound(arr, 0, n, arr[i]);
            int right = upperBound(arr, 0, n, arr[i]);
            if (right - left > distance) {
                return arr[i];
            }
        }

        return -1;
    }

    int lowerBound(int[] arr, int begin, int end, int target) {
        int low = begin;
        int high = end;

        while (low < high) {
            int mid = low + ((high - low) >> 1);
            if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    int upperBound(int[] arr, int begin, int end, int target) {

        int low = begin;
        int high = end;

        while (low < high) {
            int mid = low + ((high - low) >> 1);
            if (arr[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

}
