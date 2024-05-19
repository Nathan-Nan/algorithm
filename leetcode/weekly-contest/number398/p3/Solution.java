package number398.p3;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Stream;

/**
 * <a href="https://leetcode.cn/contest/weekly-contest-398/problems/sum-of-digit-differences-of-all-pairs/">...</a>
 */
public class Solution {
    public long sumDigitDifferences(int[] nums) {
        long sum = 0;
        Map<Integer, Map<Integer, Long>> map = new HashMap<>();
        for (int num : nums) {
            String str = String.valueOf(num);
            char[] chars = str.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                Map<Integer, Long> vMap = map.getOrDefault(i, new HashMap<>());
                int v = chars[i] - '0';
                vMap.merge(v, 1L, Long::sum);
                map.put(i, vMap);
            }
        }
        for (Map.Entry<Integer, Map<Integer, Long>> entry : map.entrySet()) {
            if (entry.getValue().size() < 2) {
                continue;
            }
            AtomicLong v = new AtomicLong(1L);
            Stream<Long> stream = entry.getValue().values().stream();
            stream.forEach(i -> v.updateAndGet(v1 -> v1 * i));
            sum += v.get();
        }
        return sum;
    }
}
