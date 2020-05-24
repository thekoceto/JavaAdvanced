package com.company;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class _05_Robotics {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        Robot [] robots = Arrays.stream(console.nextLine().split(";"))
                .map(v -> new Robot(v.split("-")))
                .toArray(Robot[]::new);

//        ArrayDeque<Robot> robots = Arrays.stream(console.nextLine().split(";"))
//                .map(v -> new Robot(v.split("-")))
//                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<String> product = new ArrayDeque<>();

        int [] time = Arrays.stream(console.nextLine().split(":"))
                .mapToInt(Integer::parseInt).toArray();

        long seconds = time[0] * 3600 + time[1] * 60 + time[2];
        String input;

        while (!"End".equals(input = console.nextLine()))
            product.offer(input);

        while (!product.isEmpty()){
            seconds++;
            boolean flag = true;
            for (Robot robot : robots)
                robot.decreaseWorkingTime();

            for (Robot robot : robots){
                if (robot.getWorkTime()==0){
                    System.out.print(robot.getRobotName() + " - " + product.poll() + " ");
                    printTime(seconds);
                    robot.setWorkTime();
                    flag = false;
                    break;
                }
            }
            if (flag)
                product.offer(product.poll());
        }
    }

    private static void printTime(long seconds) {
        long s = seconds % 60;
        long m = (seconds / 60) % 60;
        long h = (seconds / 3600) % 24;

        System.out.print( String.format("%02d:%02d:%02d", h, m, s));

//        System.out.print("[");
//        if (h < 10) System.out.print("0");
//        System.out.print(h);
//        System.out.print(":");
//        if (m < 10) System.out.print("0");
//        System.out.print(m);
//        System.out.print(":");
//        if (s < 10) System.out.print("0");
//        System.out.print(s);
//        System.out.println("]");
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

        String getRobotName() {
            return robotName;
        }

        int getWorkTime() {
            return workTime;
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
