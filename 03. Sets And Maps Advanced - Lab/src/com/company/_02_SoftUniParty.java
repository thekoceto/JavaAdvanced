package com.company;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class _02_SoftUniParty {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        Set<String> vip = new TreeSet<>();
        Set<String> regular = new TreeSet<>();
        String input;

        while (!"PARTY".equals(input = console.nextLine())){
            if (Character.isDigit(input.charAt(0)))
                vip.add(input);
            else
                regular.add(input);
        }
        while (!"END".equals(input = console.nextLine())){
            vip.remove(input);
            regular.remove(input);
        }
        System.out.println(vip.size() + regular.size());
        vip.forEach(System.out::println);
        regular.forEach(System.out::println);
    }
}
