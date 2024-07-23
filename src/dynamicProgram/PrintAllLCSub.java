package dynamicProgram;

import java.util.*;

public class PrintAllLCSub {

    void fillLookup(String str1, String str2, int m, int n, int[][] lookup){
        for(int i =1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if(str1.charAt(i-1) == str2.charAt(j-1))
                    lookup[i][j] = lookup[i-1][j-1]+1;
                else
                    lookup[i][j] = Math.max(lookup[i-1][j], lookup[i][j-1]);
            }
        }
    }
    List<String> lcs(String str1, String str2, int m, int n, int[][] lookup){
        if(m ==0 || n==0)
            return new ArrayList<>(Arrays.asList(""));
        if(str1.charAt(m-1) == str2.charAt(n-1)){
            List<String> list = lcs(str1, str2, m-1,n-1,lookup);
            for(int i=0; i<list.size(); i++){
                list.set(i, list.get(i)+str1.charAt(m-1));
            }
            return list;
        }
        if(lookup[m-1][n] > lookup[m][n-1])
            return lcs(str1, str2, m-1, n, lookup);
        else if(lookup[m][n-1] > lookup[m-1][n])
            return lcs(str1,str2, m, n-1, lookup);
        List<String> top = lcs(str1, str2, m-1, n, lookup);
        List<String> left = lcs(str1, str2, m, n-1, lookup);
        top.addAll(left);
        return top;
    }

    public static void main(String[] args)
    {
        String X = "ABCBDAB", Y = "BDCABA";
        int m = X.length();
        int n = Y.length();
        PrintAllLCSub demo = new PrintAllLCSub();
        int[][] lookup = new int[m+1][n+1];
        demo.fillLookup(X, Y, m, n, lookup);
        System.out.println(new HashSet<>(demo.lcs(X,Y, m, n, lookup)));
    }

}
