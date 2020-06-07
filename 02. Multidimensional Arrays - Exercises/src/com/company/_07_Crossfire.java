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

        List<List<String>> m = new ArrayList<>();
        int index = 0;
        for (int i = 0; i < n[0]; i++) {
            m.add(new ArrayList<>());
            for (int j = 0; j < n[1]; j++)
                m.get(i).add("" + ++index);
        }

        String input;

        while (!"Nuke it from orbit".equals(input = console.nextLine())) {
            int [] c = Arrays.stream(input.split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
            int row = c[0], col = c[1], power = c[2];
            for (int i = power; i > 0; i--){
                checkAndRemove(m, row - i, col);
                checkAndRemove(m, row + i, col);
            }
            index = 0;
            for (int i = 0; i < power*2+1; i++)
                if (checkAndRemove(m, row, col - power + i - index))
                    ++index;

            for (int i = 0; i < m.size(); i++) {
                if (m.get(i).isEmpty())
                    m.remove(i--);
            }
        }
        for (List<String> list : m) {
            System.out.println(String.join(" ", list));
        }
    }

    private static boolean checkAndRemove(List<List<String>> m, int row, int index) {
        if (row >=0 && row < m.size())
            if (index >=0 && index <m.get(row).size()) {
                m.get(row).remove(index);
                return true;
            }
        return false;
    }
}
