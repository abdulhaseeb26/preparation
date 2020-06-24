package codingAlgorithms.twoPointers;

import java.util.Arrays;
import java.util.Collection;

public class TwoSum {

    public static void main(String[] args) {

        int [] arr = {2,4,-1,3,-4,0,3};

        Arrays.sort(arr);

        for (int i=0; i<arr.length -2; i++) {

            if (twoSumExists(arr, i+1, - arr[i] )) {
                System.out.println("TRUE");
                break;
            } else {
                System.out.println("FALSE");
            }
        }

    }

    public static boolean twoSumExists(int[] arr, int startingIndex, int requiredSum){

        int endingIndex =arr.length-1;

        while(startingIndex < endingIndex) {

            if (arr[startingIndex] + arr[endingIndex] < requiredSum) {
                startingIndex ++;
            }

            if (arr[startingIndex] + arr[endingIndex] > requiredSum) {
                endingIndex --;
            }
            else {
                return Boolean.TRUE;
            }
        }

        System.out.println("first number=" + arr[startingIndex] + " second number=" + arr[endingIndex]);
        return Boolean.FALSE;
    }
}
