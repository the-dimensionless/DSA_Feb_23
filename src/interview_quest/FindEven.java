package interview_quest;

import java.util.Arrays;
import java.util.Timer;
import java.util.stream.Collectors;

public class FindEven {

    public static boolean isEven(int x)  {
        return x%2 == 0;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        String collect = Arrays.asList(10, 15, 8, 49, 25, 98, 32)
                .stream()
                .filter(FindEven::isEven)
                .map(String::valueOf)
                .collect(Collectors.joining(","));
        long end = System.currentTimeMillis();

        System.out.println("Even: " + collect + " in " + (end-start) + " ms");
    }
}


