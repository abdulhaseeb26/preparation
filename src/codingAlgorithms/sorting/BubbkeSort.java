package codingAlgorithms.sorting;

import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class BubbkeSort {

    public static void main(String[] args) {

        Integer [] arr = {1,2,3,4,5,7};

        Predicate<Integer> greaterThanFive = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer > 5;
            }
        };

        Arrays.stream(arr).filter(greaterThanFive).collect(Collectors.toList());

        //bubbleSort(arr);
    }

    private static int[] bubbleSort(int[] arr) {

        int endingPOinter = arr.length -1;
        int startingPointer =0;
        int temp;
        for (int a =0; a< arr.length -1; a++) {

            while (startingPointer < endingPOinter) {

                if (arr[startingPointer] > arr[startingPointer + 1]) {
                    temp = arr[startingPointer];
                    arr[startingPointer] = arr[startingPointer + 1];
                    arr[startingPointer + 1] = temp;
                }
                startingPointer ++;
            }
             endingPOinter --;
        }
        return arr;
    }
}
