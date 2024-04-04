package y_2024.m01.d_17.en;

/**
 * <a href="https://leetcode.com/problems/unique-number-of-occurrences/description/?envType=daily-question&envId=2024-01-17">...</a>
 */
public class Solution1207 {
    public boolean uniqueOccurrences(int[] arr) {
        int[] counts = new int[2000];
        for (int i : arr) {
            counts[i + 1000]++;
        }
        boolean[] used = new boolean[1000];
        for (int cnt : counts) {
            if (cnt == 0) {
                continue;
            }
            if (used[cnt]) {
                return false;
            }
            used[cnt] = true;
        }
        return true;
    }
}
