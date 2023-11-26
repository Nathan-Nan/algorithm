package y_2023.m_11.d_16.en;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <a href="https://leetcode.com/problems/find-unique-binary-string/?envType=daily-question&envId=2023-11-16"></a>
 */
public class Solution1980 {
    public String findDifferentBinaryString(String[] nums) {
        Set<String> numsSet = Arrays.stream(nums).collect(Collectors.toSet());
        StringBuilder ans = new StringBuilder();
        backtrace(numsSet, nums.length, ans);
        return ans.toString();
    }

    private boolean backtrace(Set<String> nums, int length, StringBuilder path) {
        if (path.length() == length) {
            return !nums.contains(path.toString());
        }
        path.append('0');
        if (backtrace(nums, length, path)) {
            return true;
        }
        path.deleteCharAt(path.length() - 1);
        path.append('1');
        if (backtrace(nums, length, path)) {
            return true;
        }
        path.deleteCharAt(path.length() - 1);
        return false;
    }

    public static void main(String[] args) {
        Solution1980 solution = new Solution1980();
        System.out.println(solution.findDifferentBinaryString(new String[]{"01", "10"}));
        System.out.println(solution.findDifferentBinaryString(new String[]{"00", "01"}));
        System.out.println(solution.findDifferentBinaryString(new String[]{"111", "011", "001"}));
    }
}
