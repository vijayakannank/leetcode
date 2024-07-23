package dynamicProgram;

public class PrintLcs {

    // Function to fill the lookup table by finding the length of LCS
    // of substring `X[0…m-1]` and `Y[0…n-1]`
    public static void LCSLength(String X, String Y, int m, int n, int[][] lookup)
    {
        for(int i=1; i<=m;i++){
            for(int j=1; j<=n; j++){
                if(X.charAt(i-1) == Y.charAt(j-1))
                    lookup[i][j] = lookup[i-1][j-1]+1;
                else
                    lookup[i][j] = Math.max(lookup[i-1][j], lookup[i][j-1]);
            }
        }
    }
    static String lcs(String s1, String s2, int m, int n, int[][] arr){
        if(m==0 || n==0)
            return "";
        if(s1.charAt(m-1) == s2.charAt(n-1))
            return lcs(s1, s2, m-1, n-1, arr)+s1.charAt(m-1);
        if( arr[m-1][n]> arr[m][n-1])
            return lcs(s1, s2, m-1, n,arr);
        else
            return lcs(s1,s2, m,n-1,arr);
    }
    public static void main(String[] args)
    {
        String X = "XMJYAUZ", Y = "MZJAWXU";
        int m = X.length(), n = Y.length();

        // lookup[i][j] stores the length of LCS of substring `X[0…i-1]` and `Y[0…j-1]`
        int[][] lookup = new int[m + 1][n + 1];

        // fill lookup table
        LCSLength(X, Y, m, n, lookup);
        System.out.println(lcs(X,Y,m, n,lookup));

        // find the longest common subsequence
//        System.out.println(LCS(X, Y, m, n, lookup));
    }
}
