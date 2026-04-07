package Medium;

public class Walking_Robot_Simulation_II_2069 {
    int width, height;
    int x = 0, y = 0, dir = 0;
    int perimeter;
    int totalSteps = 0;
    String[] dirs = { "East", "North", "West", "South" };

    public Robot(int width, int height) {
        this.width = width;
        this.height = height;
        this.perimeter = 2 * (width + height) - 4;    
    }

    public void step(int num) {
        totalSteps = (totalSteps + num) % perimeter;
        int steps = totalSteps;

        if (steps == 0) {
            x = 0;
            y = 0;
            dir = 3;
            return;
        }

        if (steps < width) {
            x = steps;
            y = 0;
            dir = 0;
        } else if (steps < width + height - 1) {
            x = width - 1;
            y = steps - (width - 1);
            dir = 1;
        } else if (steps < 2 * width + height - 2) {
            x = (width - 1) - (steps - (width + height - 2));
            y = height - 1;
            dir = 2;
        } else {
            x = 0;
            y = (height - 1) - (steps - (2 * width + height - 3));
            dir = 3;
        }
    }

    public int[] getPos() {
        return new int[] { x, y };
    }

    public String getDir() {
        return dirs[dir];
    }
}
