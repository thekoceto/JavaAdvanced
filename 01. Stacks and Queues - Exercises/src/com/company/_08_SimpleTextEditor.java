package com.company;

import java.util.ArrayDeque;
import java.util.Scanner;

public class _08_SimpleTextEditor {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int steps = Integer.parseInt(console.nextLine());

        ArrayDeque<String> deque = new ArrayDeque<>();

        StringBuilder text = new StringBuilder();

        while (steps-- > 0){
            String [] input = console.nextLine().split("\\s+");
            if ("1".equals(input[0])){
                deque.push(text.toString());
                text.append(input[1]);
            }
            else if ("2".equals(input[0])) {
                deque.push(text.toString());
                int start = text.length() - Integer.parseInt(input[1]);
                int end = text.length();
                text.delete(start, end);
            }
            else if ("3".equals(input[0])){
                System.out.println(text.charAt(Integer.parseInt(input[1])-1));
            }
            else if ("4".equals(input[0]) && !deque.isEmpty()){
                text.replace(0, text.length(), deque.pop());
            }
        }
    }
}
