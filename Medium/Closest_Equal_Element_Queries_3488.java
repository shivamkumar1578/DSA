package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Closest_Equal_Element_Queries_3488 {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int n = nums.length;
        Map<Integer, Integer> last = new HashMap<>();
        int[] dp = new int[n];
        Arrays.fill(dp, n);

        for (int i = 0; i < 2 * n; i++) {
            int idx = i % n;
            int num = nums[idx];

            if (last.containsKey(num)) {
                int prev = last.get(num);
                int dist = i - prev;

                dp[idx] = Math.min(dp[idx], dist);
                dp[prev % n] = Math.min(dp[prev % n], dist);
            }

            last.put(num, i);
        }

        List<Integer> res = new ArrayList<>();
        for (int q : queries) {
            res.add(dp[q] == n ? -1 : dp[q]);
        }

        return res;
    }
}
