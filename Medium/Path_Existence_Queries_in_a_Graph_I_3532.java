package Medium;

public class Path_Existence_Queries_in_a_Graph_I_3532 {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        boolean[] res = new boolean[queries.length];
        int color = 0, idx = 0;
        int[] colorArrays = new int[n];
        for (int i = 1; i < n; i++) {
            colorArrays[i] = nums[i] - nums[i - 1] <= maxDiff ? color : ++color;
        }
        for (int[] q : queries) {
            res[idx++] = colorArrays[q[0]] == colorArrays[q[1]];
        }
        return res;
    }
}
