package Medium;

public class Minimum_Number_of_Seconds_to_Make_Mountain_Height_Zero_3296 {
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        long low = 1;
        long high = 1L * getMin(workerTimes) * mountainHeight * (mountainHeight +1) / 2;
        long ans = high;

        while (low <= high) {
            long mid = low + (high - low) / 2;
            if (canReduce(mid, mountainHeight, workerTimes)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    private boolean canReduce(long time, int mountainHeight, int[] workerTimes) {
        long total = 0;

        for (int wt : workerTimes) {
            long left = 0, right = mountainHeight;
            long best = 0;

            while (left <= right) {
                long mid = left + (right - left) / 2;
                long need = 1L * wt * mid * (mid + 1) / 2;

                if (need <= time) {
                    best = mid;
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            total += best;
            if (total >= mountainHeight) return true;
        }

        return false;
    }

    private int getMin(int[] arr) {
        int min = arr[0];
        for (int x : arr) {
            min = Math.min(min, x);
        }
        return min;
    }
}
