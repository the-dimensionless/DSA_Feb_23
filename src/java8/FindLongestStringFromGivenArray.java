package java8;

import java.util.Arrays;
import java.util.Comparator;

public class FindLongestStringFromGivenArray {
    public static void main(String[] args) {
        String[] arr;
        arr = new String[]{
                "java",
                "techie",
                "springboot",
                "microservices",
                "docker8s amazonwebservice"
        };

        String s = Arrays.stream(arr)
                .reduce((s1, s2) ->
                        s1.length() > s2.length() ? s1 : s2
                ).get();
        System.out.println(s);
    }
}
