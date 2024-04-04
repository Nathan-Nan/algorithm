package y_2024.m01.d_08.zh;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/number-of-boomerangs/description/?envType=daily-question&envId=2024-01-08">...</a>
 */
public class Solution447 {
    /**
     * 暴力枚举，AC
     * 时间复杂度：O(n^3)
     * 空间复杂度：O(1)
     */
    public int numberOfBoomerangs(int[][] points) {
        if (points.length < 3) return 0;
        int ans = 0;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                for (int k = j + 1; k < points.length; k++) {
                    if (isBoomerang(points[i], points[j], points[k])) ans += 2;
                    if (isBoomerang(points[j], points[i], points[k])) ans += 2;
                    if (isBoomerang(points[k], points[j], points[i])) ans += 2;
                }
            }
        }
        return ans;
    }

    private boolean isBoomerang(int[] i, int[] j, int[] k) {
        int d1 = (i[0] - j[0]) * (i[0] - j[0]) + (i[1] - j[1]) * (i[1] - j[1]);
        int d2 = (i[0] - k[0]) * (i[0] - k[0]) + (i[1] - k[1]) * (i[1] - k[1]);
        return d1 == d2;
    }


    /**
     * 暴力枚举，使用哈希表优化
     * AC
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(n)
     */
    public int numberOfBoomerangs1(int[][] points) {
        int ans = 0;
        // 在外面 new，比在内层循环 new 效率更高
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int[] p1 : points) {
            cnt.clear();
            for (int[] p2 : points) {
                int d2 = (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
                int c = cnt.getOrDefault(d2, 0);
                ans += c * 2;
                cnt.put(d2, c + 1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution447 solution = new Solution447();
        System.out.println(solution.numberOfBoomerangs(new int[][]{{0, 0}, {1, 0}, {2, 0}}));
        System.out.println(solution.numberOfBoomerangs(new int[][]{{1, 1}, {2, 2}, {3, 3}}));
        System.out.println(solution.numberOfBoomerangs(new int[][]{{1, 1}}));
    }
}
