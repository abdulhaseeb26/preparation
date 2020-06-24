package codingAlgorithms.slidingWindow;

public class SmallestSubArrayWithGivenSum {

    public static void main(String[] args) {

        int [] arr = {4,2,2,7,8,1,2,8,1,0};
        System.out.println(findSmallestDubbArrayWithGivenSum(arr, 8));
    }

    private static int findSmallestDubbArrayWithGivenSum(int[] arr, int targetSum) {

        int currentRunningSum = 0;
        int startWindow = 0;
        int minWindowSize = Integer.MAX_VALUE;
        for (int endWindow=0; endWindow < arr.length; endWindow ++) {
            currentRunningSum += arr[endWindow];

            while(currentRunningSum >= targetSum) {
                minWindowSize = Math.min(minWindowSize, endWindow - startWindow +1);
                currentRunningSum -= arr[startWindow];
                startWindow ++;
            }
        }

        return minWindowSize;


    }
}
