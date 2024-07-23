package dynamicProgram;

public class LongestCommonSubstring {

    public static void main(String[] args) {
        LongestCommonSubstring ls = new LongestCommonSubstring();
        System.out.println(ls.longestLength("ABC", "ABCAB"));
    }


    String longestLength(String s1, String s2){
        int m = s1.length(),  n=s2.length();
        int[][] dp = new int[m+1][n+1];
        int max = 0;
        int endingIndex = 0;
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if(s1.charAt(i-1) ==  s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                    if(dp[i][j] > max){
                        max = dp[i][j];
                        endingIndex = i;
                    }
                }
                else
                    dp[i][j] = 0;
            }
        }
        return s1.substring(endingIndex-max, endingIndex);
    }
}
