import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P07_FindTheSmallestElement {
    public static void main(String[] args)  throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> nums = Arrays.stream(reader.readLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        Function<List<Integer>, Integer> minElement = num -> {
            Integer thisElement = Integer.MAX_VALUE;
            int thisElementPosition = 0;
            for (int i = 0; i < nums.size(); i++) {
                if (nums.get(i) <= thisElement){
                    thisElement = nums.get(i);
                    thisElementPosition = i;
                }
            }

            return thisElementPosition;
        };

        System.out.println(minElement.apply(nums));
    }
}