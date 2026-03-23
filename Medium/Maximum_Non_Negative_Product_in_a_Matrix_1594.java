package Medium;

public class Maximum_Non_Negative_Product_in_a_Matrix_1594 {
    public int maxProductPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        long[][] maxDp = new long[m][n];
        long[][] minDp = new long[m][n];
        long MOD = 1_000_000_007L;

        maxDp[0][0] = grid[0][0];
        minDp[0][0] = grid[0][0];

        for (int i = 1; i < m; i++) {
            maxDp[i][0] = maxDp[i - 1][0] * grid[i][0];
            minDp[i][0] = minDp[i - 1][0] * grid[i][0];
        }
        for (int j = 1; j < n; j++) {
            maxDp[0][j] = maxDp[0][j - 1] * grid[0][j];
            minDp[0][j] = minDp[0][j - 1] * grid[0][j];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                long a = maxDp[i - 1][j] * grid[i][j];
                long b = minDp[i - 1][j] * grid[i][j];
                long c = maxDp[i][j - 1] * grid[i][j];
                long d = minDp[i][j - 1] * grid[i][j];

                maxDp[i][j] = Math.max(Math.max(a, b), Math.max(c, d));
                minDp[i][j] = Math.min(Math.min(a, b), Math.min(c, d));
            }
        }
        long ans = maxDp[m - 1][n - 1];
        if (ans < 0) return -1;
        return (int)(ans % MOD);
    }
}
