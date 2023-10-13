package basic.streams;

import java.util.Optional;
import java.util.function.Supplier;

public class OptionalEx {
    public static void main(String[] args) {
        Integer a = 10;

        Optional<Integer> opt = Optional.of(a);
        Optional<Integer> optional = Optional.empty();

        //isPresent
        Integer val = opt.isPresent() ? opt.get() : 0;
        System.out.println(val);

        //orElse
        Integer integer = opt.orElse(0);
        System.out.println(integer);

        //orElseGet

        Integer orElseGet = optional.orElseGet(() -> 0);
        System.out.println(orElseGet);

    }
}
