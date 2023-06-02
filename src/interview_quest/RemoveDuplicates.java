package interview_quest;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.function.Function;
import java.util.stream.Collectors;

public class RemoveDuplicates {
    public static void main(String[] args) {
        Arrays.asList(1,2,3,4,1,2,3)
                .stream()
                .collect(Collectors.toSet())
                .forEach(System.out::println);

    }
}
