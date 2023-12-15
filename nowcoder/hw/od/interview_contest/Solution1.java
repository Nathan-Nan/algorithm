package od.interview_contest;

/**
 * 华为 OD 第一轮技术面算法题
 */
public class Solution1 {
    // 请完成： public int solution（int[] ribbons, int k)
    //
    // 给定一个整数数组 ribbons 和一个整数 k，数组每项 ribbons[i] 表示第 i 条绳子的长度。
    //
    // 对于每条绳子，你可以将任意切割成一系列长度为正整数的部分，或者选择不进行切割。
    //
    // 例如，如果给你一条长度为 4 的绳子，你可以：
    //
    // 保持绳子的长度为 4 不变；
    // 切割成一条长度为 3 和一条长度为 1 的绳子；
    // 切割成两条长度为 2 的绳子；
    // 切割成一条长度为 2 和两条长度为 1 的绳子；
    // 切割成四条长度为 1 的绳子。
    // 你的任务是最终得到 k 条完全一样的绳子，他们的长度均为相同的正整数。
    // 如果绳子切割后有剩余，你可以直接舍弃掉多余的部分。
    //
    // 对于这 k 根绳子，返回你能得到的绳子最大长度；
    // 如果你无法得到 k 根相同长度的绳子，返回 0。
    //         —————————————————————————————————————————
    // 示例 1:
    // 输入: ribbons = [9,7,5], k = 3
    // 输出: 5
    // 解释:
    //         - 把第一条绳子切成两部分，一条长度为 5，一条长度为 4；
    //         - 把第二条绳子切成两部分，一条长度为 5，一条长度为 2；
    //         - 第三条绳子不进行切割；
    // 现在，你得到了 3 条长度为 5 的绳子。
    //
    // 示例 2:
    // 输入: ribbons = [7,5,9], k = 4
    // 输出: 4
    // 解释:
    //         - 把第一条绳子切成两部分，一条长度为 4，一条长度为 3；
    //         - 把第二条绳子切成两部分，一条长度为 4，一条长度为 1；
    //         - 把第二条绳子切成三部分，一条长度为 4，一条长度为 4，还有一条长度为 1；
    // 现在，你得到了 4 条长度为 4 的绳子。
    //
    // 示例 3:
    // 输入: ribbons = [5,7,9], k = 22
    // 输出: 0
    // 解释: 由于绳子长度需要为正整数，你无法得到 22 条长度相同的绳子。
    //
    // 提示:
    //         1 <= ribbons.length <= 10^5
    //         1 <= ribbons[i] <= 10^5
    //         1 <= k <= 10^9
    public int solution(int[] ribbons, int k) {
        int l = 1, r = 100000, ans = 0;
        while (l <= r) {
            int len = (l + r) / 2;
            if (isSplit(ribbons, len, k)) {
                l = len + 1;
                ans = len;
            } else {
                r = len - 1;
            }
        }
        return ans;
    }

    private boolean isSplit(int[] ribbons, int len, int k) {
        int cnt = 0;
        for (int ribbon : ribbons) {
            cnt += ribbon / len;
            if (cnt >= k) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        System.out.println(solution.solution(new int[]{9, 7, 5}, 3));
        System.out.println(solution.solution(new int[]{7, 5, 9}, 4));
        System.out.println(solution.solution(new int[]{5, 7, 9}, 22));
    }
}
