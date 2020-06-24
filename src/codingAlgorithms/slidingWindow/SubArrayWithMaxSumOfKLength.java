package codingAlgorithms.slidingWindow;

public class SubArrayWithMaxSumOfKLength {

    public static void main(String[] args) {

        int [] arr = new int[] {4,2,1,7,8,1,2,8,1,0};
        System.out.println(maxSubArray(arr, 3));
    }


    public static int maxSubArray(int [] arr, int k) {
        int currentRunningSum=0;
        int maxSum =0;

        for (int i =0; i < arr.length; i ++) {

            currentRunningSum += arr[i];

            if (i >= k-1) {
                maxSum = Math.max(maxSum, currentRunningSum);
                currentRunningSum -= arr[i - (k - 1)];
            }

        }

        return maxSum;
    }

}
