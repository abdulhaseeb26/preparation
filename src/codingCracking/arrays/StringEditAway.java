package codingCracking;

public class StringEditAway {

    public static void main(String[] args) {

        String str1 = "apple";
        String str2 = "bpple";

        if (str1.length() == str2.length()) {
            System.out.println(checkOneReplacementAway(str1, str2));
        } else if (str1.length() == str2.length()-1) {
            System.out.println(checkIfOneInsertAway(str1, str2));
        }
    }

    private static boolean checkIfOneInsertAway(String str1, String str2) {
        //TODO: implement the logic
        return Boolean.TRUE;
    }

    private static Boolean checkOneReplacementAway(String str1, String str2) {

        Boolean found = Boolean.FALSE;

        for (int i =0; i< str1.length(); i ++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                if (found) {
                    return Boolean.FALSE;
                }
                found = Boolean.TRUE;
            }
        }

        return Boolean.TRUE;
    }


}
