package array;

public class SumofSubarrayRanges {

    public static void main(String[] args) {
        int[] arr = {1,2,3};
        new SumofSubarrayRanges().subArrayRanges(arr);
    }

    long subArrayRanges(int[] nums) {
        int result = 0;

        for(int i =0; i<nums.length; i++){
            int max = Integer.MAX_VALUE;
            int min = Integer.MIN_VALUE;

            for(int j = i;j< nums.length; j++){
                min = Integer.min(nums[j], min);
                max = Integer.max(nums[j], max);

                result += (max-min);

            }
        }

        return result;

    }
}
