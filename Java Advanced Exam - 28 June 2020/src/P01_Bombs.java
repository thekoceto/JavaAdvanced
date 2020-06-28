import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.TreeMap;
import java.util.Map;
import java.util.stream.Collectors;

public class P01_Bombs {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayDeque<Integer> bombEffects = Arrays.stream(reader.readLine().split(",\\s+"))
                .mapToInt(Integer::parseInt).boxed()
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> bombCasings = Arrays.stream(reader.readLine().split(",\\s+"))
                .mapToInt(Integer::parseInt).boxed()
                .collect(Collectors.toCollection(ArrayDeque::new));

        Map<Integer, String> bombs = new TreeMap<>(){{
            put(40, "Datura Bombs");  put(60, "Cherry Bombs");  put(120, "Smoke Decoy Bombs");
        }};
        Map<String, int[]> readyBombs = new TreeMap<>(){{
            put("Datura Bombs", new int[]{0});  put("Cherry Bombs", new int[]{0});  put("Smoke Decoy Bombs", new int[]{0});
        }};

        while (!bombEffects.isEmpty() && !bombCasings.isEmpty() && !isEnoughBombs(readyBombs)){
            if (bombs.get(bombEffects.peekFirst()+bombCasings.peekLast())!=null)
                readyBombs.get(bombEffects.pollFirst()+bombCasings.pollLast())[0]++;
            else
                bombCasings.offerLast(bombCasings.pollLast()-5);


        }
        StringBuilder out = new StringBuilder();
        if (isEnoughBombs(readyBombs)) {
            out.append("Bene! You have successfully filled the bomb pouch!");
        } else {
            out.append("You don't have enough materials to fill the bomb pouch.");
        }
        out.append(System.lineSeparator()).append("Bomb Effects: ");
        if (bombEffects.isEmpty()) {
            out.append("empty");
        } else {
            out.append(bombEffects);
        }
        out.append(System.lineSeparator()).append("Bomb Casings: ");
        if (bombCasings.isEmpty()) {
            out.append("empty");
        } else {
            out.append(bombCasings);
        }
        out.append(System.lineSeparator());
        readyBombs.forEach((k,v) -> out.append(k).append(": ").append(v[0]).append(System.lineSeparator()));

        System.out.println(out.toString().replaceAll("[\\[\\]]", "").trim());
    }

    private static boolean isEnoughBombs(Map<String, int[]> readyBombs) {
        return readyBombs.get("Datura Bombs")[0] >= 3 &&
                readyBombs.get("Cherry Bombs")[0] >= 3 &&
                readyBombs.get("Smoke Decoy Bombs")[0] >= 3;
    }
}
