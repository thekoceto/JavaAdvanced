package com.company;

import java.util.ArrayDeque;
import java.util.Scanner;

public class _06_BalancedParentheses {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        ArrayDeque<Character> deque = new ArrayDeque<>();
        String input = console.nextLine();
        boolean flag = true;

        for (char ch : input.toCharArray()) {
            if (ch == '(')
                deque.push(')');
            else if (ch == '{')
                deque.push('}');
            else if (ch == '[')
                deque.push(']');
            else{
                if (deque.isEmpty() || ch != deque.pop()){
                    flag = false;
                    break;
                }
            }
        }
        System.out.println(flag ? "YES" : "NO");
    }
}
