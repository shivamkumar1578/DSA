package Medium;

public class Minimum_Swaps_to_Arrange_a_Binary_Grid_1536 {
    public int minSwaps(int[][] grid) {
        int n = grid.length;
        int[] tz = new int[n];
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] == 0) count++;
                else break;
            }
            tz[i] = count;
        }
        int swaps = 0;
        for (int i = 0; i < n; i++) {
            int need = n - 1 - i;
            int j = i;
            while (j < n && tz[j] < need) j++;
            if (j == n) return -1;
            while (j > i) {
                int tmp = tz[j];
                tz[j] = tz[j - 1];
                tz[j - 1] = tmp;
                swaps++;
                j--;
            }
        }
        return swaps;
    }
}
