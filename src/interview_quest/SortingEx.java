package interview_quest;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

public class SortingEx {

    public static void main(String[] args) {
        String s = Arrays.asList(10, 15, 8, 49, 25, 98, 98, 32, 15)
                .stream()
                .sorted(Collections.reverseOrder())
                .map(String::valueOf)
                .collect(Collectors.joining(" > "));

        System.out.println(s);

    }
}
