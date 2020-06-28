import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class P08_CustomComparator {
    public static void main(String[] args)  throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        List<Integer> numbers = Arrays.stream(reader.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Comparator<Integer> integerComparator = (a, b) -> {
            boolean firstIsEven = a % 2 == 0;
            boolean secondIsEven = b % 2 == 0;
            if (firstIsEven && !secondIsEven){
                return -1;
            } else if (!firstIsEven && secondIsEven){
                return 1;
            }else {
                return a - b;
            }
        };

        numbers.sort(integerComparator);
        numbers.forEach(x -> System.out.printf("%d ", x));
    }
}