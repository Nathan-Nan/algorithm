package y_2024.m_01.d_21.zh;

/**
 * <a href="https://leetcode.cn/problems/split-array-largest-sum/description/?envType=daily-question&envId=2024-01-21">...</a>
 */
public class Solution410 {

    /**
     * 参考题解：<a href="https://leetcode.cn/problems/split-array-largest-sum/solutions/2613046/er-fen-da-an-fu-ti-dan-pythonjavacgojsru-n5la/?envType=daily-question&envId=2024-01-21">...</a>
     */
    public int splitArray(int[] nums, int k) {
        int sum = 0;
        int mx = 0;
        for (int x : nums) {
            sum += x;
            mx = Math.max(mx, x);
        }

        int left = Math.max(mx - 1, (sum - 1) / k);
        int right = sum;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (check(nums, k, mid)) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return right;
    }

    private boolean check(int[] nums, int k, int mx) {
        int cnt = 1;
        int s = 0;
        for (int x : nums) {
            if (s + x <= mx) {
                s += x;
            } else { // 新划分一段
                if (cnt == k) {
                    return false;
                }
                cnt += 1;
                s = x;
            }
        }
        return true;
    }

}
