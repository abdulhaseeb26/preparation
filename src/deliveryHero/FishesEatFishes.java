package deliveryHero;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FishesEatFishes {

    public static void main(String[] args) {


        String s = "ABAD";
        String s2 = "ABBD";
        String s3 = "ACCD";
        String s4 = "ABBA";


        System.out.println(findSurviningFishes(s));
        System.out.println(findSurviningFishes(s2));
        System.out.println(findSurviningFishes(s3));
        System.out.println(findSurviningFishes(s4));

    }

    private static String findSurviningFishes(String str) {

        //  ABBA
        // ABAD

        Map<Character, List<Character>> eatMap = getEatMap();

        for (int j = str.length() -2 ; j >= 0; j --) {
            if (eatMap.get(str.charAt(j)).contains(str.charAt(j + 1))) {
                return findSurviningFishes(charRemoveAt(str, j +1));
            }
        }

        return str;
    }

    private static Map<Character, List<Character>> getEatMap() {
        Map<Character, List<Character>> eatMap = new HashMap<>();
        eatMap.put('A', Arrays.asList('B', 'C'));
        eatMap.put('B', Arrays.asList('C', 'D'));
        eatMap.put('C', Arrays.asList('D'));
        eatMap.put('D', Arrays.asList());

        return eatMap;
    }

    public static String charRemoveAt(String str, int p) {
        return str.substring(0, p) + str.substring(p + 1);
    }


}
