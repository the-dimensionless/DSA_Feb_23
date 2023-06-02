package interview_quest;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CollectionsFrequencyExample {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(
                1, 1, 1,
                2, 2,
                3, 3, 3,
                4, 4, 4, 4, 4, 4
                , 5, 5, 6,
                7, 7,
                8, 8, 8, 8,
                9, 9, 9, 9, 9, 9
        );
        int i = Collections.frequency(list, 3);
        System.out.println("Frequency of 3: " + i);


        list.stream()
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ))
                .entrySet().stream().forEach(e -> {
                    System.out.println(e.getKey()+": " +
                            e.getValue());
                });
    }
}
