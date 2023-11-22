package en;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <a href="https://leetcode.com/problems/diagonal-traverse-ii/?envType=daily-question&envId=2023-11-22">...</a>
 */
public class Solution1424 {
    /**
     * BFS
     */
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        Deque<Iterator<Integer>> s = new LinkedList<>();
        List<Integer> res = new LinkedList<>();
        for (List<Integer> list : nums) {
            s.addLast(list.iterator());
            int len = s.size();
            for (int i = 0; i < len; ++i) {
                Iterator<Integer> pop = s.removeLast();
                res.add(pop.next());
                if (pop.hasNext()) {
                    s.addFirst(pop);
                }
            }
        }
        // 处理剩下的
        while (!s.isEmpty()) {
            Iterator<Integer> pop = s.removeLast();
            res.add(pop.next());
            if (pop.hasNext()) {
                s.addFirst(pop);
            }
        }
        return res.stream().mapToInt(Integer::valueOf).toArray();
    }

    public static void main(String[] args) {
        Solution1424 solution = new Solution1424();
        List<List<Integer>> list = Stream.of(Stream.of(1, 2, 3).collect(Collectors.toList()), Stream.of(4, 5, 6).collect(Collectors.toList()), Stream.of(7, 8, 9).collect(Collectors.toList())).collect(Collectors.toList());
        System.out.println(Arrays.toString(solution.findDiagonalOrder(list)));
    }
}
