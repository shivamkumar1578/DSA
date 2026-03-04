public class Special_Positions_in_a_Binary_Matrix_1582 {
    public int numSpecial(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int[] row = new int[m];
        int[] col = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    row[i]++;
                    col[j]++;
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < m; i++) {
            if (row[i] != 1) continue;
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1 && col[j] == 1) {
                    ans++;
                }
            }
        }

        return ans;
    }
}
