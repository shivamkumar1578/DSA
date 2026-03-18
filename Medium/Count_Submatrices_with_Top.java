package Medium;

public class Count_Submatrices_with_Top {
    class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        long[][] pre = new long[m + 1][n + 1];
        int count = 0;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                pre[i][j] = grid[i - 1][j - 1] + pre[i - 1][j] + pre[i][j - 1] - pre[i - 1][j - 1];
                if (pre[i][j] <= k) count++;
            }
        }

        return count;
    }
}
}
