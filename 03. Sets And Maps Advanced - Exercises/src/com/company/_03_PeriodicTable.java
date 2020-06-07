package com.company;

import java.util.Arrays;
import java.util.TreeSet;
import java.util.Scanner;
import java.util.Set;

public class _03_PeriodicTable {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int n = Integer.parseInt(console.nextLine());
        Set<String> set = new TreeSet<>();

        while (n-- > 0)
            set.addAll(Arrays.asList(console.nextLine().split("\\s+")));

        System.out.println(String.join(" ", set));
    }
}
