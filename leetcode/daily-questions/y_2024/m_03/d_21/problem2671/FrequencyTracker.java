package y_2024.m_03.d_21.problem2671;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/frequency-tracker/description/?envType=daily-question&envId=2024-03-21">...</a>
 */
public class FrequencyTracker {
    private final Map<Integer, Integer> cnt = new HashMap<>(); // number 的出现次数
    private final Map<Integer, Integer> freq = new HashMap<>(); // number 的出现次数的出现次数

    public FrequencyTracker() {
    }

    public void update(int number, int delta) {
        int c = cnt.merge(number, delta, Integer::sum);
        freq.merge(c - delta, -1, Integer::sum); // 去掉一个旧的 cnt[number]
        freq.merge(c, 1, Integer::sum); // 添加一个新的 cnt[number]
    }

    public void add(int number) {
        update(number, 1);
    }

    public void deleteOne(int number) {
        if (cnt.getOrDefault(number, 0) > 0) {
            update(number, -1);
        }
    }

    public boolean hasFrequency(int frequency) {
        return freq.getOrDefault(frequency, 0) > 0; // 至少有一个 number 的出现次数恰好为 frequency
    }
}
