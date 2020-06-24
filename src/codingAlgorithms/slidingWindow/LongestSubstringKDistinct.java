package codingAlgorithms.slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringKDistinct {

    public static void main(String[] args) {
        char[] arr = {'A','A','A','H','H','I','B','C'};
        System.out.println(findLength(arr, 2));
    }

    private static int findLength(char[] arr, int possibleDistinctCharacters) {

        int windowStart = 0;
        int longestLength = 0;
        Map<Character, Integer> charFrequencyMap =  new HashMap<>();

        for (int windowEnd=0; windowEnd < arr.length; windowEnd ++) {

            charFrequencyMap.put(arr[windowEnd], charFrequencyMap.getOrDefault(arr[windowEnd], 0) +1);

            while(charFrequencyMap.size() > possibleDistinctCharacters) {

                charFrequencyMap.put(arr[windowStart], charFrequencyMap.get(arr[windowStart]) -1);
                if (charFrequencyMap.get(arr[windowStart]) == 0) {
                    charFrequencyMap.remove(arr[windowStart]);
                }
                windowStart ++;
            }

            longestLength = Math.max(longestLength, windowEnd - windowStart +1);
        }

        return longestLength;
    }
}
