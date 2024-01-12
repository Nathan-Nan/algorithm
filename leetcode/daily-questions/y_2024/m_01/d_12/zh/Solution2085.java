package y_2024.m_01.d_12.zh;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/count-common-words-with-one-occurrence/?envType=daily-question&envId=2024-01-12">...</a>
 */
public class Solution2085 {
    public int countWords(String[] words1, String[] words2) {
        Map<String, Integer> map1 = new HashMap<>();
        for (String s : words1) {
            map1.put(s, map1.getOrDefault(s, 0) + 1);
        }
        Map<String, Integer> map2 = new HashMap<>();
        for (String s : words2) {
            map2.put(s, map1.getOrDefault(s, 0) + 1);
        }
        int ans = 0;
        for (Map.Entry<String, Integer> entry : map1.entrySet()) {
            if (entry.getValue() == 1 && map2.getOrDefault(entry.getKey(), 0) == 1) {
                ans++;
            }
        }
        return ans;
    }
}
