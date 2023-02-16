package basic.algorithms;

import java.util.HashMap;

public class MaxCharProblem {
    static void maxChar(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();
        Integer max = 0;
        char maxChar = ' ';

        for (char ch: s.toCharArray()) {
            Integer count = hm.get(ch);
            if (count == null) count = 0;
            count++;
            hm.put(ch,  count);
            if (count > max) {
                max = count;
                maxChar = ch;
            }
        }
        System.out.println(hm.toString());
        System.out.println("Max Char " + maxChar);
    }

    public static void main(String[] args) {
        // Give a string, print char that has max frequency
        String s = "abccccccd"; //c
        String s1 = "apple 1231111"; //1
        maxChar(s);
        maxChar(s1);
    }
}
