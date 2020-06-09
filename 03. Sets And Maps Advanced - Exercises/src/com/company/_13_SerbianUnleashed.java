package com.company;

import java.util.Scanner;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _13_SerbianUnleashed {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        Map<String, LinkedHashMap<String,int[] >> map = new LinkedHashMap<>();
        String regex = "^(?<singer>[^@+]+)@(?<venue>[^ ]+ *[^ ]+) (?<price>\\d+) (?<count>\\d+)$";
        Pattern pattern = Pattern.compile(regex);
        String input;

        while (!"End".equals(input = console.nextLine())){
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()){
                String singer = matcher.group ("singer");
                String venue = matcher.group ("venue");
                int price = Integer.parseInt(matcher.group ("price"));
                int count = Integer.parseInt(matcher.group ("count"));
                map.putIfAbsent(venue, new LinkedHashMap<>());
                map.get(venue).putIfAbsent(singer, new int []{0});
                map.get(venue).get(singer)[0]+=price*count;
            }
        }
        map.forEach((key, value) -> {
            System.out.println(key);
            value
                    .entrySet()
                    .stream()
                    .sorted((s1,s2) -> s2.getValue()[0]-s1.getValue()[0])
                    .forEach(s -> System.out.println("#  " + s.getKey() + "-> " + s.getValue()[0]));//#  Saban Saolic -> 4200000
        });
    }
}