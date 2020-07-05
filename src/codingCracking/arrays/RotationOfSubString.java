package codingCracking;

public class RotationOfSubString {

    /*
    If s2 is a rotation subStiring of s1 where you can only call isSubStringOnce
     */

    public static void main(String [] args) {

        String s1 = "waterbottle";
        String s2 = "erbottlewat";

        //the rotation point in after wat

        //concatenate s1 to s1

        String s1s1 = s1 + s1;

        if (s1.length() == s2.length() && !s1.isEmpty()) {
            System.out.println(isSubString(s1s1, s2));
        }
    }

    public static boolean isSubString(String s1, String s2) {
        return s1.contains(s2);
    }
}
