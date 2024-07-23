package dynamicProgram;

import java.util.HashMap;
import java.util.Map;

public class PrintLCSubSeq {

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

    String lcs(String str1, String str2, int m, int n, int[][] lookup, Map<String, String> map){
        if(m ==0 || n ==0)
            return "";
        String key = m+"-"+n;
        if(!map.containsKey(key)){
            if(str1.charAt(m-1) == str2.charAt(n-1))
                map.put(key, lcs(str1, str2, m-1, n-1, lookup, map)+str1.charAt(m-1));
            if(lookup[m-1][n] > lookup[m][n-1])
                map.put(key, lcs(str1, str2, m-1,n, lookup, map));
            else
                map.put(key, lcs(str1, str2, m, n-1, lookup, map));
        }
        return map.get(key);
    }

    public static void main(String[] args)
    {
        String X = "ABCBDAB", Y = "BDCABA";
        int m = X.length();
        int n = Y.length();
        PrintLCSubSeq demo = new PrintLCSubSeq();
        int[][] lookup = new int[m+1][n+1];
        demo.fillLookup(X, Y, m, n, lookup);
        System.out.println(demo.lcs(X,Y, m, n, lookup, new HashMap<>()));
    }
}
