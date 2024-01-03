package y_2024.m_01.d_03.en;

/**
 * <a href="https://leetcode.com/problems/number-of-laser-beams-in-a-bank/description/?envType=daily-question&envId=2024-01-03">...</a>
 */
public class Solution2125 {
    /**
     * 解法一：暴力遍历，O(m * n * n)，超时
     */
    public int numberOfBeams(String[] bank) {
        int m = bank.length, n = bank[0].length();
        boolean[] hasSecurityDevices = new boolean[m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (bank[i].charAt(j) == '1') {
                    hasSecurityDevices[i] = true;
                    break;
                }
            }
        }
        int ans = 0;
        for (int i = 1; i < m; i++) {
            int r = -1;
            for (int j = i - 1; j >= 0; j--) {
                if (hasSecurityDevices[j]) {
                    r = j;
                    break;
                }
            }
            if (r == -1) {
                continue;
            }
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (bank[i].charAt(j) == '1' && bank[r].charAt(k) == '1') {
                        ans++;
                    }
                }
            }
        }
        return ans;
    }

    /**
     * 解法二：直接计算
     * 当不同行 r1 和 r2 分别有 n1 和 n2 台安全设备时，共有：n1 * n2 条激光束
     */
    public int numberOfBeams1(String[] bank) {
        int n = bank[0].length(), ans = 0, last = 0;
        for (String b : bank) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (b.charAt(j) == '1') {
                    count++;
                }
            }
            if (count > 0) {
                ans += last * count;
                last = count;
            }
        }
        return ans;
    }
}
