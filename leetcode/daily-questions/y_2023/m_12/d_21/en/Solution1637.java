package y_2023.m_12.d_21.en;

import java.util.Arrays;

public class Solution1637 {

    public int maxWidthOfVerticalArea(int[][] points) {
        Arrays.sort(points, (o1, o2) -> o1[0] - o2[0]);
        int ans = 0;
        for (int i = 1; i < points.length; i++) {
            ans = Math.max(ans, points[i][0] - points[i - 1][0]);
        }
        return ans;
    }
}
