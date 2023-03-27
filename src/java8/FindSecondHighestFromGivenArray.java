package java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FindSecondHighestFromGivenArray {
    public static void main(String[] args) {
        int[] numbers = {5,9,11,2,8,21,1};

        Optional<Integer> integer = Arrays.stream(numbers)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst();
        System.out.println(Arrays.toString(numbers));
        System.out.println("Second highest: " + integer.get());
    }
}
