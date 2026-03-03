public class Find_Kth_Bit_in_Nth_Binary_String_1545 {
    public char findKthBit(int n, int k) {
        boolean invert = false;

        while (n > 1) {
            int len = (1 << n) - 1;
            int mid = 1 << (n - 1);

            if (k == mid) {
                return invert ? '0' : '1';
            }

            if (k > mid) {
                k = len - k + 1;
                invert = !invert;
            }

            n--;
        }

        return invert ? '1' : '0';
    }
}
