import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P05_ReverseAndExclude {
    public static void main(String[] args)  throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> nums = Arrays.stream(reader.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        int division = Integer.parseInt(reader.readLine());

        Predicate<Integer> isDivisible = num -> num % division != 0;

        Function<Integer, Boolean> filterNums = isDivisible::test;

        Collections.reverse(nums);
        nums.stream().filter(filterNums::apply).forEach(z -> System.out.printf("%d ", z));
    }
}
