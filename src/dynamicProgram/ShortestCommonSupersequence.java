package dynamicProgram;

// Given two strings str1 and str2, return the shortest string that has both str1 and str2 as subsequences
public class ShortestCommonSupersequence {

    public static void main(String[] args) {
        ShortestCommonSupersequence scs = new ShortestCommonSupersequence();
        String str1 = "abac", str2 = "cab";
        System.out.println(getSubSeq(str1, str2, str1.length(), str2.length()));
    }

    static String getSubSeq(String s1, String s2, int n , int m){
        int[][] dp = new int[n+1][m+1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m ; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        StringBuilder sb1 = new StringBuilder();

        int i = n, j = m;

        while(i > 0 && j > 0){
            if (s1.charAt(i-1) == s2.charAt(j-1)){
                sb1.append(s1.charAt(i-1));
                i--;
                j--;
            }else{
                if (dp[i-1][j] > dp[i][j-1]){
                    sb1.append(s1.charAt(i-1));
                    i--;
                }else{
                    sb1.append(s2.charAt(j-1));
                    j--;
                }
            }
        }

        while( i > 0){
            sb1.append(s1.charAt(i-1));
            i--;
        }
        while( j > 0){
            sb1.append(s2.charAt(j-1));
            j--;
        }
        return sb1.reverse().toString();
    }
}