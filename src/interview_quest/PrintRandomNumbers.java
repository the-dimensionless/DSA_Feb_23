package interview_quest;

import java.util.Random;
import java.util.stream.Collectors;

public class PrintRandomNumbers {
    public static void main(String[] args) {
        Random random = new Random();

        String s = random.ints(10, 1, 7)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(","));
        System.out.println(s);
    }
}
