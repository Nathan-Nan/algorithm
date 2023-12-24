package number_377;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/contest/weekly-contest-377/problems/minimum-cost-to-convert-string-i/">...</a>
 */
public class Solution_3 {
    /**
     * 图论，最短路径问题
     * Floyd 算法
     * 以 cost 为权重
     * 求 original[i] --> changed[i] 的最小权重路径
     */
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int[][] dis = new int[26][26];
        for (int i = 0; i < 26; i++) {
            Arrays.fill(dis[i], Integer.MAX_VALUE / 2);
            dis[i][i] = 0;
        }
        for (int i = 0; i < cost.length; i++) {
            int x = original[i] - 'a';
            int y = changed[i] - 'a';
            dis[x][y] = Math.min(dis[x][y], cost[i]);
        }
        for (int k = 0; k < 26; k++) {
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < 26; j++) {
                    dis[i][j] = Math.min(dis[i][j], dis[i][k] + dis[k][j]);
                }
            }
        }

        long ans = 0;
        for (int i = 0; i < source.length(); i++) {
            int d = dis[source.charAt(i) - 'a'][target.charAt(i) - 'a'];
            if (d == Integer.MAX_VALUE / 2) {
                return -1;
            }
            ans += d;
        }
        return ans;
    }


}
