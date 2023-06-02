package interview_quest;

import java.util.Arrays;
import java.util.stream.Collectors;

public class FindDistinct {
    public static void main(String[] args) {
        String s = Arrays.asList(10, 15, 8, 49, 25, 98, 98, 32, 15)
                .stream()
                .distinct()
                .map(String::valueOf)
                .collect(Collectors.joining(","));
        System.out.println(s);
    }
}
