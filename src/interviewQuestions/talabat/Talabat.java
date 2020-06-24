package interviewQuestions.talabat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Talabat {

    public static void main(String[] arg) {

        Solution s = new Solution();
        int[] nums = new int[]{2,5,5,11};
        s.twoSum(nums, 10);

        int palindrome = 121;
        s.palindrome(palindrome);

        String roman = "MCMXCIV";
        s.roman(roman);

        //Longest Common Prefix
        String[] prefix = {"flower","flow","flight"};
        //System.out.println(s.longestPrefix(prefix));

        //IsValid Bracket
        String bracket = "(){}[]";
        //System.out.println(s.isValid(bracket));

        int[] numbers = {1, 10, 100, 1000, 10000, 100000};
        //System.out.println(s.findArraySum(numbers));

        int[] secondhighest = new int[]{5,3,2,7,1,6};
        //System.out.println(s.secondHighest(secondhighest));

        String duplicate = "abcdaad";
        //System.out.println(s.removeDuplicates(duplicate));

        int[] separateOut = {2,3,0,0,4,5,0,9,0,9};
        //Arrays.stream(s.separateOut(separateOut)).forEach( i -> System.out.println(i));

        int[][] matrix = new int[2][4];
        //s.matrix(matrix);

        String parenthesisPass = "({[]})[]";
        //System.out.println(s.balanceParenthesis(parenthesisPass));

        String parenthesisFail = "({[]})[]}";
        //System.out.println(s.balanceParenthesis(parenthesisFail));

        int[] customers = {2,3,10};
        int n = 2;
        //System.out.println(s.customerCheckOut(customers, n));

        int[] search = {5,3,2,7,1,6,5,3,2,7,1,46,5346,5,6,456,45,64,56,456,4,564,56};
        //System.out.println(s.binarySearch(search, 999));
        String S = "ab#c", T = "ad#c";
        System.out.println(s.backspaceCompare(S, T));

        int number = 371;
        s.armStrongNumber(number);

        s.getLinkedList();

    }

    public static class Solution {


        public int[] twoSum(int[] nums, int target) {

            int k = 0;
            int sum = 0;

            int[] result = new int[2];
            for(int i = 1; i<nums.length; i++) {

                sum = nums[k] + nums[i];
                if(sum == target) {
                    result[0] = k;
                    result[1] = i;
                    return result;
                }
                if(i == nums.length-1) {
                    i = k+1;
                    k++;

                    if((nums[nums.length - 1] + nums[nums.length - 2]) == target){
                        result[0] = nums.length - 2;
                        result[1] = nums.length - 1;
                    }
                }
            }
            return result;
        }

        public  boolean palindrome(int num) {

            char[] digits = String.valueOf(num).toCharArray();

            boolean palindrome = true;
            int j = digits.length - 1;

            int length = digits.length;

            for (int i = 0; i < length - 1; i++) {
                if(digits[i] == digits[j]) {
                    j--;
                    continue;
                } else {
                    palindrome = false;
                    break;
                }
            }
            return palindrome;
        }

        public int roman(String x) {
            int result = 0;
            Map<Character, Integer> dict = new HashMap<>();
            dict.put('I', 1);
            dict.put('V', 5);
            dict.put('X', 10);
            dict.put('L', 50);
            dict.put('C', 100);
            dict.put('D', 500);
            dict.put('M', 1000);


            char[] roman = x.toCharArray();
            for(int i = 0; i <=roman.length - 1; i++) {

                if (i == 0)
                {
                    result += dict.get(roman[i]);
                    continue;
                }
                //MCMXCIV
                if(dict.get(roman[i-1]) >= dict.get(roman[i])) {
                    result += dict.get(roman[i]);
                } else {
                    result = dict.get(roman[i]) + result - (2 * dict.get(roman[i-1]));
                }
            }
            return result;
        }

        public String longestPrefix(String[] strs) {
            int size = strs.length;
            if (size == 0) {
                return "";
            }
            // The longest common prefix of an array containing
            // only one element is that element itself.
            else if (size == 1) {
                return strs[0];
            } else {
                String result = "";
                Arrays.sort(strs);
                int length = strs[0].length();
                for (int i = 0; i < length; i++) {
                    if (strs[0].charAt(i) == strs[size - 1].charAt(i)) {
                        result += String.valueOf(strs[0].charAt(i));
                    } else {
                        break;
                    }
                }
                return result;
            }
        }

        public boolean isValid(String brackets) {
            Map<String, String> map = new HashMap<>();
            map.put("()", "()");
            map.put("[]", "[]");
            map.put("{}", "{}");
            int length = brackets.length();
            for(int i = 0; i < length; i++) {
                if(map.get(brackets.charAt(i)+""+brackets.charAt(i+1)) == null) {
                    return false;
                }
                i++;
            }
            return true;
        }

        public double findArraySum(int[] numbers) {
            double sum = 0;
            for (int i =0; i < numbers.length; i++) {
                sum+=numbers[i];
            }
            return sum;
        }
        //arr = [5,3,2,7,1,6]
        public int secondHighest(int[] numbers) {
            int first = numbers[0];
            int second = 0;
            for (int i = 1; i < numbers.length; i++) {
                if(numbers[i] > first) {
                    second = first;
                    first = numbers[i];
                } else if (numbers[i] > second && numbers[i] != first) {
                    second = numbers[i];
                }
            }
            return second;
        }

        public String removeDuplicates(String duplicates) {
            char[] charArray = duplicates.toCharArray();
            String removeDuplicate = "";
            Map<String, Integer> map = new HashMap<>();
            for(int i = 0;  i <charArray.length; i ++) {
                if(map.get(String.valueOf(charArray[i])) == null) {
                    map.put(String.valueOf(charArray[i]), i);
                    removeDuplicate += charArray[i];
                }
            }
            return removeDuplicate;
        }
        // 2,3,0,0,4,5,0,9,0,9 
        // 9,9 ,2,3,4,5,0,0,0,0
        public int[] separateOut(int[] numbers) {
            int k = 0;
            int[] zeros = new int[numbers.length];
            for (int i = numbers.length-1; i >= 0 ;i--) {
                if(numbers[i] != 0) {
                    zeros[k] = numbers[i];
                    k++;
                }
            }
            k = 0;
            for(int i = zeros.length-1; i >=0; i--) {
                numbers[i] = zeros[k];
                k++;
            }
            return numbers;
        }

        public int[][] matrix(int[][] matrix) {
            int size = matrix.length;
            System.out.println(size);
            return null;
        }


        public boolean balanceParenthesis(String parenthesis) {
            Stack<Character> stack = new Stack<>();
            boolean isBalanced;
            for(int i = 0; i < parenthesis.length(); i++) {
                if(parenthesis.charAt(i) == '(' || parenthesis.charAt(i) == '{' || parenthesis.charAt(i) == '['){
                    stack.push(parenthesis.charAt(i));
                }
                else if(!stack.empty() && (
                        (parenthesis.charAt(i) == ')') ||
                                (parenthesis.charAt(i) == '}') ||
                                (parenthesis.charAt(i) == ']'))) {
                    stack.pop();
                }
                else {
                    stack.push(parenthesis.charAt(i));
                }
            }
            if(stack.empty()) {
                isBalanced = true;
            } else {
                isBalanced = false;
            }
            return isBalanced;
        }

        public int customerCheckOut(int[] customer, int n) {
            List<Integer> checkout = new ArrayList<>();
            int sum = 0;
            if(n == 0) {
                for(int i = 0; i < customer.length; i++ ) {
                    sum += customer[i];
                }
                return sum;
            }

            for(int i = 0; i < n; i++ ){
                checkout.add(0);
            }
            for(int i = 0; i <customer.length; i++) {
                checkout.set(checkout.indexOf(Collections.min(checkout)), Collections.min(checkout) + customer[i]);
            }
            return Collections.max(checkout);
        }

        //arr = [5,3,2,7,1,6]
        //arr = [1,2,3,5,6,7,8], 6
        public int binarySearch(int[] array, int key) {
            Arrays.sort(array);
            int low = array[0];
            int high = array.length-1;
            int index = -1;

            while (low <= high) {
                int mid  = (low+high)/2;
                if(array[mid] < key) {
                    low = mid + 1;
                } else if(array[mid] >key){
                    high = mid-1;
                } else if(key == array[mid]) {
                    index = mid;
                    break;
                }
            }
            return index;
        }

        public boolean backspaceCompare(String S, String T) {
            return build(S).equals(build(T));
        }

        public String build(String S) {
            Stack<Character> ans = new Stack();
            for (char c: S.toCharArray()) {
                if (c != '#')
                    ans.push(c);
                else if (!ans.empty())
                    ans.pop();
            }
            return String.valueOf(ans);
        }

        public void armStrongNumber(int number) {
            int originalNumber, remainder, result = 0;

            originalNumber = number;

            while (originalNumber != 0)
            {
                remainder = originalNumber % 10;
                result += Math.pow(remainder, 3);
                originalNumber /= 10;
            }

            if(result == number)
                System.out.println(number + " is an Armstrong number.");
            else
                System.out.println(number + " is not an Armstrong number.");

        }
        public void getLinkedList() {
            LinkedList<Integer> linky = new LinkedList<>();
            linky.add(65);
            linky.add(75);
            linky.add(5);
            Iterator iterate = linky.iterator();
            while (iterate.hasNext()) {
                if((int)iterate.next()== 75) {
                    System.out.println("Found number: "+75);
                }
            }
        }
        //1-2-3-4-5-NULL
        // ListNode
        public ListNode reverseList() {
            ListNode third = new ListNode(3);
            third.next = null;
            ListNode second = new ListNode(2);
            second.next = third;
            ListNode head = new ListNode(1);
            head.next = second;


            Stack<ListNode> stackNode = new Stack<>();
            while(head.next != null) {
                stackNode.push(head);
                head = head.next;
            }

            ListNode dummy = new ListNode(-1);
            head = dummy;
            while(!stackNode.isEmpty()) {
                ListNode node = stackNode.pop();
                head.next = new ListNode(node.val);
                head = head.next;
            }
            return dummy.next;
        }

    }


    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
