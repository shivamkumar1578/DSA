package Medium;

public class Minimum_Operations_to_Make_a_UniValue_Grid_2033 {
    public int minOperations(int[][] grid, int x) {
        int n = grid.length, m = grid[0].length;
        if (n == 1 && m == 1)
            return 0;

        int k = 0;
        int r = grid[0][0] % x;
        int[] arr = new int[n * m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] % x != r)
                    return -1;
                arr[k++] = grid[i][j];
            }
        }

        Arrays.sort(arr);

        int c1 = 0, c2 = 0;

        for (int i = 0; i < k; i++) {
            c1 += Math.abs(arr[k / 2] - arr[i]) / x;
            c2 += Math.abs(arr[(k / 2) - 1] - arr[i]) / x;
        }

        return Math.min(c1, c2);
    }
}
