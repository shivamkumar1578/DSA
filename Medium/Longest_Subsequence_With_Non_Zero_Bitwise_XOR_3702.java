package Medium;

import java.util.Arrays;

public class Longest_Subsequence_With_Non_Zero_Bitwise_XOR_3702 {
    public int longestSubsequence(int[] nums) {
        int n = nums.length;

        int zeros[] = new int[n];

        if (Arrays.equals(nums, zeros)) {
            return 0;
        }

        int x = 0;

        for (int num : nums) {
            x ^= num;
        }

        return x != 0 ? n : n - 1;
    }
}
