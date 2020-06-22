package com.company.P06_GenericCountMethodDouble;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        List<Double> doubles = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            double number = Double.parseDouble(reader.readLine());
            doubles.add(number);
        }
        System.out.println(Box.countGreaterValues(doubles, Double.parseDouble(reader.readLine())));
    }
}