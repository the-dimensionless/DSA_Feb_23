package interview_quest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class CurrentDateNTime {

    public static void main(String[] args) {

        System.out.println("Current Date: " +
                LocalDate.now());

        System.out.println("Current Time: " +
                LocalTime.now());

        System.out.println("Current Date and Time: " +
                LocalDateTime.now());
    }
}
