package codingCracking;


import java.util.HashMap;
import java.util.Map;

public class PalindromePermutation {
    public static void main(String[] args) {

        //No more than 1 element should have an even count of characters
        String str = "TactCoa";

        System.out.println(isPalindromePermutation(str));
    }

    private static boolean isPalindromePermutation(String str) {

        Map<Character, Integer> characterCount = new HashMap<>();

        long oddCount = 0L;
        for (char c : str.toCharArray()) {
            characterCount.put(Character.toLowerCase(c), characterCount.getOrDefault(Character.toLowerCase(c), 0) + 1);
            if (characterCount.get(Character.toLowerCase(c)) % 2 != 0) {
                oddCount++;
            } else {
                oddCount--;
            }
        }

        return oddCount <= 1;
    }
}
