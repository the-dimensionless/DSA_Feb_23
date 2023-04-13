package basic.streams;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class MethodReferenceEx {
    public static void main(String[] args) {
        List<Integer> list = List.of(34, 67, 8, 23, 67, 89, 90);

        Consumer<Integer> consumer = e -> System.out.println(e);
        Consumer<Integer> consumer2 = System.out::println;
        consumer.accept(56);
        printElements(list, consumer);
        printElements(list, consumer2);

        Supplier<Double> randomNumber = () -> Math.random(); //instead of this
        Supplier<Double> randomNumber2 = Math::random;
        System.out.println(randomNumber2.get());

        BiFunction<String, String, String> biFunction = (a,b) -> A.staticMethod(a,b);
        System.out.println(biFunction.apply("Basics", "Strong"));
        BiFunction<String, String, String> biF2 = A::staticMethod;
        System.out.println(biF2.apply("Basics", "Strong"));


        Function<String, Integer> function = e -> e.length(); //length is not static field
        Function<String, Integer> function2 = String::length;
        System.out.println(function2.apply("ABC"));


        Function<Runnable, Thread> threadGenerator = r -> new Thread(r);
        Function<Runnable, Thread> threadGenerator2 = Thread::new;
        Runnable task1 = () -> System.out.println("Task 1 executed");
        Runnable task2 = () -> System.out.println("Task 2 executed");

        Thread t1 = threadGenerator2.apply(task1);
        Thread t2 = threadGenerator2.apply(task2);

        t1.start();
        t2.start();

        threadGenerator2.apply(() -> System.out.println("Task 3 executed!")).start();
    }

    private static <T> void printElements(List<T> list, Consumer<T> consumer) {
        for (T t: list) {
            consumer.accept(t);
        }
    }
}

class A {
    @Contract(pure = true)
    static @NotNull
    String staticMethod(String a, String b) {
        return a+b;
    }
}
