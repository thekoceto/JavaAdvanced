package com.company;

import java.util.Scanner;

public class Main {

    private static int fib(int n)
    {
        if (n <= 1)
            return n;
        return fib(n-1) + fib(n-2);
    }
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        System.out.println(fib(n+1));

    }
}
