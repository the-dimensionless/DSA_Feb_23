package interview_quest;

import java.util.Arrays;
import java.util.stream.Collectors;

public class FindNumbersStartingWith1 {

    public static void main(String[] args) {
        String s1 = Arrays.asList(10, 15, 8, 49, null, 25, 98, 32)
                .stream()
                .map(String::valueOf)
                .filter(s -> s.startsWith("1"))
                .collect(Collectors.joining(","));

        System.out.println(s1);

    }
}
