package double_weekly.number126.problem_3;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * <a href="https://leetcode.cn/contest/biweekly-contest-126/problems/replace-question-marks-in-string-to-minimize-its-value/">...</a>
 */
public class Solution {
    public String minimizeStringValue(String s) {
        int[] frequency = new int[26];
        int cnt = 0;
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (aChar == '?') {
                cnt++;
            } else {
                frequency[aChar - 'a']++;
            }
        }
        Queue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);
        for (int i = 0; i < frequency.length; i++) {
            queue.offer(new int[]{frequency[i], i});
        }
        if (cnt == 0) {
            return s;
        }

        StringBuilder ans = new StringBuilder(s);
        for (int i = 0; i < cnt && !queue.isEmpty(); i++) {
            int[] polled = queue.poll();
            ans.setCharAt(ans.indexOf("?"), (char) (polled[1] + 'a'));
            queue.offer(new int[]{polled[0] + 1, polled[1]});
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minimizeStringValue("???"));
        System.out.println(solution.minimizeStringValue("a?a?"));
    }
}
