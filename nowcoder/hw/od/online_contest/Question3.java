package od.online_contest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringJoiner;

/**
 * 题目：加密算法
 * <p>
 * 描述：
 * 有一种特殊的加密算法，明文为一段数字串，经过密码本查找转换，生成另一段密文数字串。规
 * 则如下：
 * 1. 明文为一段数字串由0~9组成
 * 2. 密码本为数字0-9组成的二维数组
 * 3. 需要按明文串的数字顺序在密码本里找到同样的数字串，密码本里的数字串是由相邻的单元格数字组成，上下和左右是相邻的，注意：对角线不相邻，同一个单元格的数字不能重复使用。
 * 4. 每一位明文对应密文即为密码本中找到的单元格所在的行和列序号（序号从0开始） 组成的两个数宇。如明文 第i位Data[i]对应密码本单元格为Book[i][j], 则明文第i位对应的密文为X Y, X和Y之间用空格隔开。如果有多条密文，返回字符序最小的密文。如果密码本无法匹配，返回"error".
 * 请你设计这个加密程序。
 * 输入描述：
 * 1
 * 3
 * 3
 * 0 0 2
 * 1 3 4
 * 6 6 4
 * 第一行代表明文密码长度 N [1, 200]
 * 第二行代表 N 个明文
 * 第三行数值为密码本的大小 M，密码本为 M * M 的矩阵，[1, 200]
 * 接下来 M 行为密码本
 * 输出描述：
 * 1 1
 * 表示对应的密文为 "1 1"
 * 示例1:
 * 密码本:
 * (0, 0, 2),
 * (1, 3, 4),
 * (6, 6, 4)
 * 明文 "3",密文"1 1"
 * 示例2:
 * 密码本:
 * (0, 0, 2),
 * (1, 3, 4),
 * (6, 6, 4)
 * 明文 "03",密文"0 1 1 1”
 * 示例3:
 * 密码本:
 * (0, 0, 2, 4),
 * (1, 3, 4, 6),
 * (3, 4, 1, 5),
 * (6, 6, 6, 5)
 * 输入: 明文"0 0 2 4",密文 "0 0 0 1 0 2 0 3"和"0 0 0 1 0 2 1 2",返回字符序小的 "0 0 0 1 0 2 0 3"
 * 输入:明文"8 2 2 3"，密文"error",密码本中无法匹配。
 * <p>
 * 通过用例：73.33%
 */
public class Question3 {

    private static List<int[]> offsets = new ArrayList<int[]>() {{
        add(new int[]{-1, 0}); // 上
        add(new int[]{0, -1}); // 左
        add(new int[]{0, 1}); // 右
        add(new int[]{1, 0}); // 下
        // add(new int[]{0, -1});
        // add(new int[]{0, 1});
    }};

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = in.nextInt();
        }
        int m = in.nextInt();
        int[][] book = new int[m][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                book[i][j] = in.nextInt();
            }
        }

        boolean[][] visited = new boolean[m][m];
        List<String> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                dfs(data, 0, book, i, j, visited, new ArrayList<>(), res);
            }
        }

        if (res.isEmpty()) {
            System.out.println("error");
            return;
        }
        // res.sort(String::compareTo);
        // StringBuilder ans = new StringBuilder();
        // for (char c : res.get(0).toCharArray()) {
        //     ans.append(c).append(" ");
        // }
        // System.out.println(ans.toString().trim());
        System.out.println(res.get(0).trim());
    }

    private static void dfs(int[] data, int dataIdx, int[][] book, int i, int j, boolean[][] visited, List<int[]> path, List<String> res) {
        // 剪枝1: 边界校验
        if (dataIdx < 0 || dataIdx >= data.length || i < 0 || j < 0 || i >= book.length || j >= book.length) {
            return;
        }
        // 剪枝2: visited[i][j] = true
        if (visited[i][j]) {
            return;
        }
        // 剪枝3: data[dataIdx] != book[i]][j]
        if (data[dataIdx] != book[i][j]) {
            return;
        }

        path.add(new int[]{i, j});
        visited[i][j] = true;

        if (data.length == dataIdx + 1) {
            // 找到了
            // StringBuilder builder = new StringBuilder();
            StringJoiner joiner = new StringJoiner(" ");
            for (int[] x : path) {
                // builder.append(x[0]).append("_").append(x[1]);
                joiner.add(x[0] + " " + x[1]);
            }
            // res.add(builder.toString());
            res.add(joiner.toString());
            path.remove(path.size() - 1);
            visited[i][j] = false;
            return;
        }

        for (int[] offset : offsets) {
            dfs(data, dataIdx + 1, book, i + offset[0], j + offset[1], visited, path, res);
        }

        path.remove(path.size() - 1);
        visited[i][j] = false;
    }

}
