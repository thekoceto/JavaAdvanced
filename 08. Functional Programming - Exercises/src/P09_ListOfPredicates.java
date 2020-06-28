import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

public class P09_ListOfPredicates {
    public static void main(String[] args)  throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int endOfSequence = Integer.parseInt(reader.readLine());
        List<Integer> divisionNumbers = Arrays.stream(reader.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> result = new LinkedList<>();
        BiPredicate<Integer, Integer> isDivisible = (x, y) -> x % y == 0;

        for (int i = 1; i <= endOfSequence; i++) {
            int count = 0;
            for (Integer num: divisionNumbers) {
                if (isDivisible.test(i, num))
                    count++;
            }

            if (count == divisionNumbers.size())
                result.add(i);
        }

        result.forEach(x -> System.out.printf("%d ", x));
    }
}