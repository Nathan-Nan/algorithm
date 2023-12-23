package y_2023.m_12.d_23.zh;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.cn/problems/remove-stones-to-minimize-the-total/description/?envType=daily-question&envId=2023-12-23">...</a>
 */
public class Solution1962 {

    /**
     * 暴力解法
     * 超时
     */
    public int minStoneSum(int[] piles, int k) {
        while (k-- > 0) {
            int i = getIdOfMax(piles);
            piles[i] = (piles[i] + 1) / 2;
        }
        return Arrays.stream(piles).sum();
    }

    private int getIdOfMax(int[] piles) {
        int idx = 0, num = Integer.MIN_VALUE;
        for (int i = 0; i < piles.length; i++) {
            if (piles[i] > num) {
                idx = i;
                num = piles[i];
            }
        }
        return idx;
    }


    /**
     * 大顶堆解法
     * AC
     */
    public int minStoneSum1(int[] piles, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        Arrays.stream(piles).forEach(queue::offer);
        while (k-- > 0 && !queue.isEmpty()) {
            queue.offer((queue.poll() + 1) >> 1);
        }
        return queue.stream().reduce(0, Integer::sum);
    }
}
