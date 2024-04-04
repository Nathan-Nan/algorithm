package y_2024.m01.d_02.zh;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/count-the-repetitions/description/?envType=daily-question&envId=2024-01-02">...</a>
 */
public class Solution466 {
    /**
     * 解法一：暴力匹配，超时
     */
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        StringBuilder str1 = new StringBuilder();
        for (int i = 0; i < n1; i++) {
            str1.append(s1);
        }
        StringBuilder str2 = new StringBuilder();
        for (int i = 0; i < n2; i++) {
            str2.append(s2);
        }
        int m = 1, i = 0, j = 0, len1 = str1.length(), len2 = str2.length();
        while (i < len1 && j < len2) {
            while (i < len1 && j < len2 && str1.charAt(i) == str2.charAt(j)) {
                i++;
                j++;
            }
            while (i < len1 && j < len2 && str1.charAt(i) != str2.charAt(j)) {
                i++;
            }
            if (j == len2 && i + j <= len1) {
                m++;
                j = 0;
            }
        }

        return j == len2 ? m : m - 1;
    }

    /**
     * 解法二：暴力匹配 + 优化循环次数，超时
     */
    public int getMaxRepetitions1(String s1, int n1, String s2, int n2) {
        if (s1.length() == 0 || n1 == 0 || s2.length() == 0 || n2 == 0) {
            return 0;
        }
        int indexS2 = 0, countS2 = 0;
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < s1.length(); j++) {
                if (s1.charAt(j) == s2.charAt(indexS2)) {
                    indexS2++;
                    if (indexS2 == s2.length()) {
                        indexS2 = 0;
                        countS2++;
                    }
                }
            }
        }
        return countS2 / n2;
    }

    /**
     * 解法三：参考题解 <a href="https://leetcode.cn/problems/count-the-repetitions/solutions/208874/tong-ji-zhong-fu-ge-shu-by-leetcode-solution/?envType=daily-question&envId=2024-01-02" />
     * AC
     */
    public int getMaxRepetitions2(String s1, int n1, String s2, int n2) {
        if (n1 == 0) {
            return 0;
        }
        int s1cnt = 0, index = 0, s2cnt = 0;
        // recall 是我们用来找循环节的变量，它是一个哈希映射
        // 我们如何找循环节？假设我们遍历了 s1cnt 个 s1，此时匹配到了第 s2cnt 个 s2 中的第 index 个字符
        // 如果我们之前遍历了 s1cnt' 个 s1 时，匹配到的是第 s2cnt' 个 s2 中同样的第 index 个字符，那么就有循环节了
        // 我们用 (s1cnt', s2cnt', index) 和 (s1cnt, s2cnt, index) 表示两次包含相同 index 的匹配结果
        // 那么哈希映射中的键就是 index，值就是 (s1cnt', s2cnt') 这个二元组
        // 循环节就是；
        //    - 前 s1cnt' 个 s1 包含了 s2cnt' 个 s2
        //    - 以后的每 (s1cnt - s1cnt') 个 s1 包含了 (s2cnt - s2cnt') 个 s2
        // 那么还会剩下 (n1 - s1cnt') % (s1cnt - s1cnt') 个 s1, 我们对这些与 s2 进行暴力匹配
        // 注意 s2 要从第 index 个字符开始匹配
        Map<Integer, int[]> recall = new HashMap<>();
        int[] preLoop, inLoop;
        while (true) {
            // 我们多遍历一个 s1，看看能不能找到循环节
            ++s1cnt;
            for (int i = 0; i < s1.length(); ++i) {
                char ch = s1.charAt(i);
                if (ch == s2.charAt(index)) {
                    index += 1;
                    if (index == s2.length()) {
                        ++s2cnt;
                        index = 0;
                    }
                }
            }
            // 还没有找到循环节，所有的 s1 就用完了
            if (s1cnt == n1) {
                return s2cnt / n2;
            }
            // 出现了之前的 index，表示找到了循环节
            if (recall.containsKey(index)) {
                int[] value = recall.get(index);
                int s1cntPrime = value[0];
                int s2cntPrime = value[1];
                // 前 s1cnt' 个 s1 包含了 s2cnt' 个 s2
                preLoop = new int[]{s1cntPrime, s2cntPrime};
                // 以后的每 (s1cnt - s1cnt') 个 s1 包含了 (s2cnt - s2cnt') 个 s2
                inLoop = new int[]{s1cnt - s1cntPrime, s2cnt - s2cntPrime};
                break;
            } else {
                recall.put(index, new int[]{s1cnt, s2cnt});
            }
        }
        // ans 存储的是 S1 包含的 s2 的数量，考虑的之前的 preLoop 和 inLoop
        int ans = preLoop[1] + (n1 - preLoop[0]) / inLoop[0] * inLoop[1];
        // S1 的末尾还剩下一些 s1，我们暴力进行匹配
        int rest = (n1 - preLoop[0]) % inLoop[0];
        for (int i = 0; i < rest; ++i) {
            for (int j = 0; j < s1.length(); ++j) {
                char ch = s1.charAt(j);
                if (ch == s2.charAt(index)) {
                    ++index;
                    if (index == s2.length()) {
                        ++ans;
                        index = 0;
                    }
                }
            }
        }
        // S1 包含 ans 个 s2，那么就包含 ans / n2 个 S2
        return ans / n2;
    }


    public static void main(String[] args) {
        Solution466 solution = new Solution466();
        // System.out.println(solution.getMaxRepetitions("ecbafedcba", 4, "abcdef", 1));
        System.out.println(solution.getMaxRepetitions("phqghumeaylnlfdxfircvscxggbwkfnqduxwfnfozvsrtkjprepggxrpnrvystmwcysyycqpevikef", 1000000, "fmznimkkasvwsrenzkycxfxtlsgypsfad", 333));
    }
}
