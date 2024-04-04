package y_2024.m03.d_10.problem299;

/**
 * <a href="https://leetcode.cn/problems/bulls-and-cows/description/?envType=daily-question&envId=2024-03-10">...</a>
 */
public class Solution {
    public String getHint(String secret, String guess) {
        int a = 0;
        int[] cntS = new int[10];
        int[] cntG = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                a++;
            } else {
                cntS[secret.charAt(i) - '0']++;
                cntG[guess.charAt(i) - '0']++;
            }
        }
        int b = 0;
        for (int i = 0; i < 10; i++) {
            b += Math.min(cntS[i], cntG[i]);
        }
        return a + "A" + b + "B";
    }
}
