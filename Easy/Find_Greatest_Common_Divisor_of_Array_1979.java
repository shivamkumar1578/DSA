import java.util.Arrays;

public class Find_Greatest_Common_Divisor_of_Array_1979 {
    public int findGCD(int[] nums) {
        Arrays.sort(nums);
        int min = nums[0];
        int max = nums[nums.length - 1];
        while (min != 0) {
            int rem = max % min;
            max = min;
            min = rem;
        }
        return max;
    }
}
