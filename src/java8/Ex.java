package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ex {

    static Function<Integer, Integer> square = (x) -> x * x;
    static Function<Integer, Integer> doubled = (x) -> x + x;
    static Predicate<Integer> testForOdd = (x) -> (x % 2 != 0);
    static Predicate<Integer> lessThan20 = (x) -> x < 20;

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8));



        // get x*x % 2

        List<Integer> result = list.stream()
                .map(square)
                .filter(testForOdd)
                .collect(Collectors.toList());

        System.out.println("Result " + result);


        List<Integer> result2 = list.stream()
                .map(square.andThen(x -> x+x))
                .filter(testForOdd.negate().and(lessThan20)) // testforOdd && lessThan20
                .collect(Collectors.toList());

        System.out.println("Result " + result2);


        List<Integer> result3 = list.stream()
                .map(square.andThen(doubled))
                .collect(Collectors.toList());

        System.out.println("Result " + result3);


        List<Integer> result4 = list.stream()
                .map(square.compose(doubled))
                .collect(Collectors.toList());

        System.out.println("Result " + result4);


        Optional<Integer> first = list.stream()
                .map(square.compose(doubled))
                .filter(i -> i < -1)
                .findFirst();

        System.out.println("Result " + first.orElse(0));
        //System.out.println("Result " + first.orElseThrow(() -> new RuntimeException("Hahaha sucker")));

        Optional<Integer> first1 = list.stream().parallel()
                .map(square.compose(doubled))
                .skip(4)
                .findAny();

        System.out.println("Result " + first1.orElse(0));

        list.stream().parallel()
                .map(square.compose(doubled))
                .skip(4)
                .findAny();

        System.out.println("Result " + first1.orElse(0));


        Stream<Integer> stream = list.stream();

//        stream.forEach(System.out::println);
//        list.stream().forEach(System.out::println);


        System.out.println("Sum " + IntStream.range(1, 10).sum());
        System.out.println("Max " + IntStream.range(1, 10).max());
        System.out.println("Min " + IntStream.range(1, 10).min());
        System.out.println("Avg" + IntStream.range(1, 10).average());
        System.out.println("Stats " + IntStream.range(1, 10).summaryStatistics());


        // traditional
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += i;
        }
        System.out.println("Sum "+sum);

//        function (x2, acc + x) {
//            return acc + x
//        }


        Integer reduceVal =
                IntStream.range(1, 10)
                        .reduce(20, (x, acc) -> x + acc);

        System.out.println("Result " + reduceVal);

    }
}

class Utils {
    public static Integer square(Integer x) {
        return x * x;
    }
}
