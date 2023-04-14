package basic.sorting;

import java.util.Arrays;
import java.util.function.Consumer;

public class InsertionSort {

    static Consumer<Integer[]> print = (arr) -> {
        Arrays.stream(arr).forEach(System.out::println);
    };

    public static void insertionSort(int[] arr) {
        for (int firstUnsortedIndex = 1; firstUnsortedIndex < arr.length ; firstUnsortedIndex++) {
            int newElement = arr[firstUnsortedIndex];

            int i;

            for (i = firstUnsortedIndex; i > 0 && arr[i-1] > newElement ; i--) {
                arr[i] = arr[i-1];
            }
        }
    }



    public static void main(String[] args) {
        int[] arr = {20, 35, -15, 7, 55, 1, -22};
        System.out.println("Before Insertion sort: " + print);
        insertionSort(arr);
    }

}
