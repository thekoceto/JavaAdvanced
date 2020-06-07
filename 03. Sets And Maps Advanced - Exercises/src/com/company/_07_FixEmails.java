package com.company;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class _07_FixEmails {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        Map<String, String> map = new LinkedHashMap<>();
        String input;

        while (!"stop".equals(input = console.nextLine())){
            String email = console.nextLine();
            String[] token = email.split("\\.");
            if (!"us".equalsIgnoreCase(token[token.length-1]) &&
                    !"uk".equalsIgnoreCase(token[token.length-1]) &&
                    !"com".equalsIgnoreCase(token[token.length-1]))
            map.put(input, email);
        }
        map.forEach((k,v) -> System.out.println(k + " -> " + v));
    }
}
