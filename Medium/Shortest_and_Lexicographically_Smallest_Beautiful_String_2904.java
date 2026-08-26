package Medium;

public class Shortest_and_Lexicographically_Smallest_Beautiful_String_2904 {
    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();
        int minLen = Integer.MAX_VALUE;
        String best = "";

        for (int i = 0; i < n; i++) {
            int ones = 0;
            for (int j = i; j < n; j++) {
                if (s.charAt(j) == '1')
                    ones++;

                if (ones == k) {
                    int len = j - i + 1;
                    String sub = s.substring(i, j + 1);

                    if (len < minLen) {
                        minLen = len;
                        best = sub;
                    } else if (len == minLen && sub.compareTo(best) < 0) {
                        best = sub;
                    }
                } else if (ones > k) {
                    break;
                }
            }
        }
        return best;
    }
}
