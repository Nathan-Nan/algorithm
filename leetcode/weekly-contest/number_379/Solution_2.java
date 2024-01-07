package number_379;

/**
 * <a href="https://leetcode.cn/contest/weekly-contest-379/problems/minimum-moves-to-capture-the-queen/">...</a>
 */
public class Solution_2 {

    public int minMovesToCaptureTheQueen(int a, int b, int c, int d, int e, int f) {
        if (a == e || b == f) {
            if (a == e && c == e && isBetween(d, b, f)) {
                // 白车和黑皇后在一条横线上，但是被白象挡住了
            } else if (b == f && d == f && isBetween(c, a, e)) {
                // 白车和黑皇后在一条纵线上，但是被白象挡住了
            } else {
                return 1;
            }
        }
        if (c + d == e + f) {
            if (a + b == c + d && isBetween(a, c, e)) {
                // 白象和黑皇后在一条对角线上，但是被白车挡住了
            } else {
                return 1;
            }
        }
        if (c - d == e - f) {
            if (a - b == c - d && isBetween(a, c, e)) {
                // 白象和黑皇后在一条对角线上，但是被白车挡住了
            } else {
                return 1;
            }
        }
        return 2;
    }

    private boolean isBetween(int a, int b, int c) {
        return (a > b && a < c) || (a > c && a < b);
    }
}
