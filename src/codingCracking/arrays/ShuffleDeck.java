package codingCracking.arrays;

import java.util.List;
import java.util.Random;

public class ShuffleDeck {

    public static void main(String[] args) {

        int[] arr = new int[52];
        for (int a= 0; a < 52;a++) {
            arr[a] = a;
        }

        shuffleDeck(arr);
    }

    private static void shuffleDeck(int[] arr) {

        Random random = new Random();
        int r;
        int temp;

        for (int i=0; i< arr.length; i++) {
            r = i + random.nextInt(arr.length - i);
            temp = arr[i];
            arr[i] = arr[r];
            arr[r] = temp;
        }

        System.out.println("done");
    }
}
