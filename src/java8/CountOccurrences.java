package java8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountOccurrences {
    public static void main(String[] args) {
        // Count occurrence of each char in a given String

        String s = "ilovejavatechie";

        Map<String, Long> map = Arrays.stream(s.split(""))
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ));
        System.out.println("Char Count Map => \n" + map);
    }
}
