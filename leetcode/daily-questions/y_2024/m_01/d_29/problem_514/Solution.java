package y_2024.m_01.d_29.problem_514;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/freedom-trail/description/?envType=daily-question&envId=2024-01-29">...</a>
 */
public class Solution {
    private char[] s, t;
    private int[][] left, right, memo;

    public int findRotateSteps(String S, String T) {
        s = S.toCharArray();
        t = T.toCharArray();
        int n = s.length;
        int m = t.length;

        // 先算出每个字母的最后一次出现的下标
        // 由于 s 是环形的，循环结束后的 pos 就刚好是 left[0]
        int[] pos = new int[26]; // 初始值不重要
        for (int i = 0; i < n; i++) {
            s[i] -= 'a';
            pos[s[i]] = i;
        }
        // 计算每个 s[i] 左边 a-z 的最近下标（左边没有就从 n-1 往左找）
        left = new int[n][26];
        for (int i = 0; i < n; i++) {
            System.arraycopy(pos, 0, left[i], 0, 26);
            pos[s[i]] = i; // 更新下标
        }

        // 先算出每个字母的首次出现的下标
        // 由于 s 是环形的，循环结束后的 pos 就刚好是 right[n-1]
        for (int i = n - 1; i >= 0; i--) {
            pos[s[i]] = i;
        }
        // 计算每个 s[i] 右边 a-z 的最近下标（左边没有就从 0 往右找）
        right = new int[n][26];
        for (int i = n - 1; i >= 0; i--) {
            System.arraycopy(pos, 0, right[i], 0, 26);
            pos[s[i]] = i; // 更新下标
        }

        memo = new int[m][n];
        for (int[] row : memo) {
            Arrays.fill(row, -1); // -1 表示没有计算过
        }
        return dfs(0, 0) + m;
    }

    private int dfs(int j, int i) {
        if (j == t.length) {
            return 0;
        }
        if (memo[j][i] != -1) { // 之前计算过
            return memo[j][i];
        }
        int c = t[j] - 'a';
        if (s[i] == c) { // 无需旋转
            return memo[j][i] = dfs(j + 1, i);
        }
        // 左边最近 or 右边最近，取最小值
        int l = left[i][c], r = right[i][c];
        return memo[j][i] = Math.min(dfs(j + 1, l) + (l > i ? s.length - l + i : i - l),
                dfs(j + 1, r) + (r < i ? s.length - i + r : r - i));
    }

}
