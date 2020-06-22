import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class P02_MakeASalad {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayDeque<String> vegetables = Arrays.stream(reader.readLine().split(" "))
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> calorie = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> ready = new ArrayDeque<>();

        Map<String, Integer> vegetablesToCalorie = new HashMap<String, Integer>(){{
            put("tomato", 80);      put("carrot", 136);
            put("lettuce", 109);    put("potato", 215);
        }};

        while (!vegetables.isEmpty() && !calorie.isEmpty()){
            int rest = calorie.peekLast() - vegetablesToCalorie.get(vegetables.peekFirst());
            if(rest > 0){
            }
        }

    }
}