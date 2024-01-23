package y_2024.m_01.d_23.en;

import java.util.List;

/**
 * <a href="https://leetcode.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters/description/?envType=daily-question&envId=2024-01-23">...</a>
 */
public class Solution1239 {
    /**
     * DFS + 位运算优化
     */
    public int maxLength(List<String> arr) {
        int[] bitMap = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            for (char ch : arr.get(i).toCharArray()) {
                int index = ch - 'a';
                if ((bitMap[i] >> index & 1) == 1) {
                    bitMap[i] = -1;
                    break;
                }
                bitMap[i] |= 1 << index;
            }
        }
        return dfs(bitMap, 0, arr, 0);
    }

    public int dfs(int[] bitMap, int bit, List<String> arr, int index) {
        if (index >= bitMap.length) return 0;
        if (bitMap[index] == -1 || (bit & bitMap[index]) != 0) return dfs(bitMap, bit, arr, index + 1);
        return Math.max(dfs(bitMap, bit | bitMap[index], arr, index + 1) + arr.get(index).length(), dfs(bitMap, bit, arr, index + 1));
    }

}
