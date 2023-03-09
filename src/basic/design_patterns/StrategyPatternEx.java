package basic.design_patterns;

import java.util.List;
import java.util.function.Predicate;

public class StrategyPatternEx {

    /*
    We want to vary a small part of algorithm while keeping the rest of the
    algorithm the same.
    Language design is program design.

    Design patterns often kick in to fill in the gaps of a
    programming language.

    A more powerful a language is, the less we talk about
    design patterns as these naturally become the feature of the
    language.

    lambdas are lightweight strategies

     */

    public static int totalValues(List<Integer> numbers) {
        int total = 0;

        for(var n: numbers) {
            total += n;
        }
        return total;
    }

    public static int findTotalValues(List<Integer> numbers,
                                      Predicate<Integer> selector) {

        int total = 0;
        for (var n: numbers) {
            if (selector.test(n)) {
                total += n;
            }
        }

        // return total
        // better

        return numbers.stream()
                .filter(selector)
                .mapToInt(e -> e)
                .sum();

    }

    public static void main(String[] args) {
        /*
        Suppose we have a collection of numbers.
        We need a method to total all values.
         */

        var nums = List.of(1,2,3,4,5,6);
        System.out.println(totalValues(nums));

        // Now we need one fn to total Even values
        // Now one more to total all odd values

        // Strategies are often a single method or functions
        // So functional interfaces & lambdas work really well

        System.out.println(findTotalValues(nums, ignore -> true));
        System.out.println(findTotalValues(nums, Predicate.not(StrategyPatternEx::isOdd)));
        System.out.println(findTotalValues(nums, StrategyPatternEx::isOdd));

    }

    public static boolean isOdd(int i) {
        return i%2 != 0;
    }
}
