public class Mirror_Distance_of_an_Integer_3783 {
    static public int mirrorDistance(int n) {
        int rev = 0;
        for (int x = n; x > 0; x /= 10) {
            rev = 10 * rev + x % 10;
        }
        return Math.abs(rev - n);
    }
}
