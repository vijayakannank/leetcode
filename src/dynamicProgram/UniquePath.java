package dynamicProgram;


// find the unique path of  m*n, u can move only right or down
public class UniquePath {

    public static void main(String[] args) {
        System.out.println(findUniquePath(3,4));
    }


    static int findUniquePath(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i =0; i<dp.length; i++){
            dp[i][0] = 1;
        }
        for( int i =0; i<dp[0].length; i++){
            dp[0][i] = 1;
        }
        for(int i =1; i<dp.length; i++){
            for(int j= 1; j<dp[i].length; j++) {
                dp[i][j] = dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}
