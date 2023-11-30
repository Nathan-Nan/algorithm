package od;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 题目：求最多可以派出多少支团队
 * <p>
 * 描述：
 * 用数组代表每个人的能力,一个比赛活动要求参赛团队的最低能力值为N,每个团队可以由1人或2人组成，且1个人只能参加1个团队，请计算出最多可以派出多少支符合要求的团队?
 * <p>
 * 输入描述：
 * 5
 * 3 1 5 7 9
 * 8
 * 第一行数组代表总人数，范围[1,500000]
 * 第二行数组代表每个人的能力，每个元素的取值范围[1, 500000],数组的大小范围[1,500000]
 * 第三行数值为团队要求的最低能力值,范围[1,500000]
 * 输出描述：
 * 3
 * 最多可以派出的团队数量
 * <p>
 * 通过用例：100%
 * 参考专栏：<a href="https://fcqian.blog.csdn.net/article/details/127418310">...</a>
 */
public class Question2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] abilities = new int[n];
        for (int i = 0; i < n; i++) {
            abilities[i] = in.nextInt();
        }
        int minAbility = in.nextInt();

        Arrays.sort(abilities);

        int left = 0, right = n - 1, ans = 0;
        while (right >= left && abilities[right] >= minAbility) {
            right--;
            ans++;
        }

        while (left < right) {
            int sum = abilities[left] + abilities[right];
            if (sum < minAbility) {
                left++;
            } else {
                ans++;
                left++;
                right--;
            }
        }

        System.out.println(ans);
    }
}
