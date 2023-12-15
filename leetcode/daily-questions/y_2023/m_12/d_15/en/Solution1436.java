package y_2023.m_12.d_15.en;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/destination-city/description/">...</a>
 */
public class Solution1436 {
    public String destCity(List<List<String>> paths) {
        Map<String, String> pathMap = new HashMap<>();
        for (List<String> path : paths) {
            pathMap.put(path.get(0), path.get(1));
        }
        for (List<String> path : paths) {
            if (!pathMap.containsKey(path.get(1))) {
                return path.get(1);
            }
        }
        return "";
    }
}
