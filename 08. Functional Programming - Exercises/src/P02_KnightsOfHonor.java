import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class P02_KnightsOfHonor {
    public static void main(String[] args)  throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> input = Arrays.asList(reader.readLine().split(" "));

        Consumer<String> consumer = name -> System.out.println("Sir " + name);

        input.forEach(consumer);
    }
}
