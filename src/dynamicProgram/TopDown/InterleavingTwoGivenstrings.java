package dynamicProgram.TopDown;


import java.util.HashMap;
import java.util.Map;

/**
 * Given three strings, return true if the third string is interleaving the first and second strings, i.e., it is formed from all characters of the first and second string, and the order of characters is preserved.
 *
 * For example,
 *
 * ACDB is interleaving of AB and CD
 *
 * ADEBCF is interleaving of ABC and DEF
 *
 * ACBCD is interleaving of ABC and CD
 *
 * ACDABC is interleaving of ABC and ACD
 *
 * https://www.techiedelight.com/check-string-interleaving-two-given-strings/
 */
public class InterleavingTwoGivenstrings {



    public static boolean isInterleaving(String x, String y, String s, Map<String, Boolean> map){
        if(x.length() == 0 && y.length() == 0 && s.length() == 0)
            return true;
        if(s.length() == 0)
            return false;
        String key = x+"-"+y+"-"+s;

        if(!map.containsKey(key)){
            boolean X = x.length() > 0 && x.charAt(0) == s.charAt(0) && isInterleaving(x.substring(1), y, s.substring(1), map);
            boolean Y = y.length() > 0 && y.charAt(0) == s.charAt(0) && isInterleaving(x, y.substring(1), s.substring(1), map);
            map.put(key, X|Y);
        }


        return map.get(key);
    }


    public static void main(String[] args)
    {
        String X = "ABC";
        String Y = "DEF";
        String S = "ADEBFCe";

        if (isInterleaving(X, Y, S, new HashMap<>())) {
            System.out.print("Interleaving");
        }
        else {
            System.out.print("Given string is not interleaving of X and Y");
        }
    }
}



