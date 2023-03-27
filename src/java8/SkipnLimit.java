package java8;

import java.util.stream.IntStream;

public class SkipnLimit {
    public static void main(String[] args) {
        IntStream intStream = IntStream.rangeClosed(1, 10);

        // print only 2-9

        intStream.skip(1).limit(8)
                .forEach(System.out::println);
    }
}
