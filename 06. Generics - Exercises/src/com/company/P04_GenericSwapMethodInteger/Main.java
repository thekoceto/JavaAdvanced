package com.company.P04_GenericSwapMethodInteger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        Box[] boxes = new Box[n];
        for (int i = 0; i < n; i++)
            boxes[i] = new Box<>(Integer.parseInt(reader.readLine()));

        int[] token = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        swapElement(boxes, token[0], token[1]);
        for (Box box : boxes)
            System.out.println(box);
    }

    private static<E> void swapElement (Box[] boxes, int index1, int index2) {
        Box<E> temp = boxes[index1];
        boxes[index1] = boxes[index2];
        boxes[index2] = temp;
    }
}