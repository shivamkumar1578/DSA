package Medium;

public class Equal_Sum_Grid_Partition_I_3546 {
    public boolean canPartitionGrid(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        long total = 0;
        long[] rowSum = new long[m];
        long[] colSum = new long[n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                rowSum[i] += grid[i][j];
                colSum[j] += grid[i][j];
                total += grid[i][j];
            }
        }

        long sum = 0;
        for(int i = 0; i < m - 1; i++){
            sum += rowSum[i];
            if(sum * 2 == total) return true;
        }

        sum = 0;
        for(int j = 0; j < n - 1; j++){
            sum += colSum[j];
            if(sum * 2 == total) return true;
        }
        return false;
    }
}
