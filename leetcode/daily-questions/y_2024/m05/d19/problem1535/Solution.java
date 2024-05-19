package y_2024.m05.d19.problem1535;

/**
 * <a href="https://leetcode.cn/problems/find-the-winner-of-an-array-game/description/?envType=daily-question&envId=2024-05-19">...</a>
 */
public class Solution {
    public int getWinner(int[] arr, int k) {
        int mx = arr[0];
        int win = 0;
        for (int i = 1; i < arr.length && win < k; i++) {
            if (arr[i] > mx) { // 新的最大值
                mx = arr[i];
                win = 0;
            }
            win++; // 获胜回合 +1
        }
        return mx;
    }
}
