import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class P01_SantasPresentFactory {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayDeque<Integer> materials = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt).boxed()
                .filter(num -> num != 0)
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> magic = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt).boxed()
                .filter(num -> num != 0)
                .collect(Collectors.toCollection(ArrayDeque::new));

        Map<String, int[]> ready = new TreeMap<>();

        Map<Integer, String> presents = new HashMap<>(){{
            put(150, "Doll");       put(250, "Wooden train");
            put(400, "Bicycle");    put(300, "Teddy bear");
        }};

        while (!materials.isEmpty() && !magic.isEmpty()){
            while (materials.getLast() == 0)
                materials.pollLast();
            while (magic.getFirst() == 0)
                magic.pollFirst();

            if (materials.isEmpty() || magic.isEmpty())
                break;
            if (presents.get(materials.getLast()*magic.getFirst()) != null){
                String toAdd = presents.get(materials.removeLast()*magic.removeFirst());
                ready.putIfAbsent(toAdd, new int[]{0});
                ready.get(toAdd)[0]++;
            }
            else if(materials.getLast()*magic.getFirst() < 0){
                materials.addLast(materials.removeLast()+magic.removeFirst());
            }
            else if(presents.get(materials.getLast()*magic.getFirst()) == null){
                magic.pollLast();
                materials.addLast(materials.pollLast()+14);
            }
        }
        StringBuilder out = new StringBuilder();
        if ((ready.containsKey("Doll") && ready.containsKey("Wooden train")) ||
                (ready.containsKey("Teddy bear") && ready.containsKey("Bicycle"))) {
            out.append("The presents are crafted! Merry Christmas!").append(System.lineSeparator());
        } else {
            out.append("No presents this Christmas!").append(System.lineSeparator());
        }
        if (!materials.isEmpty()){
            out.append("Materials left: ");
            materials.forEach(integer -> out.append(integer).append(" "));
            out.append(System.lineSeparator());
        }
        if (!magic.isEmpty()){
            out.append("Magic left: ");
            magic.forEach(integer -> out.append(integer).append(" "));
            out.append(System.lineSeparator());
        }
        ready.forEach((k,v) -> out.append(k).append(": ").append(v[0]).append(System.lineSeparator()));

        System.out.println(out.toString().trim());
    }
}