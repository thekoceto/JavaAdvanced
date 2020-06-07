package com.company;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class _01_UniqueUsernames {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int n = Integer.parseInt(console.nextLine());
        Set<String> set = new LinkedHashSet<>();

        while (n-- > 0)
            set.add(console.nextLine());

        set.forEach(System.out::println);
    }
}
