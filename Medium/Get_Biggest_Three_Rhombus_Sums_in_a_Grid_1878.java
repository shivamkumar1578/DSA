package Medium;

import java.util.TreeSet;

public class Get_Biggest_Three_Rhombus_Sums_in_a_Grid_1878 {
    public int[] getBiggestThree(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        TreeSet<Integer> distinctSums = new TreeSet<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                distinctSums.add(grid[i][j]);
                if (distinctSums.size() > 3) {
                    distinctSums.pollFirst(); 
                }

                int L = 1;
                while (i + 2 * L < m && j - L >= 0 && j + L < n) {
                    int currSum = 0;
                    int r = i, c = j;

                    for (int k = 0; k < L; k++) {
                        currSum += grid[r][c];
                        r++; c++;
                    }
                    for (int k = 0; k < L; k++) {
                        currSum += grid[r][c];
                        r++; c--;
                    }
                    for (int k = 0; k < L; k++) {
                        currSum += grid[r][c];
                        r--; c--;
                    }
                    for (int k = 0; k < L; k++) {
                        currSum += grid[r][c];
                        r--; c++;
                    }

                    distinctSums.add(currSum);
                    if (distinctSums.size() > 3) {
                        distinctSums.pollFirst();
                    }
                    
                    L++;
                }
            }
        }

        int[] result = new int[distinctSums.size()];
        int idx = result.length - 1;
        for (int sum : distinctSums) {
            result[idx--] = sum;
        }

        return result;
    }
}
