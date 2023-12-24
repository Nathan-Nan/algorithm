package y_2023.m_12.d_24.zh;

/**
 * <a href="https://leetcode.cn/problems/minimum-garden-perimeter-to-collect-enough-apples/?envType=daily-question&envId=2023-12-24">...</a>
 */
public class Solution1954 {
    /**
     * 数学法，直接计算
     */
    public long minimumPerimeter(long neededApples) {
        long n = (long) Math.cbrt(neededApples / 4.0);
        if (2 * n * (n + 1) * (2 * n + 1) < neededApples) {
            n++;
        }
        return 8 * n;
    }

    /**
     * 基于公式，二分查找
     * 要注意 long 类型和 int 类型转换时精度丢失的问题
     */
    public long minimumPerimeter1(long neededApples) {
        int l = 1, r = 100000, n = 0;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (getApples(mid) < neededApples) {
                l = mid + 1;
            } else {
                n = mid;
                r = mid - 1;
            }
        }
        return 8L * n;
    }

    private long getApples(long n) {
        return 2 * n * (n + 1) * (2 * n + 1);
    }

    public static void main(String[] args) {
        Solution1954 solution = new Solution1954();
        System.out.println(solution.minimumPerimeter1(1));
        System.out.println(solution.minimumPerimeter1(13));
        System.out.println(solution.minimumPerimeter1(1000000000));
    }
}
