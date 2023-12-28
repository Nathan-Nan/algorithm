package y_2023.m_12.d_28.en;

/**
 * <a href="https://leetcode.com/problems/string-compression-ii/description/?envType=daily-question&envId=2023-12-28">...</a>
 */
public class Solution1531 {
    int[] temp;
    char[] chars;
    int K;

    /**
     * DP + DFS
     * 参考题解：<a href="https://leetcode.cn/problems/string-compression-ii/solutions/1332245/by-shi-guang-fang-zhu-ri4t/">...</a>
     */
    public int getLengthOfOptimalCompression(String s, int k) {
        K = k + 1;
        int n = s.length();
        chars = s.toCharArray();
        temp = new int[K * (n - k)];
        return dfs(n, k);
    }

    public int dfs(int n, int k) {
        if (n <= k) return 0;
        int index = K * (n - 1 - k) + k;
        if (temp[index] > 0) return temp[index];
        temp[index] = k > 0 ? dfs(n - 1, k - 1) : n;
        int i = n, same = 0, diff = 0;
        while (--i >= 0 && diff <= k) {
            if (chars[i] == chars[n - 1]) {
                ++same;
                temp[index] = Math.min(temp[index], dfs(i, k - diff) + calc(same));
            } else {
                ++diff;
            }
        }
        return temp[index];
    }

    public int calc(int x) {
        return x == 1 ? 1 : x < 10 ? 2 : x < 100 ? 3 : 4;
    }


    public static void main(String[] args) {
        Solution1531 solution = new Solution1531();
        System.out.println(solution.getLengthOfOptimalCompression("aaabcccd", 2));
        System.out.println(solution.getLengthOfOptimalCompression("aabbaa", 2));
        System.out.println(solution.getLengthOfOptimalCompression("aaaaaaaaaaa", 0));
        System.out.println(solution.getLengthOfOptimalCompression("aabaabbcbbbaccc", 6));
        System.out.println(solution.getLengthOfOptimalCompression("bbabbbabbbbcbb", 4));
        System.out.println(solution.getLengthOfOptimalCompression("aaaaabaaaaafffwfff", 2));
        System.out.println(solution.getLengthOfOptimalCompression("aaaabbab", 3));
        System.out.println(solution.getLengthOfOptimalCompression("abcdefghijklmnopqrstuvwxyz", 16));
    }
}
