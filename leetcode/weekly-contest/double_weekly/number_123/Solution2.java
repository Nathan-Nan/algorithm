package double_weekly.number_123;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * <a href="https://leetcode.cn/contest/biweekly-contest-123/problems/find-the-number-of-ways-to-place-people-i/">...</a>
 */
public class Solution2 {
    public int numberOfPairs(int[][] points) {
        int cnt = 0;
        Arrays.sort(points, (o1, o2) -> {
            if (o1[0] != o2[0]) {
                return o1[0] - o2[0];
            }
            return o2[1] - o1[1];
        });
        int n = points.length;
        for (int i = 0; i < n; i++) {
            int[] p1 = points[i];
            TreeSet<Integer> set = new TreeSet<>();
            for (int j = i + 1; j < n; j++) {
                int[] p2 = points[j];
                if (p2[1] > p1[1]) {
                    set.add(p2[1]);
                    continue;
                }
                Integer ceiling = set.ceiling(p2[1]);
                if (ceiling == null || ceiling > p1[1]) {
                    cnt++;
                }
                set.add(p2[1]);
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        // System.out.println(solution.numberOfPairs(new int[][]{{0, 0}, {0, 3}}));
        System.out.println(solution.numberOfPairs(new int[][]{{0, 1}, {1, 3}, {6, 1}}));
    }
}
