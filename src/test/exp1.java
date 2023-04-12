package test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class exp1 {
    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 2, 3);

        int[] factor = {2};

        Stream<Object> stream = integers.stream()
                .map(e -> e * factor[0]);
        stream.forEach(System.out::println);

        factor[0] = 4;



    }
}
