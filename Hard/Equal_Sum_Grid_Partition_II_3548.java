package Hard;

public class Equal_Sum_Grid_Partition_II_3548 {
    public boolean canPartitionGrid(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        long total = 0;

        for (int[] row : grid) {
            for (int val : row) {
                total += val;
            }
        }

        if (checkHorizontal(grid, m, n, total)) return true;
        if (checkVertical(grid, m, n, total)) return true;

        return false;
    }

    private boolean checkHorizontal(int[][] grid, int m, int n, long total) {
        int[] topFreq = new int[100001];
        int[] bottomFreq = new int[100001];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                bottomFreq[grid[i][j]]++;
            }
        }

        long topSum = 0;

        for (int cut = 0; cut < m - 1; cut++) {
            for (int j = 0; j < n; j++) {
                int val = grid[cut][j];
                topFreq[val]++;
                bottomFreq[val]--;
                topSum += val;
            }

            long bottomSum = total - topSum;

            if (topSum == bottomSum) return true;

            if (topSum > bottomSum) {
                long diff = topSum - bottomSum;
                if (diff <= 100000 && canRemoveTopHorizontal(grid, cut, n, (int) diff, topFreq)) {
                    return true;
                }
            } else {
                long diff = bottomSum - topSum;
                if (diff <= 100000 && canRemoveBottomHorizontal(grid, cut + 1, m, n, (int) diff, bottomFreq)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean checkVertical(int[][] grid, int m, int n, long total) {
        int[] leftFreq = new int[100001];
        int[] rightFreq = new int[100001];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rightFreq[grid[i][j]]++;
            }
        }

        long leftSum = 0;

        for (int cut = 0; cut < n - 1; cut++) {
            for (int i = 0; i < m; i++) {
                int val = grid[i][cut];
                leftFreq[val]++;
                rightFreq[val]--;
                leftSum += val;
            }

            long rightSum = total - leftSum;

            if (leftSum == rightSum) return true;

            if (leftSum > rightSum) {
                long diff = leftSum - rightSum;
                if (diff <= 100000 && canRemoveLeftVertical(grid, m, cut, (int) diff, leftFreq)) {
                    return true;
                }
            } else {
                long diff = rightSum - leftSum;
                if (diff <= 100000 && canRemoveRightVertical(grid, m, n, cut + 1, (int) diff, rightFreq)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean canRemoveTopHorizontal(int[][] grid, int bottomRow, int n, int diff, int[] freq) {
        int h = bottomRow + 1;
        int w = n;

        if (h == 1 && w == 1) return false;

        if (h == 1) {
            return grid[0][0] == diff || grid[0][w - 1] == diff;
        }

        if (w == 1) {
            return grid[0][0] == diff || grid[h - 1][0] == diff;
        }

        return freq[diff] > 0;
    }

    private boolean canRemoveBottomHorizontal(int[][] grid, int topRow, int m, int n, int diff, int[] freq) {
        int h = m - topRow;
        int w = n;

        if (h == 1 && w == 1) return false;

        if (h == 1) {
            return grid[topRow][0] == diff || grid[topRow][w - 1] == diff;
        }

        if (w == 1) {
            return grid[topRow][0] == diff || grid[m - 1][0] == diff;
        }

        return freq[diff] > 0;
    }

    private boolean canRemoveLeftVertical(int[][] grid, int m, int rightCol, int diff, int[] freq) {
        int h = m;
        int w = rightCol + 1;

        if (h == 1 && w == 1) return false;

        if (h == 1) {
            return grid[0][0] == diff || grid[0][w - 1] == diff;
        }

        if (w == 1) {
            return grid[0][0] == diff || grid[h - 1][0] == diff;
        }

        return freq[diff] > 0;
    }

    private boolean canRemoveRightVertical(int[][] grid, int m, int n, int leftCol, int diff, int[] freq) {
        int h = m;
        int w = n - leftCol;

        if (h == 1 && w == 1) return false;

        if (h == 1) {
            return grid[0][leftCol] == diff || grid[0][n - 1] == diff;
        }

        if (w == 1) {
            return grid[0][leftCol] == diff || grid[m - 1][leftCol] == diff;
        }

        return freq[diff] > 0;
    }
}
