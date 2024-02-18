package number_385.problem2;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.cn/problems/find-the-length-of-the-longest-common-prefix/description/">...</a>
 */
public class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Set<String> st = new HashSet<>();
        for (int num : arr1) {
            String s = String.valueOf(num);
            for (int i = 1; i <= s.length(); i++) {
                st.add(s.substring(0, i));
            }
        }

        int ans = 0;
        for (int num : arr2) {
            String s = String.valueOf(num);
            for (int i = 1; i <= s.length(); i++) {
                if (!st.contains(s.substring(0, i))) {
                    break;
                }
                ans = Math.max(ans, i);
            }
        }
        return ans;
    }

}
