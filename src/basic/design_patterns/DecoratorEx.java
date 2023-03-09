package basic.design_patterns;

import java.util.function.Function;

public class DecoratorEx {
    // Decorators using lambdas
    /*
        Old
        DataInputStream dis =
            new DataInputStream(
                new BufferedStream(
                    new FileInputStream(...))));
     */

    public static void main(String[] args) {
        // Functions are composable
        Function<Integer, Integer> inc = value -> value + 1;
        Function<Integer, Integer> doubled = value -> value * 2;

        print(5, "incremented", inc);
        print(6, "doubled", doubled);

        print(5, "incremented and doubled",
                value -> (value + 1)*2); // Ehh... not happy
        System.out.println();
        /*
        inc ---->|inc|----->
        double--->|doubled|----->

        combine (functional pipeline) Composing
        ----->|--->|inc|---->|doubled|---->|---->
         */

        print(5, "Composition1: incremented and doubled",
                inc.andThen(doubled));
        print(5, "Composition2: incremented and doubled",
                doubled.compose(inc));

    }

    public static void print(int number,
                             String message,
                             Function<Integer, Integer> func) {
        System.out.println(number + " " + message + ": " +
                func.apply(number));
    }
}
