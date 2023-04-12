package basic.threading;

import java.util.*;

public class Test {

    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));

        Integer max = Collections.max(l, Comparator.comparing(i -> i % 2 == 0));
        System.out.println(max);

    }
}
