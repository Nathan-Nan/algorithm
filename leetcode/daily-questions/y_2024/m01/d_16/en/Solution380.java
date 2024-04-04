package y_2024.m01.d_16.en;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/insert-delete-getrandom-o1/description/?envType=daily-question&envId=2024-01-16">...</a>
 */
public class Solution380 {

    static class RandomizedSet {

        private final List<Integer> nums;
        private final Map<Integer, Integer> map;
        private final Random random;

        public RandomizedSet() {
            nums = new ArrayList<>();
            map = new HashMap<>();
            random = new Random();
        }

        public boolean insert(int val) {
            if (map.containsKey(val)) {
                return false;
            }
            nums.add(val);
            map.put(val, nums.size() - 1);
            return true;
        }

        public boolean remove(int val) {
            if (!map.containsKey(val)) {
                return false;
            }
            Integer idx = map.get(val);
            Integer last = nums.get(nums.size() - 1);
            nums.set(idx, last);
            map.put(last, idx);
            nums.remove(nums.size() - 1);
            map.remove(val);
            return true;
        }

        public int getRandom() {
            return nums.get(random.nextInt(nums.size()));
        }
    }
}
