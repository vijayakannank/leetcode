package dynamicProgram;

public class LargestSquareMatrix {

    public static void main(String[] args) {
        int mat[][] =
                {
                        { 0, 0, 1, 0, 1, 1 },
                        { 0, 1, 1, 1, 0, 0 },
                        { 0, 0, 1, 1, 1, 1 },
                        { 1, 1, 0, 1, 1, 1 },
                        { 1, 1, 1, 1, 1, 1 },
                        { 1, 1, 0, 1, 1, 1 },
                        { 1, 0, 1, 1, 1, 1 },
                        { 1, 1, 1, 0, 1, 1 }
                };
        System.out.println(findLargest(mat));
    }

    static int findLargest(int[][] arr){
        int result = 0;
        int m = arr.length;
        int n = arr[0].length;
        int[][] dp = new int[m+1][n+1];
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if(arr[i-1][j-1] == 1){
                    dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1]))+1;
                    result = Math.max(result, dp[i][j]);
                }

            }
        }

        return result;
    }
}
