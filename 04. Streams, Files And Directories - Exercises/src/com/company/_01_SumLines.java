package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class _01_SumLines {
    public static void main(String[] args) {
        try {
            List <String> lines = Files.readAllLines(Paths.get("src/resources/input.txt"));
            for (String line : lines) {
                int sum = 0;
                for (char ch : line.toCharArray())
                    sum += ch;
                System.out.println(sum);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
