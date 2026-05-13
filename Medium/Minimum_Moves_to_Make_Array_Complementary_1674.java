package Medium;

public class Minimum_Moves_to_Make_Array_Complementary_1674 {
    public int minMoves(int[] nums, int limit) {
        int n = nums.length;
        int[] diff = new int[2 * limit + 2];
        for (int i = 0; i < n / 2; i++) {
            int a = nums[i];
            int b = nums[n - 1 - i];

            int lo = Math.min(a, b);
            int hi = Math.max(a, b);

            diff[2] += 2;
            diff[2 * limit + 1] -= 2;

            diff[lo + 1]--;
            diff[hi + limit + 1]++;

            diff[a + b]--;
            diff[a + b + 1]++;
        }
        int curr = 0;
        int ans = Integer.MAX_VALUE;

        for (int target = 2; target <= 2 * limit; target++) {
            curr += diff[target];
            ans = Math.min(ans, curr);
        }
        return ans;
    }
}
