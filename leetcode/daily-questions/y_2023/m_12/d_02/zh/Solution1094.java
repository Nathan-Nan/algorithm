package y_2023.m_12.d_02.zh;

/**
 * <a href="https://leetcode.cn/problems/car-pooling/description/?envType=daily-question&envId=2023-12-02">...</a>
 */
public class Solution1094 {
    /**
     * 暴力解法，计算某一段 trip 车上的人数是否超过了 capacity
     * AC
     */
    public boolean carPooling(int[][] trips, int capacity) {
        int[] fromTo = new int[1000];
        for (int[] trip : trips) {
            int numPassengers = trip[0];
            for (int i = trip[1]; i < trip[2]; i++) {
                fromTo[i] += numPassengers;
                if (fromTo[i] > capacity) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 利用差分数组
     * AC
     */
    public boolean carPooling1(int[][] trips, int capacity) {
        int[] d = new int[1001];
        for (int[] t : trips) {
            int num = t[0], from = t[1], to = t[2];
            d[from] += num;
            d[to] -= num;
        }
        int s = 0;
        for (int v : d) {
            s += v;
            if (s > capacity) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution1094 solution = new Solution1094();
        System.out.println(solution.carPooling(new int[][]{{2, 1, 5}, {3, 3, 7}}, 4));
        System.out.println(solution.carPooling(new int[][]{{2, 1, 5}, {3, 3, 7}}, 5));
        System.out.println(solution.carPooling(new int[][]{{2, 1, 5}, {3, 5, 7}}, 3));
    }
}
