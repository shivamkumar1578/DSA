package Medium;

public class Rotate_Function_396 {
    public int maxRotateFunction(int[] nums) {
        int s = 0;
        int p = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            s += nums[i];
            p += nums[i] * i;
        }

        int ans = p;
        int c = p;

        for (int i = 1; i < n; i++) {
            c = (c + s) - (n * nums[n - i]);
            ans = Math.max(ans, c);
        }
        return ans;
    }
}
