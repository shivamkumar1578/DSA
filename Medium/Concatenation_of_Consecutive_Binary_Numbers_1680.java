package Medium;

public class Concatenation_of_Consecutive_Binary_Numbers_1680 {
    public int concatenatedBinary(int n) {
        long mod = 1_000_000_007L;
        long ans = 0;
        int len = 0;

        for (int i = 1; i <= n; i++) {
            if ((i & (i - 1)) == 0) len++;
            ans = ((ans << len) + i) % mod;
        }

        return (int) ans;
    }
}
