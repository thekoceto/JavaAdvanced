package com.company;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class _05_Robotics_1 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        Robot [] robots = Arrays.stream(console.nextLine().split(";"))
                .map(v -> new Robot(v.split("-")))
                .toArray(Robot[]::new);

        int[] inputTime = Arrays.stream(console.nextLine().split(":"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int time = inputTime[0] * 3600 + inputTime[1] * 60 + inputTime[2];

        ArrayDeque<String> products = new ArrayDeque<>();

        String input;

        while (!"End".equals(input = console.nextLine()))
            products.offer(input);

        while (!products.isEmpty()) {

            for (Robot robot : robots)
                robot.decreaseWorkingTime();

            time++;

            String currentItem = products.poll();
            boolean isTaken = false;
            for (Robot robot : robots) {
                if (robot.workTime == 0) {
                    System.out.printf("%s - %s [%s]%n",robot.robotName,currentItem,getTime(time));
                    robot.setWorkTime();
                    isTaken = true;
                    break;
                }
            }

            if (!isTaken) {
                products.offer(currentItem);
            }
        }
    }

    private static String getTime(int time) {
        int hours = time / 3600 % 24;
        int mins = time / 60 % 60;
        int seconds = time % 60;

        return String.format("%02d:%02d:%02d",hours,mins,seconds);
    }
    static class Robot {
        private String robotName;
        private int processTime;
        private int workTime;

        Robot (String[] input){
            this.robotName = input[0];
            this.processTime = Integer.parseInt(input[1]);
            this.workTime = 0;
        }

        void decreaseWorkingTime() {
            if (--this.workTime < 0)
                this.workTime = 0;
        }
        void setWorkTime() {
            this.workTime = this.processTime;
        }
    }

}