package com.company;

import java.util.Scanner;
import java.util.Stack;

public class _04_MatchingBrackets {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String input = console.nextLine();
        console.close();

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < input.toCharArray().length; i++) {
            if (input.charAt(i) == '(')
                stack.push(i);
            else if (input.charAt(i) == ')')
                System.out.println(input.substring(stack.pop(), i + 1));
        }
    }
}
