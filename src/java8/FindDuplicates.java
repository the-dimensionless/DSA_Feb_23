package java8;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindDuplicates {
    public static void main(String[] args) {
        // Find all duplicate elements from a given string
        String s = "ilovejavatechie";

        Map<String, Long> map = Arrays.stream(s.split(""))
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ));
        System.out.println("Map: " + map);

        List<String> list = map.entrySet().stream()
                .filter(x -> x.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        System.out.println("Duplicates => "+list);

        // or
        Set set = new HashSet();

        List<String> collect = Arrays.stream(s.split(""))
                .filter(ch -> !set.add(ch))
                .collect(Collectors.toList());

        System.out.println(": " + collect);

    }
}
