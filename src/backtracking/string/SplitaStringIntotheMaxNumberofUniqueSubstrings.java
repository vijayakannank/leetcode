package backtracking.string;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string s, return the maximum number of unique substrings that the given string can be split into.
 *
 * You can split string s into any list of non-empty substrings, where the concatenation of the substrings forms the original string. However, you must split the substrings such that all of them are unique.
 *
 * A substring is a contiguous sequence of characters within a string.
 *
 * https://leetcode.com/problems/split-a-string-into-the-max-number-of-unique-substrings/
 */
public class SplitaStringIntotheMaxNumberofUniqueSubstrings {
    int max = 0;

    public static void main(String[] args) {
        long n = (long)Math.pow(10, 9) + 7;

        System.out.println(n);

        String s = "ababccc";
       // new SplitaStringIntotheMaxNumberofUniqueSubstrings().maxUniqueSplit(s);
    }
    public int maxUniqueSplit(String s) {

        backtrack(s,new HashSet<String>(), 0);
        return max;
    }

    void backtrack(String s, Set<String> set, int start){
        if(s.length() == start){
            max = Math.max(max, set.size());
            return;
        }



        for(int i=start+1; i<s.length(); i++){
            String sub = s.substring(start,i);
            if(!set.contains(sub)){
                set.add(sub);
                backtrack(s, set, i );
                set.remove(sub);
            }
        }

    }
}
