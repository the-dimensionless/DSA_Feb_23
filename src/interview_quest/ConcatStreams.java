package interview_quest;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ConcatStreams {
    public static void main(String[] args) {
        Stream<Integer> list = Arrays.asList(1, 2, 3, 4).stream();
        Stream<Integer> list1 = Arrays.asList(5, 6, 7, 8).stream();

        Stream<Integer> concat = Stream.concat(list, list1);
        concat.forEach(System.out::println);

    }
}
