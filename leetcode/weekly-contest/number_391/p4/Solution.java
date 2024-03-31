package number_391.p4;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/minimize-manhattan-distances/description/">...</a>
 */
public class Solution {
    // 超时
    public int minimumDistance(int[][] points) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                map.put(i + "-" + j, Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]));
            }
        }
        int ans = Integer.MAX_VALUE / 2;
        for (int i = 0; i < points.length; i++) {
            int tmp = -1;
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                String[] key = entry.getKey().split("-");
                if (key[0].equals(i + "") || key[1].equals(i + "")) {
                    continue;
                } else {
                    tmp = Math.max(tmp, entry.getValue());
                }
            }
            ans = Math.min(tmp, ans);
        }
        return ans;
    }

}
