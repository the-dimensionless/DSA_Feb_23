package basic.algorithms;

import java.util.Arrays;

public class ArrayChunking {
    public static void chunk(int arr[], int size) {
        int n = arr.length;
        int subArr[] = new int[size];
        int count = 0;

        for (int i = 0; i < n; i++, count++) {
            //System.out.println("i: "+i + " count: "+count + " subArr:"+Arrays.toString(subArr));
            subArr[count] = arr[i];
            if (count == size-1 || i == n-1) {
                System.out.print(Arrays.toString(subArr)+",");
                subArr = new int[size];
                count = -1;
            }
        }

    }

    public static void main(String[] args) {
        chunk(new int[] {1,2,3,4}, 2);
        System.out.println();
        chunk(new int[] {1,2,3,4,5}, 3);
    }
}
