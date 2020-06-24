package codingAlgorithms.slidingWindow;

public class LongestSubStringWithoutRepeatingCharacters {

    public static void main(String[] args) {

//        String str1 = "abc";
//        String str2 = "abc";


        String str1 = new String("abc");
        String str2 = new String("abc");

        System.out.println(str1 == str2);
        System.out.println(str1.equals(str2));

    }

    private static int findLongestSubStringLength(String str) {

        for (int i =0; i< str.length()-1; i ++) {


        }

        return 0;
    }
}

class Node {

    int data;
    Node next;

    // Constructor
    Node(int d)
    {
        data = d;
        next = null;
    }
}
