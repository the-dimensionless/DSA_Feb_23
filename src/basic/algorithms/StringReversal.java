package basic.algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class StringReversal {
    static void rev1(String in) {
        char ch[] = in.toCharArray();
        for (int i = ch.length - 1; i > -1; i--) {
            System.out.print(ch[i]);
        }
        System.out.println();
    }

    private static void rev2(String in) {
        StringBuffer sb = new StringBuffer(in);
        System.out.println(sb.reverse());
    }

    private static void rev3(String in) {
        String res = Stream.of(in.split("")).reduce("", (rev, ch) -> ch + rev);
        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter a test string");
        String in = br.readLine();

        rev1(in);
        rev2(in);
        rev3(in);
    }
}
