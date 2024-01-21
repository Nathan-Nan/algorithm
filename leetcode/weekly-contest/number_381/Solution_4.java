package number_381;

/**
 * <a href="https://leetcode.cn/contest/weekly-contest-381/problems/count-the-number-of-houses-at-a-certain-distance-ii/">...</a>
 */
public class Solution_4 {
    public long[] countOfPairs(int n, int x, int y) {
        x--;
        y--;

        long[] res = new long[n];
        if (x == y) {
            // 特判
            for (int i = 0; i < n; i++) {
                res[i] = (n - 1 - i) * 2L;
            }
        } else {
            // 找到环
            // 环中的个数
            int m = Math.abs(x - y) + 1;
            if (m % 2 == 0) {
                int e = m / 2;
                for (int i = 0; i < e - 1; i++) {
                    res[i] += (long) m * 2;
                }
                res[e - 1] += m;
            } else {
                int e = m / 2;
                for (int i = 0; i < e; i++) {
                    res[i] += (long) m * 2;
                }
            }

            // 处理两条链路
            if (x > y) {
                // swap
                int t = x;
                x = y;
                y = t;
            }

            long[] diff = new long[n + 1];
            // 左侧存在链
            if (x > 0) {
                if (m % 2 == 0) {
                    for (int i = 0; i < x; i++) {
                        res[(x - i) - 1] += 2;
                        diff[(x - i)] += 4;
                        diff[(x - i) + m / 2 - 1] -= 4;
                        res[(x - i) + m / 2 - 1] += 2;
                    }
                } else {
                    for (int i = 0; i < x; i++) {
                        res[(x - i) - 1] += 2;
                        diff[(x - i)] += 4;
                        diff[(x - i) + m / 2] -= 4;
                    }
                }
            }

            int tt = n - 1 - y;
            // 右侧存在链
            if (y + 1 < n) {
                if (m % 2 == 0) {
                    for (int i = 0; i < tt; i++) {
                        res[(tt - i) - 1] += 2;
                        diff[(tt - i)] += 4;
                        diff[(tt - i) + m / 2 - 1] -= 4;
                        res[(tt - i) + m / 2 - 1] += 2;
                    }
                } else {
                    for (int i = 0; i < tt; i++) {
                        res[(tt - i) - 1] += 2;
                        diff[(tt - i)] += 4;
                        diff[(tt - i) + m / 2] -= 4;
                    }
                }
            }

            // 左右侧的链
            for (int i = 0; i < x; i++) {
                diff[(x - i) + 1] += 2;
                diff[(x - i) + 1 + tt] -= 2;
            }

            long delta = 0;
            for (int i = 0; i < n; i++) {
                delta += diff[i];
                res[i] += delta;
            }

            for (int i = 0; i < x - 1; i++) {
                res[i] += (long) (x - 1 - i) * 2;
            }

            for (int i = 0; i < tt - 1; i++) {
                res[i] += (long) (tt - 1 - i) * 2;
            }

        }

        return res;
    }

}
