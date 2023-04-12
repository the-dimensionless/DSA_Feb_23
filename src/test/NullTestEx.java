package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

public class NullTestEx {

    public static void main(String[] args) {
        Optional<List<String>> opt = Optional.of(new ArrayList<>());

        IntStream.rangeClosed(1, 10).forEach(i -> opt.get().add(String.valueOf(i)));



        System.out.println(opt.get());
    }
}
