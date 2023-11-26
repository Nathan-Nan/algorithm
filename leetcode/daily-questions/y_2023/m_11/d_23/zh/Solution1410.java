package y_2023.m_11.d_23.zh;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/html-entity-parser/description/?envType=daily-question&envId=2023-11-23">...</a>
 */
public class Solution1410 {
    /**
     * 双指针解法
     *
     * @param text
     * @return
     */
    public String entityParser(String text) {
        Map<String, String> map = new HashMap<String, String>() {{
            put("&quot;", "\"");
            put("&apos;", "'");
            put("&amp;", "&");
            put("&gt;", ">");
            put("&lt;", "<");
            put("&frasl;", "/");
        }};
        StringBuilder builder = new StringBuilder();
        int i = 0, j = 0, len = text.length();
        while (i < text.length()) {
            if ('&' == text.charAt(i)) {
                j = i + 1;
                while (j < len && j <= i + 6 && '&' != text.charAt(j) && ';' != text.charAt(j)) {
                    j++;
                }
                String str = map.get(text.substring(i, Math.min(j + 1, len)));
                if (j < len && ';' == text.charAt(j) && str != null) {
                    builder.append(str);
                    i = Math.min(j + 1, len);
                } else {
                    builder.append(text.charAt(i));
                    i++;
                }
            } else {
                builder.append(text.charAt(i));
                i++;
            }
        }
        return builder.toString();
    }

    /**
     * 对双指针代码做优化
     */
    public String entityParser2(String text) {
        Map<String, String> map = new HashMap<String, String>() {{
            put("&quot;", "\"");
            put("&apos;", "'");
            put("&amp;", "&");
            put("&gt;", ">");
            put("&lt;", "<");
            put("&frasl;", "/");
        }};
        StringBuilder builder = new StringBuilder();
        int i = 0, len = text.length();
        while (i < len) {
            if ('&' == text.charAt(i)) {
                int j = i + 1;
                while (j < len && j < i + 6 && ';' != text.charAt(j)) {
                    j++;
                }
                String str = text.substring(i, Math.min(j + 1, len));
                if (map.containsKey(str)) {
                    builder.append(map.get(str));
                    i = j + 1;
                    continue;
                }
            }
            builder.append(text.charAt(i++));
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        Solution1410 solution = new Solution1410();
        System.out.println(solution.entityParser2("&amp; is an HTML entity but &ambassador; is not."));
        System.out.println(solution.entityParser2("and I quote: &quot;...&quot;"));
        System.out.println(solution.entityParser2("Stay home! Practice on Leetcode :)"));
        System.out.println(solution.entityParser2("x &gt; y &amp;&amp; x &lt; y is always false"));
        System.out.println(solution.entityParser2("leetcode.com&frasl;problemset&frasl;all"));
        System.out.println(solution.entityParser2("&&gt;"));
    }
}
