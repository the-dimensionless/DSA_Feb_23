package basic.design_patterns;

import java.util.function.Supplier;

public class LazyEvalWithLambdasEx {

    public static int compute(int number) {
        // imagine takes some time to compute
        System.out.println("Compute is called!");
        return number * 100;
    }

    public static void main(String[] args) {
        /*
        Lazy eval is to functional programming as
        polymorphism is to OOPs.
        Lazy helps in improving performance
        Examples of non lazy code (check),

        David Wheeler => In CS we can solve any problem by
        introducing one more level of indirection.

        lazy already in streams api
        diy (like waiver or etc)

        Indirection
        Procedural => pointers
        OOP => overriding fn
        in FP, lambdas give the power of indirection

        myFn1(Type value) - eager
        myFn2(Supplier<Type> supplier) - Lazy

        when to pass a value vs a functional interface to a method?
        One consideration is lazy evaluation.

         */

        int value = 14 ;
//        int temp = compute(value); // Eager Evaluation

        Lazy<Integer> temp = new Lazy<>(() -> compute(value));

        // if (value > 4 && compute(value) > 100) {
        if (value > 4 && temp.get() > 100) {
            System.out.println("Path 1 " + temp.get());
        } else {
            System.out.println("Path 2");
        }
    }

}

class Lazy<T> {
    private T instance;
    private Supplier<T> supplier;

    public Lazy(Supplier<T> supplier) {
        this.supplier = supplier;
    }

    public T get() {
        if(instance == null) {
            instance = supplier.get();
        }
        return instance;
    }
}
