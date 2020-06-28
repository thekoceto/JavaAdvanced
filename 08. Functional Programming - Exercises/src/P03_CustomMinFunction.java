import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Function;

public class P03_CustomMinFunction {
    public static void main(String[] args)  throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] nums = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Function<int[], Integer> minNum = num -> {
            int minNumber = Integer.MAX_VALUE;
            for (int number: nums) {
                if (number < minNumber){
                    minNumber = number;
                }
            }
            return minNumber;
        };

        System.out.println(minNum.apply(nums));
    }
}
