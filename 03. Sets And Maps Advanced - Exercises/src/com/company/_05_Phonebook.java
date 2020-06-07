package com.company;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class _05_Phonebook {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        Map<String, String> map = new LinkedHashMap<>();
        String input;

        while (!"search".equals(input = console.nextLine())){
            String[] token = input.split("-");
            map.put(token[0], token[1]);
        }
        while (!"stop".equals(input = console.nextLine())){
            if (map.containsKey(input))
                System.out.println(input + " -> " + map.get(input));
            else
                System.out.println("Contact " + input + " does not exist.");
        }
    }
}
