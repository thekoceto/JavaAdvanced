package P01_DatingApp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.stream.Collectors;

public class P01_DatingApp {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayDeque<Integer> males = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> females = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toCollection(ArrayDeque::new));

        int matches = 0;

        while (!males.isEmpty() && !females.isEmpty()){

            while (males.getLast() <= 0 || males.getLast() %25 == 0) {
                males.pollLast();
                if (males.isEmpty())
                    break;
            }
            while (females.getFirst() <= 0 || females.getFirst() %25 == 0) {
                females.pollFirst();
                if (females.isEmpty())
                    break;
            }
            if (males.isEmpty() || females.isEmpty())
                break;
            if (males.getLast().equals(females.getFirst())){
                matches++;
                females.pollFirst();
                males.pollLast();
            }else{
                females.pollFirst();
                males.addLast(males.pollLast()-2);
            }
        }

        String print = "Matches: " + matches + System.lineSeparator() +
                "Males left: " +
                (males.isEmpty() ? "none" : String.join(", ", "" + males)) +
                System.lineSeparator() +
                "Females left: " +
                (females.isEmpty() ? "none" : String.join(", ", "" + females));
        System.out.println(print.replaceAll("[\\]\\[]", ""));
    }
}
