package backtracking;

import java.util.*;

/**
 * Given a string s, you can transform every letter individually to be lowercase or uppercase to create another string.
 *
 * Return a list of all possible strings we could create. Return the output in any order.
 *
 *
 */

public class LetterCasePermutation {
    public static void main(String[] args) {
        LetterCasePermutation l = new LetterCasePermutation();
        l.letterCasePermutation("abc");
    }

    List<String> letterCasePermutation(String S) {
        List<String> list = new ArrayList<>();
        backtrack(S, list, 0);

        return list;
    }

    void backtrack(String s, List<String> list, int start){
        list.add(s);

        for(int i= start;i<s.length(); i++){
            if(!Character.isLetter(s.charAt(i)))
                continue;
            char c = Character.isUpperCase(s.charAt(i))?Character.toLowerCase(s.charAt(i)):Character.toUpperCase(s.charAt(i));
            backtrack(s.substring(0,i)+c+s.substring(i+1), list, i+1);
        }
    }
}

/*
Input: s = "a1b2"
Output: ["a1b2","a1B2","A1b2","A1B2"]
 */