package number_387.problem4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.cn/contest/weekly-contest-387/problems/distribute-elements-into-two-arrays-ii/">...</a>
 */
public class Solution {
    public int[] resultArray(int[] nums) {
        List<Integer> arr1 = new ArrayList<>();
        List<Integer> arr1Sorted = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();
        List<Integer> arr2Sorted = new ArrayList<>();
        arr1.add(nums[0]);
        arr1Sorted.add(nums[0]);
        arr2.add(nums[1]);
        arr2Sorted.add(nums[1]);
        for (int i = 2; i < nums.length; i++) {
            int cnt1 = greaterCount(arr1Sorted, nums[i]);
            int cnt2 = greaterCount(arr2Sorted, nums[i]);
            if (cnt1 > cnt2) {
                arr1.add(nums[i]);
                add(arr1Sorted, nums[i]);
            } else if (cnt1 < cnt2) {
                arr2.add(nums[i]);
                add(arr2Sorted, nums[i]);
            } else if (arr1.size() <= arr2.size()) {
                arr1.add(nums[i]);
                add(arr1Sorted, nums[i]);
            } else {
                arr2.add(nums[i]);
                add(arr2Sorted, nums[i]);
            }
        }
        arr1.addAll(arr2);
        return arr1.stream().mapToInt(Integer::intValue).toArray();
    }

    private void add(List<Integer> arr, int num) {
        arr.add(getFirstGreaterValue(arr, num), num);
    }

    private int getFirstGreaterValue(List<Integer> arr, int num) {
        int l = 0, r = arr.size();
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (arr.get(mid) > num) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    private int greaterCount(List<Integer> arr, int num) {
        return arr.size() - getFirstGreaterValue(arr, num);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.resultArray(new int[]{2, 1, 3, 3})));
        System.out.println(Arrays.toString(solution.resultArray(new int[]{5, 14, 3, 1, 2})));
        System.out.println(Arrays.toString(solution.resultArray(new int[]{3, 3, 3, 3})));
    }
}
