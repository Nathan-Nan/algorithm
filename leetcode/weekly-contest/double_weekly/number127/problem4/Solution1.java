package double_weekly.number127.problem4;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 通过
 */
public class Solution1 {
    public int sumOfPowers(int[] nums, int k) {
        long mod = (long) (1e9 + 7);
        int n = nums.length;
        Arrays.sort(nums);
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                set.add(nums[j] - nums[i]);
            }
        }
        int[] arr = new int[set.size()];
        int index = 0;
        for (Integer v : set) {
            arr[index] = v;
            index++;
        }
        Arrays.sort(arr);
        long[] cnt = new long[arr.length];
        for (int i = 0; i < arr.length; i++) {
            long[][] dp = new long[n + 1][k + 1];
            dp[0][0] = 1;
            for (int j = 1; j <= n; j++) {
                int p = 0;
                for (int l = 0; l < j; l++) {
                    if (nums[j - 1] - nums[l] >= arr[i]) {
                        p = l + 1;
                        continue;
                    }
                    break;
                }
                dp[j][0] = 1;
                for (int l = 1; l <= k; l++) {
                    dp[j][l] = dp[j - 1][l] + dp[p][l - 1];
                    dp[j][l] %= mod;
                }
            }
            cnt[i] = dp[n][k];
        }
        long sum = 0;
        for (int i = 0; i < cnt.length - 1; i++) {
            sum += arr[i] * ((cnt[i] - cnt[i + 1]) % mod) % mod;
            sum %= mod;
        }
        sum += arr[arr.length - 1] * cnt[cnt.length - 1] % mod;
        return (int) (((sum % mod) + mod) % mod);
    }
}
