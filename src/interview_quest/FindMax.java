package interview_quest;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindMax {

    public static void main(String[] args) {
        Integer max = Arrays.asList(10, 15, 8, 49, 25, 98, 98, 32, 15)
                .stream()
                .max(Integer::compare)
                .get();
        System.out.println("max is "+ max);

        Student maxAge = Arrays.asList(
                        new Student("Sumit", 25),
                        new Student("Shweta", 24),
                        new Student("Narayan", 26)
                ).stream()
                .max(Student::compareTo)
                .get();

        System.out.println("Max age " + maxAge);


    }
}

class Student implements Comparable<Student> {
    String name;
    int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(@NotNull Student o) {
        return (o.age > this.age) ? -1: 1;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
