package Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Robot_Collisions_2751 {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;

        int[][] robots = new int[n][4];
        for (int i = 0; i < n; i++) {
            robots[i][0] = positions[i];
            robots[i][1] = healths[i];
            robots[i][2] = directions.charAt(i);
            robots[i][3] = i;
        }

        Arrays.sort(robots, (a, b) -> a[0] - b[0]);

        Stack<int[]> stack = new Stack<>();

        for (int[] r : robots) {
            if (r[2] == 'R') {
                stack.push(r);
            } else {
                while (!stack.isEmpty() && stack.peek()[2] == 'R' && r[1] > 0) {
                    int[] top = stack.peek();
                    if (top[1] < r[1]) {
                        stack.pop();
                        r[1]--;
                    } else if (top[1] > r[1]) {
                        top[1]--;
                        r[1] = 0;
                    } else {
                        stack.pop();
                        r[1] = 0;
                    }
                }
                if (r[1] > 0)
                    stack.push(r);
            }
        }

        int[] res = new int[n];
        Arrays.fill(res, -1);

        for (int[] r : stack) {
            res[r[3]] = r[1];
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (res[i] != -1)
                ans.add(res[i]);
        }

        return ans;
    }
}
