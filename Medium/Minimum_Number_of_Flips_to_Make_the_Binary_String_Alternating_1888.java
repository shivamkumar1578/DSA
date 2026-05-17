package Medium;

public class Minimum_Number_of_Flips_to_Make_the_Binary_String_Alternating_1888 {
    class Solution {
    public int minFlips(String s) {
        int n = s.length();
        String str = s + s;

        int diff1 = 0;
        int diff2 = 0;
        int ans = Integer.MAX_VALUE;
        int left = 0;

        for (int right = 0; right < str.length(); right++) {
            char ch = str.charAt(right);

            if (ch != ((right % 2 == 0) ? '0' : '1')) diff1++;
            if (ch != ((right % 2 == 0) ? '1' : '0')) diff2++;

            if (right - left + 1 > n) {
                char leftChar = str.charAt(left);

                if (leftChar != ((left % 2 == 0) ? '0' : '1')) diff1--;
                if (leftChar != ((left % 2 == 0) ? '1' : '0')) diff2--;

                left++;
            }

            if (right - left + 1 == n) {
                ans = Math.min(ans, Math.min(diff1, diff2));
            }
        }

        return ans;
    }
}
}
