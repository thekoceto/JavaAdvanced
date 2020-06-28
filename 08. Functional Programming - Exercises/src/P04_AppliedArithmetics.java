import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;

public class P04_AppliedArithmetics {
    public static void main(String[] args)  throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] nums = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Function<int[], int[]> add      = num -> Arrays.stream(num).map(e -> e + 1).toArray();
        Function<int[], int[]> multiply = num -> Arrays.stream(num).map(e -> e * 2).toArray();
        Function<int[], int[]> subtract = num -> Arrays.stream(num).map(e -> e - 1).toArray();
        Consumer<int[]> print = num -> Arrays.stream(num).forEach(e -> System.out.print(e + " "));
        String line;
        while (!"end".equals(line = reader.readLine())){

            if (line.equals("add")){
                nums = add.apply(nums);
            } else if (line.equals("multiply")){
                nums = multiply.apply(nums);
            } else if (line.equals("subtract")){
                nums = subtract.apply(nums);
            } else if (line.equals("print")){
                print.accept(nums);
                System.out.println();
            }
        }
    }
}