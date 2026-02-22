package org.example;

public class Main {
    public static void main(String[] args) {

        LastLapHero hero = new LastLapHero(5, 10);

        // Example 1
        hero.recordLapTiming(1, 0, 70);
        hero.recordLapTiming(2, 0, 69);

        // Continue Example 1
        hero.recordLapTiming(3, 0, 69);

        System.out.println(hero.getTop3FastestLaps());
        // Expected: ["2-0-69", "3-0-69", "1-0-70"]

        System.out.println(hero.getTop3Drivers());
        // Expected: [2, 3, 1]


        // More laps
        hero.recordLapTiming(2, 1, 71);  // car2 avg = 70.0
        hero.recordLapTiming(3, 1, 65);  // car3 avg = 67.0
        hero.recordLapTiming(1, 1, 66);  // car1 avg = 68.0

        System.out.println(hero.getTop3FastestLaps());
        // Expected: ["3-1-65", "1-1-66", "2-0-69"]

        System.out.println(hero.getTop3Drivers());
        // Expected: [3, 1, 2]
    }
}
