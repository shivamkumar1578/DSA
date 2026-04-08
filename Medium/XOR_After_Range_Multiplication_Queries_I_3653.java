package Medium;

public class XOR_After_Range_Multiplication_Queries_I_3653 {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        int mod = 1000000007;
        for (int[] q : queries) {
            int l = q[0], r = q[1], k = q[2], v = q[3];
            for (int i = l; i <= r; i += k) {
                nums[i] = (int) ((long) nums[i] * v % mod);
            }
        }
        int xor = 0;
        for (int x : nums)
            xor ^= x;
        return xor;
    }
}
