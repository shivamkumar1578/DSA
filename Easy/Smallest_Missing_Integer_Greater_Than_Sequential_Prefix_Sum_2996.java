import java.util.HashSet;
import java.util.Set;

public class Smallest_Missing_Integer_Greater_Than_Sequential_Prefix_Sum_2996 {
    public int missingInteger(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                sum += nums[i];
            } else {
                break;
            }
        }

        int ans = sum;
        while (set.contains(ans)) {
            ans++;
        }

        return ans;
    }
}
