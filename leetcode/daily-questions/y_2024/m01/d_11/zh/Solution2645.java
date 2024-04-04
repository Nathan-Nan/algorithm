package y_2024.m01.d_11.zh;

/**
 * <a href="https://leetcode.cn/problems/minimum-additions-to-make-valid-string/description/?envType=daily-question&envId=2024-01-11">...</a>
 */
public class Solution2645 {
    /**
     * 暴力匹配
     */
    public int addMinimum(String word) {
        int ans = 0;
        for (int i = 0; i < word.length(); ) {
            if (i + 3 <= word.length() && "abc".equals(word.substring(i, i + 3))) {
                i += 3;
            } else if (i + 2 <= word.length() && ("ab".equals(word.substring(i, i + 2)) || "ac".equals(word.substring(i, i + 2)) || "bc".equals(word.substring(i, i + 2)))) {
                ans++;
                i += 2;
            } else {
                ans += 2;
                i++;
            }
        }

        return ans;
    }

    /**
     * 根据相邻的字母判断需要一个 abc 还是两个
     */
    public int addMinimum1(String word) {
        char[] s = word.toCharArray();
        int t = 1;
        for (int i = 1; i < s.length; i++) {
            if (s[i - 1] >= s[i]) { // 必须生成一个新的 abc
                t++;
            }
        }
        return t * 3 - s.length;
    }

    public static void main(String[] args) {
        Solution2645 solution = new Solution2645();
        System.out.println(solution.addMinimum("b"));
        System.out.println(solution.addMinimum("aaa"));
        System.out.println(solution.addMinimum("abc"));
    }
}
