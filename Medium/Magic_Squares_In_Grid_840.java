package Medium;

public class Magic_Squares_In_Grid_840 {
    public int numMagicSquaresInside(int[][] grid) {
        int r = grid.length, c = grid[0].length;
        int ans = 0;
        for (int i = 0; i + 2 < r; i++) {
            for (int j = 0; j + 2 < c; j++) {
                if (isMagic(grid, i, j)) ans++;
            }
        }
        return ans;
    }
    private boolean isMagic(int[][] g, int x, int y) {
        if (g[x + 1][y + 1] != 5) return false;
        boolean[] seen = new boolean[10];
        for (int i = x; i < x + 3; i++) {
            for (int j = y; j < y + 3; j++) {
                int v = g[i][j];
                if (v < 1 || v > 9 || seen[v]) return false;
                seen[v] = true;
            }
        }

        int s = g[x][y] + g[x][y + 1] + g[x][y + 2];

        if (g[x + 1][y] + g[x + 1][y + 1] + g[x + 1][y + 2] != s) return false;
        if (g[x + 2][y] + g[x + 2][y + 1] + g[x + 2][y + 2] != s) return false;

        if (g[x][y] + g[x + 1][y] + g[x + 2][y] != s) return false;
        if (g[x][y + 1] + g[x + 1][y + 1] + g[x + 2][y + 1] != s) return false;
        if (g[x][y + 2] + g[x + 1][y + 2] + g[x + 2][y + 2] != s) return false;

        if (g[x][y] + g[x + 1][y + 1] + g[x + 2][y + 2] != s) return false;
        if (g[x][y + 2] + g[x + 1][y + 1] + g[x + 2][y] != s) return false;

        return true;
    }
}
