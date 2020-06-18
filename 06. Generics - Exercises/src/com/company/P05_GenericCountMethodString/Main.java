package com.company.P05_GenericCountMethodString;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine()), count = 0;
        Box[] boxes = new Box[n];
        for (int i = 0; i < n; i++)
            boxes[i] = new Box<>(reader.readLine());

        Box compare = new Box<>(reader.readLine());
        for (Box box : boxes) {
            if (box.compareTo(compare)>0)
                count++;
        }
        System.out.println(count);
    }
}
