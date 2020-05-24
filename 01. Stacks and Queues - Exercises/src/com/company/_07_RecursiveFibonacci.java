package com.company;

import java.util.Scanner;

public class _07_RecursiveFibonacci {

    private static long [] memoization;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        memoization = new long[n + 1];

        System.out.println(fibonacci(n));
    }



    private static long fibonacci(int n) {
        if (n <= 2)
            return n;

        if (memoization[n] != 0)
            return memoization[n];

        return memoization[n] =  fibonacci(n-1) + fibonacci(n - 2);
    }
}