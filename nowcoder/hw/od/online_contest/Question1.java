package od.online_contest;

import java.util.Scanner;


/**
 * 题目：掌握单词个数
 * <p>
 * 描述：
 * 有一个字符串数组 words 和一个字符串 chars。
 * 假如可以用chars中的字母拼写出words中的某个"单词"(字符串)，那么我们就认为你掌握了这个单词。
 * words的字符仅由 a-z 英文小写字母组成。 例如: abc
 * chars 由a-z 英文小写字母和"?"组成。其中英文问号"?"表示万能字符，能够在拼写时当做任意一个英文字母。 例如:"?"可以当做"a"等字母。
 * 注意:每次拼写时,chars中的每个字母和万能字符都只能使用一次。
 * 输出词汇表words中你掌握的所有单词的个数。没有掌握任何单词，则输出0.
 * <p>
 * 输入描述：
 * 第1行输入数组words的个数，记为N。
 * 从第2行开始到第N+1行依次输入数组words的每个字符串元素。
 * 第N+2行输入字符串chars。
 * 输出描述：
 * 输出一个整数,表示词汇表words中你掌握的单词个数。
 * <p>
 * 通过用例：100%
 * 参考专栏：<a href="https://fcqian.blog.csdn.net/article/details/134642497">...</a>
 */
public class Question1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int wordsCount = in.nextInt();
        String[] words = new String[wordsCount];
        for (int i = 0; i < wordsCount; i++) {
            words[i] = in.next();
        }
        String chars = in.next();
        int ans = 0;
        for (String word : words) {
            if (isLeaner(word, chars)) {
                ans++;
            }
        }
        System.out.println(ans);
    }

    private static boolean isLeaner(String word, String chars) {
        int[] wordChars = getCharArray(word);
        int[] charArray = getCharArray(chars);
        int noMatch = 0;
        for (int i = 0; i < 128; i++) {
            noMatch += Math.max(wordChars[i] - charArray[i], 0);
        }
        return noMatch <= charArray['?'];
    }

    private static int[] getCharArray(String str) {
        int[] chars = new int[128];
        for (char c : str.toCharArray()) {
            chars[c]++;
        }
        return chars;
    }
}
