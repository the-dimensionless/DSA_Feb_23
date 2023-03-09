package basic.streams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MethodsOnStreams {
    public static void main(String[] args) {

        List<Integer> collect = Stream.of(34, 578, 89, 4, 52, 31, 325, 6)
                .filter((e -> e % 2 == 0))
                .collect(Collectors.toList());
        System.out.println(collect);

        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<Integer> collect1 = integerStream.map(e -> e * 25).collect(Collectors.toList());
        System.out.println(collect1);
    }
}
