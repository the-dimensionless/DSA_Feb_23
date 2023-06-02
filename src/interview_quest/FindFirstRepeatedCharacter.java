package interview_quest;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindFirstRepeatedCharacter {
    public static void main(String[] args) {
        String input = "Java Hungry Blog Alive is Awesome";

        String s = Arrays.stream(clean(input))
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        LinkedHashMap::new,
                        Collectors.counting()
                ))
                .entrySet().stream()
                .filter(e -> e.getValue() > 1)
                .findFirst()
                .map(Map.Entry::getKey)
                .get();

        System.out.println("First repeating character is " + s);


    }

    public static String[] clean(String s) {
        return s.replaceAll(" ", "").split("");
    }
}
