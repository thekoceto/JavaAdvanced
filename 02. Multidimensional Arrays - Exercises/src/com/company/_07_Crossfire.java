package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class _07_Crossfire {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int [] n = Arrays.stream(console.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        List<List<Integer>> m = new ArrayList<>();
        int index = 0;
        for (int i = 0; i < n[1]; i++) {
            m.add(new ArrayList<>());
            for (int j = 0; j < n[0]; j++)
                m.get(i).add(++index);
        }

        String input;

        while (!"Nuke it from orbit".equals(input = console.nextLine())) {
            int [] c = Arrays.stream(input.split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();

        }
        System.out.println();
    }
}
