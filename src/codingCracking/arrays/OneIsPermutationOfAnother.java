package codingCracking.arrays;

import java.util.Arrays;

public class OneIsPermutationOfAnother {

    public static void main(String[] args) {

        String str1 = "hello";
        String str2 = "loleh";

        if (isAPermutation(str1, str2)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }

    private static boolean isAPermutation(String str1, String str2) {

        return sort(str1).equals(sort(str2));
    }

    private static String sort(String s) {

        char[] stringArray = s.toCharArray();
        Arrays.sort(stringArray);
        return new String(stringArray);
    }
}
