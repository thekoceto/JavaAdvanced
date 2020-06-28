import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Function;

public class P04_AppliedArithmetics {
    public static void main(String[] args)  throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] nums = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Function<int[], int[]> add = num -> {
            for (int i = 0; i < nums.length; i++) {
                nums[i] += 1;
            }
            return num;
        };
        Function<int[], int[]> multiply = num -> {
            for (int i = 0; i < nums.length; i++) {
                nums[i] *= 2;
            }
            return num;
        };
        Function<int[], int[]> subtract = num -> {
            for (int i = 0; i < nums.length; i++) {
                nums[i] -= 1;
            }
            return num;
        };

        String line;
        while (!"end".equals(line = reader.readLine())){

            if (line.equals("add")){
                add.apply(nums);
            } else if (line.equals("multiply")){
                multiply.apply(nums);
            } else if (line.equals("subtract")){
                subtract.apply(nums);
            } else if (line.equals("print")){
                for (int i = 0; i < nums.length; i++) {
                    System.out.print(nums[i] + " ");
                }
            }
        }
    }
}