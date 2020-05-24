package com.company;

import java.util.ArrayDeque;
import java.util.Scanner;

public class _09_InfixToPostfix {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        ArrayDeque<String> number = new ArrayDeque<>();
        ArrayDeque<String> operator = new ArrayDeque<>();

        String[] tokens = console.nextLine().split("\\s+");

        for (String ch : tokens) {
            if (!"-+/*()".contains(ch))
                number.offer(ch);
            else if ("(".equals(ch))
                operator.push(ch);
            else if (ch.equals(")")) {
                while (!"(".equals(operator.peek()))
                    number.offer(operator.pop());
                operator.pop();
            } else {
                if ("-+".contains(ch)) {
                    while (!operator.isEmpty() && !operator.peek().equals("("))
                        number.offer(operator.pop());
                } else {
                    while (!operator.isEmpty() && !"+-(".contains(operator.peek()))
                        number.offer(operator.pop());
                }
                operator.push(ch);
            }
        }
        while (!operator.isEmpty()) {
            number.offer(operator.pop());
        }
        System.out.println(String.join(" ", number));
    }
}
