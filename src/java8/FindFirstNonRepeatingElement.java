package java8;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindFirstNonRepeatingElement {
    // Find the first non repeating element in a given string

    public static void main(String[] args) {
        String s = "ilovejavatechie";

        Map<String, Long> map = Arrays.stream(s.split(""))
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        LinkedHashMap::new, //preserves order
                        Collectors.counting()
                ));

        Optional<String> first = map.entrySet().stream()
                .filter(e -> e.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst();

        System.out.println("Non repeating in "+map);
        System.out.println(first.orElse("null"));
    }
}
