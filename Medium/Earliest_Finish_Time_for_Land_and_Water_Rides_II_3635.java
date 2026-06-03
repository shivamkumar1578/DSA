package Medium;

public class Earliest_Finish_Time_for_Land_and_Water_Rides_II_3635 {
    public int earliestFinishTime(int[] landst, int[] landd, int[] waterst, int[] waterd) {
        int minlandf = Integer.MAX_VALUE;
        int time = Integer.MAX_VALUE;
        int n = landst.length;
        int m = waterst.length;

        for (int i = 0; i < n; i++) {
            minlandf = Math.min(minlandf, landst[i] + landd[i]);
        }
        int minwf = Integer.MAX_VALUE;

        for (int i = 0; i < m; i++) {
            int curr_water_finish_time = Math.max(minlandf, waterst[i]) + waterd[i];
            minwf = Math.min(minwf, curr_water_finish_time);
        }
        time = Math.min(time, minwf);

        minwf = Integer.MAX_VALUE;
        minlandf = Integer.MAX_VALUE;

        for (int i = 0; i < m; i++) {
            minwf = Math.min(minwf, waterst[i] + waterd[i]);
        }

        for (int i = 0; i < n; i++) {
            int curr_land_finish_time = Math.max(minwf, landst[i]) + landd[i];
            minlandf = Math.min(minlandf, curr_land_finish_time);
        }
        time = Math.min(time, minlandf);
        return time;
    }
}
