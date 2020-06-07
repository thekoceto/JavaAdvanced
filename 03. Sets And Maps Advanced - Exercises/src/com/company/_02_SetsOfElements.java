package com.company;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class _02_SetsOfElements {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        Set<String> first = new LinkedHashSet<>();
        Set<String> second = new LinkedHashSet<>();
        int[] n = Arrays.stream(console.nextLine().split("\\s+"))
                .limit(2).mapToInt(Integer::parseInt).toArray();

        while (n[0]-- > 0)
            first.add(console.nextLine());

        while (n[1]-- > 0)
            second.add(console.nextLine());

        first.retainAll(second);
        System.out.println(String.join(" ", first));
    }
}
