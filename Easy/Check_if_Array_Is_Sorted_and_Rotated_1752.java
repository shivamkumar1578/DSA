public class Check_if_Array_Is_Sorted_and_Rotated_1752 {
    public static boolean check(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                count++;
            }
        }
        if (nums[nums.length - 1] > nums[0]) {
            count++;
        }
        return count <= 1;
    }
}
