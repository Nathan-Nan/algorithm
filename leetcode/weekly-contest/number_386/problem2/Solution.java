package number_386.problem2;

/**
 * <a href="https://leetcode.cn/contest/weekly-contest-386/problems/find-the-largest-area-of-square-inside-two-rectangles/">...</a>
 */
public class Solution {
    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        long max = 0;
        int n = bottomLeft.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                long t = area(bottomLeft[i], topRight[i], bottomLeft[j], topRight[j]);
                max = Math.max(t, max);
            }
        }
        return max;
    }

    long area(int[] bl1, int[] tr1, int[] bl2, int[] tr2) {
        int l1 = inter(bl1[0], tr1[0], bl2[0], tr2[0]);
        int l2 = inter(bl1[1], tr1[1], bl2[1], tr2[1]);
        long l = Math.min(l1, l2);
        return l * l;
    }

    int inter(int x0, int y0, int x1, int y1) {
        if (x0 <= x1) {
            if (y0 <= x1) return 0;
            return Math.min(y1, y0) - x1;
        } else {
            if (y1 <= x0) return 0;
            return Math.min(y1, y0) - x0;
        }
    }

}
