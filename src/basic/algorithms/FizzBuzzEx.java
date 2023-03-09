package basic.algorithms;

public class FizzBuzzEx {

    static void fizzBuzz(Integer n) {
        // print 1..n, if 3x => fixx, 5x => buzz, 3.5x =>fizzbuzz

        for (int i = 1; i <= n; i++) {
            boolean by3 = i%3 == 0;
            boolean by5 = i%5 == 0;

            if (by3 || by5) {
                if (by3) System.out.print("fizz");
                if (by5) System.out.print("buzz");
                System.out.println();
            } else {
                System.out.println(i);
            }

        }
    }
    public static void main(String[] args) {
    fizzBuzz(16);
    }
}
