package com.company;

import java.util.ArrayDeque;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        String text = "";
        ArrayDeque<String> commands = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            String[] command = scan.nextLine().split("\\s+");
            switch (command[0]) {
                case "1":
                    commands.push(text);
                    text += command[1];
                    break;

                case "2":
                    commands.push(text);
                    text = text.substring(0, text.length() - Integer.parseInt(command[1]));
                    break;

                case "3":
                    System.out.println(text.charAt(Integer.parseInt(command[1]) - 1));
                    break;

                case "4":
                    if(!commands.isEmpty()){
                        text=commands.pop();
                    }
                    break;
            }
        }
    }
}