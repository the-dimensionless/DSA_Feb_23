package basic.streams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MapEx {
    public static void main(String[] args) {
        Stream<Integer> stream = Stream.of(1,2);

        int sum = stream.mapToInt(i -> i).sum();

        System.out.println();
    }
}
