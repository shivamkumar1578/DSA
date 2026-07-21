package Medium;

import java.util.Arrays;

public class Destroying_Asteroids_2126 {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long currMass = mass;

        for (int asteroid : asteroids) {
            if (asteroid > currMass) {
                return false;
            }
            currMass += asteroid;
        }
        return true;
    }
}
