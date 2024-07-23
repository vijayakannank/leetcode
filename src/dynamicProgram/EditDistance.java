package dynamicProgram;

public class EditDistance {

    public static void main(String[] args) {
        System.out.println(edit("intention", "execution"));
    }
    static int edit(String str1, String str2){
        int m = str1.length();
        int n = str2.length();
        int[][] dp = new int[m+1][n+1];
        for(int i=0; i<m; i++)
            dp[i][0] = i;

        for(int i=0; i<n; i++)
            dp[0][i] = i;

        for(int i=1; i<= m; i++){
            for(int j=1; j<=n; j++){
                if(str1.charAt(i-1) == str2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1];
                else
                    dp[i][j]= Math.min(dp[i-1][j], Math.min(dp[i-1][j-1], dp[i][j-1]))+1;
            }
        }
        return dp[m][n];
    }
}
