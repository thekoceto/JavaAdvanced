package com.company.P09_CatLady;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Cat> cats = new HashMap<>();

        String line;
        while (!"End".equals(line = console.readLine())){
            String[] token = line.split("\\s+");
            cats.put(token[1], new Cat(token[1], token[0], Double.parseDouble(token[2])));
        }
        line = console.readLine();
        System.out.println(cats.get(line).toString());

    }
}
