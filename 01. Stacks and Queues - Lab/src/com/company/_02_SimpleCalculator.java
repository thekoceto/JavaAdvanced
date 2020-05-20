package com.company;

import java.util.Scanner;
import java.util.Stack;

public class _02_SimpleCalculator {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        Stack<String> stack = new Stack<>();
        String[] input = console.nextLine().split("\\s+");

        for (int i = input.length - 1; i >= 0; i--)
            stack.push(input[i]);

        while (stack.size()>1){
            int left = Integer.parseInt(stack.pop());
            String operator = stack.pop();
            int right = Integer.parseInt(stack.pop());
            stack.push(Integer.toString(operator.equals("+") ? left + right : left - right));
        }
        System.out.println(stack.peek());
    }
}
