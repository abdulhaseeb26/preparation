package codingCracking;

import java.util.HashSet;

public class AllUnique {

    public static void main(String[] args) {

        String str = "hello";
        if (allUnique(str)) {
            System.out.println("All unique");
        } else {
            System.out.println("Not unique");
        }
    }

    private static boolean allUnique(String str) {

        HashSet<Character> characters = new HashSet<>();
        for (char c : str.toCharArray()) {
            if (characters.contains(c)) {
                return Boolean.FALSE;
            }
            characters.add(c);
        }
        return Boolean.TRUE;
    }
}
