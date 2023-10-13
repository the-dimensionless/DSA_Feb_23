package pp;

import java.util.List;
import java.util.stream.Collectors;

public class LotteryEx {

    public static void main(String[] args) {

        int N = 5; // no of ppl
        int Q = 3; // no of queries
        List<Integer> Quer = List.of(1,7,5); // Query individual values

        double sum = getNo(1, N);

        System.out.println(sum);

    }

    public static double getNo(int x, int N) {
        System.out.println("x "+x+" N "+x);
       Double p = Math.pow(2, N) - 1;
        System.out.println("t " + (x*p));
       return x * p;
    }
}
