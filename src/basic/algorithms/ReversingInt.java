package basic.algorithms;

import java.util.Arrays;

public class ReversingInt {
    static int revInt(int i) {
        String rev = Arrays.stream(Integer.toString(i).split(""))
                .reduce("", (r, ch) -> ch + r);
        return (i < 0) ? Integer.parseInt(rev.substring(0, rev.length()-1)) * -1 : Integer.parseInt(rev);

    }
    public static void main(String[] args) {
       int arr[] = {15, 189, 500, -15, -90};
        for (int i:arr) System.out.println("For "+ i + " => "+revInt(i));
    }
}
