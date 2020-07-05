package codingCracking.arrays;

public class StringCompression {
    public static void main(String[] args) {

        String str = "aabbccdde";
        System.out.println(compressString(str));
    }

    private static String compressString(String str) {
        int countConsecutive = 0;
        StringBuilder compressedString = new StringBuilder();
        for (int i=0; i< str.length(); i++) {
            countConsecutive ++;
            if (i >= str.length() -1 || str.charAt(i) != str.charAt(i+1)) {
                compressedString.append(str.charAt(i)).append(countConsecutive);
                countConsecutive=0;
            }
        }

        return compressedString.toString();
    }
}
