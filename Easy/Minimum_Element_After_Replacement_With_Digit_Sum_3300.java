public class Minimum_Element_After_Replacement_With_Digit_Sum_3300 {
    public int minElement(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int ds = digitSum(nums[i]);
            if (ds < min) {
                min = ds;
            }
        }
        return min;
    }

    public int digitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num = num / 10;
        }
        return sum;
    }
}
