package interview_quest;

import java.util.ArrayList;
import java.util.Arrays;

public class FindFirstEx {

    public static void main(String[] args) {
        ArrayList list = new ArrayList();

        list
            .stream()
            .findFirst()
            .ifPresentOrElse(System.out::println, () -> {
                System.out.println("Empty List");
            });
    }
}
