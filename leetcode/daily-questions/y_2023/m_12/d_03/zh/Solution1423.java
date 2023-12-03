package y_2023.m_12.d_03.zh;

/**
 * <a href="https://leetcode.cn/problems/maximum-points-you-can-obtain-from-cards/description/?envType=daily-question&envId=2023-12-03">...</a>
 */
public class Solution1423 {
    /**
     * 滑动窗口
     */
    public int maxScore(int[] cardPoints, int k) {
        int len = cardPoints.length;
        int sumOfK = 0;
        for (int i = 0; i < k; i++) {
            sumOfK += cardPoints[i];
        }
        int ans = sumOfK;
        for (int i = 0; i < k; i++) {
            sumOfK += cardPoints[len - i - 1] - cardPoints[k - 1 - i];
            ans = Math.max(sumOfK, ans);
        }
        return ans;
    }
}
