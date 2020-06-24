package interviewQuestions.zalando;

import java.util.ArrayList;
import java.util.List;

public class Sum {
    public static void main(String[] args) {

        Integer number = 1000;

        System.out.println(findSmallestSetOfIntegersResultingSum(number));
    }

    private static Integer findSmallestSetOfIntegersResultingSum(Integer number) {

        List<Integer> numbersList = getNumbersList(number);
        Integer requiredSum = getSumOfList(numbersList);
        int sum = 0;

        while(sum != requiredSum) {
            number ++;
            numbersList = getNumbersList(number);
            sum = getSumOfList(numbersList);
        }

        return number;
    }

    private static Integer getSumOfList(List<Integer> numbersList) {

        return numbersList.stream()
                .reduce(0, Integer::sum);
    }

    private static List<Integer> getNumbersList(Integer number) {

        List<Integer> numbersList = new ArrayList<>();
        while (number > 0) {
            numbersList.add(number % 10);
            number = number / 10;
        }

        return numbersList;
    }
}
