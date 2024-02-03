package double_weekly.number_123;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <a href="https://leetcode.cn/contest/biweekly-contest-123/problems/type-of-triangle-ii/">...</a>
 */
public class Solution1 {
    public String triangleType(int[] nums) {
        boolean isTriangle = nums[0] + nums[1] > nums[2];
        if (!isTriangle) {
            return "none";
        }
        isTriangle = nums[0] + nums[2] > nums[1];
        if (!isTriangle) {
            return "none";
        }
        isTriangle = nums[1] + nums[2] > nums[0];
        if (!isTriangle) {
            return "none";
        }
        Set<Integer> edges = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        if (edges.size() == 1) {
            return "equilateral";
        } else if (edges.size() == 2) {
            return "isosceles";
        } else {
            return "scalene";
        }
    }
}
