package y_2024.m01.d_15.en;

import java.util.*;
import java.util.stream.Collectors;

/**
 * <a href="https://leetcode.com/problems/find-players-with-zero-or-one-losses/description/?envType=daily-question&envId=2024-01-15">...</a>
 */
public class Solution2225 {
    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> winCnt = new HashMap<>();
        Map<Integer, Integer> loseCnt = new HashMap<>();
        Set<Integer> players = new HashSet<>();
        for (int[] match : matches) {
            winCnt.merge(match[0], 1, Integer::sum);
            loseCnt.merge(match[1], 1, Integer::sum);
            players.add(match[0]);
            players.add(match[1]);
        }
        List<Integer> ans0 = new ArrayList<>();
        for (Integer player : players) {
            if (winCnt.containsKey(player) && !loseCnt.containsKey(player)) {
                ans0.add(player);
            }
        }
        ans0.sort(Integer::compareTo);
        List<Integer> ans1 = loseCnt.entrySet().stream().filter(e -> e.getValue() == 1).map(Map.Entry::getKey).collect(Collectors.toList()).stream().sorted().collect(Collectors.toList());
        return new ArrayList<List<Integer>>() {{
            add(ans0);
            add(ans1);
        }};
    }
}
