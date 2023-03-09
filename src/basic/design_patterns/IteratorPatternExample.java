package basic.design_patterns;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class IteratorPatternExample {

    public static void main(String[] args) {
        // Earlier, we used external iterators: we control the iteration

        var names = List.of("Tom", "Dick", "harry");

       // for (int i = 0; i < names.size(); i++) {} ... //verbose
        for (var name: names) {
            System.out.println(name.toUpperCase(Locale.ROOT));
        }

        // better, internal iterator
        // we focus on what to achieve and iteration is taken care for
        names.stream()
                .filter(name -> name.length() == 5)
                .map(String::toString)
                .limit(2)
                //.takeWhile(predicate)
                .forEach(System.out::println);

        // limit and takeWhile are the functional equivalent of
        // break from the imperative style

        var res1 = new ArrayList<String>();
        for (var name: names) {
            res1.add(name.toUpperCase(Locale.ROOT));
        }
        System.out.println(res1);

        var res2 = new ArrayList<String>();
        names.stream()
                .filter(name -> name.length() == 4)
                .map(String::toUpperCase);
               //  .forEach(name -> res2.add(name)); BAD IDEA
        // shared mutability is bad
        // functional pipeline is NOT pure
        // result maybe unpredictable by adding .parallel()
        // or by changing.stream() to .parallelStream()

        // Functional pipeline offers internal iterators
        // less complex
        // easy to understand and modify


        /*
        Functional Programming relies on lazy evaluation for
        efficiency.
        Lazy Eval & Parallel execution rely on
        immutability and purity of functions for correctness.

        It emphasizes immutability & Purity as it is essential to
        it's survival

        Pure function:
        Idempotent, it returns the same result for same input
        and does not have any side effects.
        1. It does not change any state that is visible outside
        2. It does not depend on anything outside that possibly change.

        IMP: Purity and internal iterators
         */





    }
}
