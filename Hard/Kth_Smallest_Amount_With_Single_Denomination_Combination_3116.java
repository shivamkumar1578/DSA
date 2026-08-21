package Hard;

public class Kth_Smallest_Amount_With_Single_Denomination_Combination_3116 {
    public long findKthSmallest(int[] coins, int k) {

        long left = 1;
        long right = (long) getMin(coins) * k;

        while (left < right) {

            long mid = left + (right - left) / 2;

            if (count(mid, coins) >= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private long count(long x, int[] coins) {

        int n = coins.length;
        long total = 0;

        for (int mask = 1; mask < (1 << n); mask++) {

            long lcm = 1;
            int bits = 0;

            for (int i = 0; i < n; i++) {

                if ((mask & (1 << i)) != 0) {

                    bits++;

                    long gcd = findGCD(lcm, coins[i]);

                    lcm = (lcm / gcd) * coins[i];

                    if (lcm > x) {
                        break;
                    }
                }
            }

            if (lcm > x) {
                continue;
            }

            long multiples = x / lcm;

            if (bits % 2 == 1) {
                total += multiples;
            } else {
                total -= multiples;
            }
        }

        return total;
    }

    private long findGCD(long a, long b) {

        while (b != 0) {

            long temp = a % b;
            a = b;
            b = temp;
        }

        return a;
    }

    private int getMin(int[] coins) {

        int min = coins[0];

        for (int coin : coins) {
            min = Math.min(min, coin);
        }

        return min;
    }
}
