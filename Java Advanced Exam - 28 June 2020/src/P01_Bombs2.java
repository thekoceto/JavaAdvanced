import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.stream.Collectors;

public class P01_Bombs2 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayDeque<Integer> effects = Arrays.stream(reader.readLine().split(",\\s+"))
                .mapToInt(Integer::parseInt).boxed()
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> casings = Arrays.stream(reader.readLine().split(",\\s+"))
                .mapToInt(Integer::parseInt).boxed()
                .collect(Collectors.toCollection(ArrayDeque::new));

        int[] bombs = new int[]{0,0,0}; //Datura Bombs, Cherry Bombs, Smoke Decoy Bombs

        while (!effects.isEmpty() && !casings.isEmpty()){
            if (bombs[0] >= 3 && bombs[1] >= 3 && bombs[2] >= 3)
                break;
            int currentBombEffects = effects.removeFirst();
            int currentBombCasings = casings.removeLast();
            switch (currentBombEffects + currentBombCasings){
                case 40:  bombs[0]++; break;
                case 60:  bombs[1]++; break;
                case 120: bombs[2]++; break;
                default:
                    effects.addFirst(currentBombEffects);
                    casings.addLast(currentBombCasings-5);
                    break;
            }

        }
        if (bombs[0] >= 3 && bombs[1] >= 3 && bombs[2] >= 3) {
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        } else {
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }

        System.out.print("Bomb Effects: ");
        if (effects.isEmpty()) {
            System.out.println("empty");
        } else {
            System.out.println(effects.toString().replaceAll("[\\[\\]]", ""));
        }

        System.out.print("Bomb Casings: ");
        if (casings.isEmpty()) {
            System.out.println("empty");
        } else {
            System.out.println(casings.toString().replaceAll("[\\[\\]]", ""));
        }

        System.out.println("Cherry Bombs: " + bombs[1]);
        System.out.println("Datura Bombs: " + bombs[0]);
        System.out.println("Smoke Decoy Bombs: " + bombs[2]);
    }
}
