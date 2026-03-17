package Medium;

import java.util.Arrays;

public class Largest_Submatrix_With_Rearrangements_1727 {
    public int largestSubmatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] height = new int[n];
        int maxArea = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) height[j] = 0;
                else height[j]++;
            }

            int[] sorted = height.clone();
            Arrays.sort(sorted);

            for (int j = n - 1; j >= 0; j--) {
                int h = sorted[j];
                int width = n - j;
                maxArea = Math.max(maxArea, h * width);
            }
        }
        return maxArea;
    }
}
