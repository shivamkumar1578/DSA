package Hard;

public class Minimum_Operations_to_Equalize_Binary_String_3666 {
    public int minOperations(String s, int k) {
        int n = s.length();
        int z = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') z++;
        }
        if (z == 0) return 0;
        int start = (z + k - 1) / k;
        for (int t = start; t <= 2 * n + 2; t++) {
            long total = (long) t * k;
            if ( (total & 1L) != (z & 1) ) continue;
            long smax = (t % 2 == 0) ? (long) t * n - z : (long) t * n - (n - z);
            if (total >= z && total <= smax) return t;
        }
        return -1;
    }
}
