package practise;

public class SmallerThanCurrent {
    public int[] smallerNumbersThanCurrent(int[] nums) {

        int[] output = new int[nums.length];
        int count =0;
        for(int a =0; a<nums.length;a++) {
            for(int b =0;b<nums.length && b!=a;b++) {
                if(nums[b] < nums[a]) {
                    count ++;
                }
            }
            output[a] = count;
        }
        return output;
    }
}
