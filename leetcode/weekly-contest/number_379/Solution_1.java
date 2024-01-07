package number_379;

/**
 * <a href="https://leetcode.cn/contest/weekly-contest-379/problems/maximum-area-of-longest-diagonal-rectangle/">...</a>
 */
public class Solution_1 {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        double max = Double.MIN_NORMAL;
        int ans = Integer.MIN_VALUE;
        for (int[] dimension : dimensions) {
            double cur = Math.sqrt(Math.pow(dimension[0], 2) + Math.pow(dimension[1], 2));
            if (cur == max) {
                ans = Math.max(ans, dimension[0] * dimension[1]);
            } else if (cur > max) {
                max = cur;
                ans = dimension[0] * dimension[1];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution_1 solution = new Solution_1();
        System.out.println(solution.areaOfMaxDiagonal(new int[][]{{6, 5}, {8, 6}, {2, 10}, {8, 1}, {9, 2}, {3, 5}, {3, 5}}));
    }
}
