package com.company.P05_GenericCountMethodString;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine()), count = 0;
        List<Box<String>> boxes = new ArrayList<>();

        for (int i = 0; i < n ; i++) {

            String line = reader.readLine();
            boxes.add(new Box(line));

        }

        String element = reader.readLine();

        int result = countGreaterElements(boxes, new Box<>(element));

        System.out.println(result);


    }

    private static <T extends Comparable<T>> int countGreaterElements(List<Box<T>> boxes, Box<T> element) {
        int counter = 0;

        for (Box<T> box : boxes) {
            if (box.getValue().compareTo(element.getValue()) > 0) {
                counter++;

            }
        }

        return counter;
    }
}
