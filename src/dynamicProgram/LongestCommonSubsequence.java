package dynamicProgram;

import java.util.Collections;
import java.util.List;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
//        LongestCommonSubsequence ls = new LongestCommonSubsequence();
////        System.out.println(ls.longestCommonSubsequence("abcde", "ace" ));
//        String s1 = "ABCBDAB",  s2 = "BDCABA";
//        System.out.println(ls.longestSubSquences(s1, s2, s1.length()-1, s2.length()-1 ));

        List<String> list = Collections.nCopies(4, "GeeksforGeeks");
        System.out.println(list);

    }

//    public int longestCommonSubsequence(String str1, String str2) {
//        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
//
//        for(int i = str1.length() - 1; i >= 0; i--){
//            for(int j = str2.length() - 1; j >= 0; j--){
//                if(str1.charAt(i) == str2.charAt(j))
//                    dp[i][j] = dp[i+1][j+1] + 1;
//                else
//                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j+1]);
//            }
//        }
//        return dp[0][0];
//    }

    int longestSubSquences(String s1, String s2, int m, int n){
        if(m <0 || n<0)
            return 0;
        if(s1.charAt(m) == s2.charAt(n))
            return longestSubSquences(s1, s2, m-1, n-1)+1;
        return Integer.max(longestSubSquences(s1, s2, m-1, n),
                longestSubSquences(s1, s2, m, n-1));
    }
}
