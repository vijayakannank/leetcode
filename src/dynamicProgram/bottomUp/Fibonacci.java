package dynamicProgram.bottomUp;

public class Fibonacci {

    public static void main(String[] args) {
        System.out.println(find(7));
    }

    static int find(int n){
        if(n<1) return 0;

        int[] dp = new int[n+1];
        dp[1] = 1;

        for( int i =2; i<=n;i++){
            dp[i] = dp[i-1] +dp[i-2];
        }
        return dp[n];
    }
}
