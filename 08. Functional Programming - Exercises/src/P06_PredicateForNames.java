import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P06_PredicateForNames {
    public static void main(String[] args)  throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Integer nameLength = Integer.parseInt(reader.readLine());
        List<String> names = Arrays.stream(reader.readLine().split(" ")).collect(Collectors.toList());

        Predicate<String> namesPredicate = name -> name.length() <= nameLength;
        Function<String, Boolean> filterNames = name -> namesPredicate.test(name);
        names.stream().filter(filterNames::apply).forEach(System.out::println);
    }
}
