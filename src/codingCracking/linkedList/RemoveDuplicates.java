package codingCracking.linkedList;

import java.util.LinkedList;

public class RemoveDuplicates {

    public static void main(String[] args) {

        String str = "HELLO";

        LinkedList linkedList = getLinkedList(str);
        removeDuplicates(linkedList);

    }

    private static void removeDuplicates(LinkedList linkedList) {

    }

    private static LinkedList getLinkedList(String str) {

        LinkedList linkedList = new LinkedList();

        for (char c : str.toCharArray()) {
            linkedList.add(c);
        }

        return linkedList;
    }
}
