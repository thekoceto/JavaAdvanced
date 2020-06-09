package com.company;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class _12_LegendaryFarming {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        Map<String, Integer> keyMaterials = new TreeMap<>();
        Map<String, Integer> junk = new TreeMap<>();
        keyMaterials.put("shards", 0);     // Shadowmourne
        keyMaterials.put("fragments", 0);  // Valanyr
        keyMaterials.put("motes", 0);      // Dragonwrath

        while (true){
            int quantity = console.nextInt();
            String material = console.next().toLowerCase();
            boolean flag = keyMaterials.containsKey(material);
            boolean isObtained  =  addValueAndCheck (flag ? keyMaterials : junk, material, quantity, flag);

            if (isObtained) {

                switch (material) {
                    case "shards":
                        System.out.println("Shadowmourne obtained!");
                        break;
                    case "fragments":
                        System.out.println("Valanyr obtained!");
                        break;
                    case "motes":
                        System.out.println("Dragonwrath obtained!");
                        break;
                }

                printMap(keyMaterials, false);
                printMap(junk, true);
                break;
            }
        }
    }

    private static boolean addValueAndCheck(Map<String, Integer> map, String material, int quantity, boolean flag) {
        if (map.containsKey(material))
            map.replace(material, map.get(material)+ quantity);
        else
            map.put(material, quantity);
        if (flag && map.get(material) >= 250){
            map.replace(material, map.get(material) - 250);
            return true;
        }
        return false;
    }

    private static void printMap(Map<String, Integer> map, boolean orderedByKey) {
        if (orderedByKey){
            map
                    .forEach((key, value) -> System.out.printf("%s: %d%n", key, value));
        }else{
            map
                    .entrySet()
                    .stream()
                    .sorted((e1, e2) -> e2.getValue() - e1.getValue())
                    .forEach(i -> System.out.printf("%s: %d%n", i.getKey(),i.getValue()));
        }
    }
}
