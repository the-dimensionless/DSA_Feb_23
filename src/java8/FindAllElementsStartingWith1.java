package java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FindAllElementsStartingWith1 {
    public static void main(String[] args) {
        int[] numbers = {5,9,11,2,21,8, 29};

        List<String> stringList = Arrays.stream(numbers)
                .boxed()
                .map(String::valueOf)
                .filter(s -> s.startsWith("2"))
                .collect(Collectors.toList());

        System.out.println(stringList);
    }
}
