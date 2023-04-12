package basic.threading;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Ex {

    static Predicate<String> p = (s) -> s.startsWith("S");

    public static void main(String[] args) {
        List l = new ArrayList<>(Arrays.asList("Sumit", "Rakesh",  "Saibhav"));
        System.out.println(
                l.stream()
                        .filter(p)
                        .collect(Collectors.toList())
        );
    }
}
