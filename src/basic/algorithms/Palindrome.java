package basic.algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class Palindrome {

    static boolean isPalin(String in) {
        return Stream.of(in.split(""))
                .reduce("", (rev, ch) -> ch + rev)
                .equals(in);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter a test string");
        String in = br.readLine();

        System.out.println(isPalin(in));
    }
}
