package P01_Lootbox;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayDeque<Integer> first = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> second = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toCollection(ArrayDeque::new));

        int loot = 0;
        while (!first.isEmpty() && !second.isEmpty()){
            if ((first.peekFirst()+second.peekLast())%2==0)
                loot += first.pollFirst()+second.pollLast();
            else
                first.addLast(second.pollLast());
        }
        if (first.isEmpty()) System.out.println("First lootbox is empty");
        if (second.isEmpty()) System.out.println("Second lootbox is empty");
        System.out.println((loot>100? "Your loot was epic! Value: " : "Your loot was poor... Value: " ) + loot);
    }
}