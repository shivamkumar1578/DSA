import java.util.Arrays;

public class Check_if_Array_is_Good_2784 {
    public boolean isGood(int[] nums) {
        int n = max(nums);

        if (nums.length != n + 1) {
            return false;
        }

        Arrays.sort(nums);

        for (int i = 0; i < n - 1; i++) {
            if (nums[i] != i + 1) {
                return false;
            }
        }

        return nums[n - 1] == n && nums[n] == n;
    }

    public int max(int[] nums) {
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        return max;
    }
}
