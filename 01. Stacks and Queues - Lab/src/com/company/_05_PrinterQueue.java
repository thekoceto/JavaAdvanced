package com.company;

import java.util.ArrayDeque;
import java.util.Scanner;

public class _05_PrinterQueue {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        ArrayDeque<String> stack = new ArrayDeque<>();

        String input;
        while (!"print".equals(input = console.nextLine())){
            if ("cancel".equals(input)) {
                if(stack.isEmpty())
                    System.out.println("Printer is on standby");
                else
                    System.out.println("Canceled " + stack.pollFirst());
            }else
                stack.offer(input);
        }
        for (String s : stack) {
            System.out.println(s);
        }
    }
}
