package com.company;

import java.util.Scanner;
import java.util.Stack;

public class _03_DecimalToBinary {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        int number = Integer.parseInt(console.nextLine());
        console.close();

        while (number > 0){
            stack.push(number%2);
            number /= 2;
        }
        if (stack.isEmpty())
            System.out.println(0);
        else
            while (!stack.isEmpty())
                System.out.print(stack.pop());
    }
}
