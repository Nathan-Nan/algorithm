package number_388.problem3;

import java.util.*;
import java.util.stream.Collectors;

/**
 * <a href="https://leetcode.cn/contest/weekly-contest-388/problems/shortest-uncommon-substring-in-an-array/">...</a>
 */
public class Solution {
    private Map<String, Set<String>> subStringMap = new HashMap<>();

    public String[] shortestSubstrings(String[] arr) {
        String[] ans = new String[arr.length];
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (subStringMap.containsKey(arr[i])) {
                ans[i] = "";
                ans[map.get(arr[i])] = "";
            } else {
                subStringMap.put(arr[i], getAllSubstrings(arr[i]));
                map.put(arr[i], i);
            }
        }
        for (int i = 0; i < ans.length; i++) {
            if ("".equals(ans[i])) {
                continue;
            }
            ans[i] = getShortestSubstrings(arr[i]);
        }
        return ans;
    }

    private String getShortestSubstrings(String s) {
        List<String> subStrs = subStringMap.get(s).stream().sorted((o1, o2) -> {
            if (o1.length() == o2.length()) {
                return o1.compareTo(o2);
            }
            return o1.length() - o2.length();
        }).collect(Collectors.toList());
        Set<String> set = subStringMap.entrySet().stream()
                .filter(entry -> !entry.getKey().equals(s))
                .map(Map.Entry::getValue)
                .flatMap(Set::stream)
                .collect(Collectors.toSet());
        for (String subStr : subStrs) {
            if (!set.contains(subStr)) {
                return subStr;
            }
        }
        return "";
    }

    private Set<String> getAllSubstrings(String str) {
        Set<String> substrings = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j < str.length() + 1; j++) {
                substrings.add(str.substring(i, j));
            }
        }
        return substrings;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.shortestSubstrings(new String[]{"cab", "ad", "bad", "c"})));
        System.out.println(Arrays.toString(solution.shortestSubstrings(new String[]{"abc", "bcd", "abcd"})));
        System.out.println(Arrays.toString(solution.shortestSubstrings(new String[]{"gfnt", "xn", "mdz", "yfmr", "fi", "wwncn", "hkdy"})));
        System.out.println(Arrays.toString(solution.shortestSubstrings(new String[]{"fhi", "ct", "s", "o", "o"})));
    }
}
