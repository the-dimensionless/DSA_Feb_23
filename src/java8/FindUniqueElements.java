package java8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindUniqueElements {
    public static void main(String[] args) {
        // Find unique elements in a string
        String s = "ilovejavatechie";

        List<String> list = Arrays.stream(s.split(""))
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                )).entrySet().stream()
                .filter(e -> e.getValue() == 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        System.out.println(String.format(
                "Unique elements in %s are: \n", s
        ) + list);
    }
}
