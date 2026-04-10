import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Minimum_Distance_Between_Three_Equal_Elements_I_3740 {
    public int minimumDistance(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
        int minDist = Integer.MAX_VALUE;
        for (List<Integer> list : map.values()) {
            if (list.size() >= 3) {
                for (int i = 0; i <= list.size() - 3; i++) {
                    int dist = 2 * (list.get(i + 2) - list.get(i));
                    minDist = Math.min(minDist, dist);
                }
            }
        }
        return minDist == Integer.MAX_VALUE ? -1 : minDist;
    }
}
