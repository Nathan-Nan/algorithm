package y_2023.m_12.d_27.zh;

/**
 * <a href="https://leetcode.cn/problems/determine-the-winner-of-a-bowling-game/description/?envType=daily-question&envId=2023-12-27">...</a>
 */
public class Solution2660 {

    /**
     * 模拟
     */
    public int isWinner(int[] player1, int[] player2) {
        int n = player1.length;
        int score1 = player1[0];
        int score2 = player2[0];
        for (int i = 1; i < n; i++) {
            score1 += player1[i];
            if (player1[i - 1] == 10 || (i - 2 >= 0 && player1[i - 2] == 10)) {
                score1 += player1[i];
            }
            score2 += player2[i];
            if (player2[i - 1] == 10 || (i - 2 >= 0 && player2[i - 2] == 10)) {
                score2 += player2[i];
            }
        }
        return score1 == score2 ? 0 : score1 > score2 ? 1 : 2;
    }
}
