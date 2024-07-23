package dynamicProgram;

public class MaximumSumIncreasingSubsequence {

    public static void main(String[] args) {
        int[] arr = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 1};
        System.out.println(find(arr));
    }

    static int find(int[] arr){
        if(arr == null || arr.length == 0)
            return 0;
        if(arr.length == 1)
            return arr[0];
        int[] dp = new int[arr.length];
        for(int i=0; i<arr.length; i++){
            dp[i] = arr[i];
        }
        int max = dp[0];
        for(int i = 1; i< arr.length; i++){
            for(int j=0; j<i; j++){
                if(arr[i] > arr[j] && dp[i] < dp[j]+arr[i]){
                    dp[i] = dp[j]+arr[i];
                    max = Math.max(max, dp[i]);
                }

            }
        }
        return max;
    }
}
