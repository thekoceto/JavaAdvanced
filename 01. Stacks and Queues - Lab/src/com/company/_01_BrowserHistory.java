package com.company;

import java.util.Scanner;
import java.util.Stack;

public class _01_BrowserHistory {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        Stack<String> stack = new Stack<>();

        String input;
        while (!"Home".equals(input = console.nextLine())){
            if ("back".equals(input)) {
                if(stack.size()<=1)
                    System.out.println("no previous URLs");
                else {
                    stack.pop();
                    System.out.println(stack.peek());
                }
            }else{
                stack.push(input);
                System.out.println(input);
            }
        }
    }
}
