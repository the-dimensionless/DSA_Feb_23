package test;

import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.Map.entry;

public class Example {

    static Predicate<Map.Entry<String, String>> predicate = (e) ->
            e.getKey().equalsIgnoreCase("A") ||
            e.getKey().equalsIgnoreCase("B");

    public static void main(String[] args) {
        Map<String, String> hm = Map.ofEntries(
                entry("A", "A1"),
                entry("B", "B2"),
                entry("C", "C3"),
                entry("D", "D4")
        );

        Map<String, String> map = hm.entrySet().stream()
                .filter(Predicate.not(predicate))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        System.out.println("New Entries are :" + map);
    }
}
