package y_2024.m_02.d_04.problem_292;

/**
 * <a href="https://leetcode.cn/problems/nim-game/description/?envType=daily-question&envId=2024-02-04">...</a>
 */
public class Solution {
    /**
     * 由题目可以看出，当 n 是 4 的倍数时，你必输
     */
    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }
}
