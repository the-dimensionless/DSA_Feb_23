package java8;

import java.util.Arrays;
import java.util.List;

public class JoinString {
    public static void main(String[] args) {
        List<String> list = Arrays.asList(
                "1", "2", "3", "4"
        );
        //1-2-3-4

        String s = String.join("-", list);
        System.out.println(s);
    }
}
