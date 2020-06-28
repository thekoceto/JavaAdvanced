import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P10_PredicateParty {
    public static void main(String[] args)  throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        List<String> names = Arrays.stream(reader.readLine().split(" ")).collect(Collectors.toList());
        List<String> filteredNames = new ArrayList<>();

        String line;
        while (!"Party!".equals(line = reader.readLine())){
            String command = line.split(" ")[0];
            String operation = line.split(" ")[1];
            String operationParameters = line.split(" ")[2];

            if (command.equals("Remove")){
                if (operation.equals("StartsWith")){
                    filteredNames = StartsWith(operationParameters, names);
                    names.removeAll(filteredNames);
                } else if (operation.equals("EndsWith")){
                    filteredNames = EndsWith(operationParameters, names);
                    names.removeAll(filteredNames);
                } else if (operation.equals("Length")){
                    filteredNames = Length(operationParameters, names);
                    names.removeAll(filteredNames);
                }
            } else if (command.equals("Double")){
                if (operation.equals("StartsWith")){
                    filteredNames = StartsWith(operationParameters, names);
                    names.addAll(filteredNames);
                } else if (operation.equals("EndsWith")){
                    filteredNames = EndsWith(operationParameters, names);
                    names.addAll(filteredNames);
                } else if (operation.equals("Length")){
                    filteredNames = Length(operationParameters, names);
                    names.addAll(filteredNames);
                }
            }
        }

        names.sort(Comparator.naturalOrder());
        if (names.isEmpty()){
            System.out.println("Nobody is going to the party!");
        } else {
            int[] count = new int[]{names.size()};
            names.forEach(z -> {
                if (count[0] > 1){
                    System.out.printf("%s, ", z);
                    count[0]--;
                } else {
                    System.out.printf("%s are going to the party!%n", z);
                }
            });
        }
    }

    public static List<String> StartsWith(String operationParameters, List<String> names){
        Predicate<String> namesPredicate = name -> name.startsWith(operationParameters);
        Function<String, Boolean> filterNames = name -> namesPredicate.test(name);
        List<String> result = names.stream().filter(filterNames::apply).collect(Collectors.toList());

        return result;
    }

    public static List<String> EndsWith(String operationParameters, List<String> names){
        Predicate<String> namesPredicate = name -> name.endsWith(operationParameters);
        Function<String, Boolean> filterNames = name -> namesPredicate.test(name);
        List<String> result = names.stream().filter(filterNames::apply).collect(Collectors.toList());

        return result;
    }

    public static List<String> Length(String operationParameters, List<String> names){
        Integer length = Integer.parseInt(operationParameters);
        Predicate<String> namesPredicate = name -> name.length() == length;
        Function<String, Boolean> filterNames = name -> namesPredicate.test(name);
        List<String> result = names.stream().filter(filterNames::apply).collect(Collectors.toList());

        return result;
    }
}
