package com.company;

import java.util.Scanner;
import java.util.Stack;

public class _08_BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        Stack<String> history = new Stack<>();
        Stack<String> forward  = new Stack<>();

        String input;
        while (!"Home".equals(input = console.nextLine())){
            if ("back".equals(input)) {
                if(history.size()<=1)
                    System.out.println("no previous URLs");
                else {
                    forward.push(history.pop());
                    System.out.println(history.peek());
                }
            }else if ("forward".equals(input)) {
                if(forward.isEmpty())
                    System.out.println("no next URLs");
                else {
                    history.push(forward.pop());
                    System.out.println(history.peek());
                }
            }else{
                history.push(input);
                forward.clear();
                System.out.println(input);
            }
        }
    }
}
