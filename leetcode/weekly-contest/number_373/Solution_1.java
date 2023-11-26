package number_373;

public class Solution_1 {
    public boolean areSimilar(int[][] mat, int k) {
        int m = mat.length, n = mat[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int next = j;
                for (int l = 0; l < k; l++) {
                    if (i % 2 == 0) {
                        // 偶数行
                        next = next + 1 > n - 1 ? 0 : next + 1;
                    } else {
                        // 奇数行
                        next = next - 1 < 0 ? n - 1 : next - 1;
                    }
                }
                if (mat[i][j] != mat[i][next]) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution_1 solution = new Solution_1();
        System.out.println(solution.areSimilar(new int[][]{{7, 10, 6, 7, 7, 4, 4, 7, 2, 2}, {3, 6, 4, 8, 4, 6, 4, 3, 1, 4}, {4, 8, 7, 1, 10, 2, 10, 8, 10, 1}, {4, 7, 10, 5, 1, 9, 8, 3, 5, 8}, {3, 7, 6, 5, 3, 1, 3, 2, 8, 5}, {6, 1, 5, 10, 8, 7, 7, 10, 1, 3}}, 7));
        System.out.println(solution.areSimilar(new int[][]{{1, 2, 1, 2}, {5, 5, 5, 5}, {6, 3, 6, 3}}, 2));
        System.out.println(solution.areSimilar(new int[][]{{2, 2}, {2, 2}}, 3));
        System.out.println(solution.areSimilar(new int[][]{{1, 2}}, 1));
    }
}
