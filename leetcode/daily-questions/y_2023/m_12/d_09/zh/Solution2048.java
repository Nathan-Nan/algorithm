package y_2023.m_12.d_09.zh;

/**
 * <a href="https://leetcode.cn/problems/next-greater-numerically-balanced-number/description/?envType=daily-question&envId=2023-12-09">...</a>
 */
public class Solution2048 {

    public int nextBeautifulNumber(int n) {
        while (true) {
            if (isBeautifulNumber(++n)) {
                return n;
            }
        }
    }

    private boolean isBeautifulNumber(int n) {
        int[] numsCnt = new int[10];
        int i = n;
        while (i > 0) {
            numsCnt[i % 10]++;
            i /= 10;
        }
        for (int j = 0; j < numsCnt.length; j++) {
            if (numsCnt[j] == 0) {
                continue;
            }
            if (numsCnt[j] != j) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution2048 solution = new Solution2048();
        System.out.println(solution.nextBeautifulNumber(1));
        System.out.println(solution.nextBeautifulNumber(1000));
        System.out.println(solution.nextBeautifulNumber(3000));
    }
}
