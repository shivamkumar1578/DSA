import java.util.ArrayList;
import java.util.List;

public class Separate_the_Digits_in_an_Array_2553 {
    public int[] separateDigits(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        for (int val : nums) {
            List<Integer> cur = new ArrayList<>();
            while (val > 0) {
                cur.add(val % 10);
                val /= 10;
            }
            ans.addAll(cur.reversed());
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}
