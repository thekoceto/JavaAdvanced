package com.company;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.LinkedHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _09_UserLogs {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        Map<String, LinkedHashMap<String,int[] >> map = new TreeMap<>();
        String regex = "^IP=(?<IP>[^ ]+) message=(?<message>[^ ]+) user=(?<user>[^ ]+)$";
        Pattern pattern = Pattern.compile(regex);
        String input;

        while (!"end".equals(input = console.nextLine())){
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()){
                String user = matcher.group ("user");
                String IP = matcher.group ("IP");
                map.putIfAbsent(user, new LinkedHashMap<>());
                map.get(user).putIfAbsent(IP, new int []{0});
                map.get(user).get(IP)[0]++;
            }
        }
        int [] count = new int []{0};
        map.forEach((k1,v1) -> {
            count[0]=0;
            System.out.println(k1 + ": ");
            v1.forEach((k2,v2) -> {
                System.out.print(k2 + " => " + v2[0]);
                System.out.print(++count[0] < v1.size() ? ", " : ".\n");
            });
        });
    }
}