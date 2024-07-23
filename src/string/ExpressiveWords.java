package string;

/**
 * Sometimes people repeat letters to represent extra feeling. For example:
 *
 * "hello" -> "heeellooo"
 * "hi" -> "hiiii"
 * In these strings like "heeellooo", we have groups of adjacent letters that are all the same: "h", "eee", "ll", "ooo".
 *
 * You are given a string s and an array of query strings words. A query word is stretchy if it can be made to be equal to s by any number of applications of the following extension operation: choose a group consisting of characters c, and add some number of characters c to the group so that the size of the group is three or more.
 *
 * For example, starting with "hello", we could do an extension on the group "o" to get "hellooo", but we cannot get "helloo" since the group "oo" has a size less than three. Also, we could do another extension like "ll" -> "lllll" to get "helllllooo". If s = "helllllooo", then the query word "hello" would be stretchy because of these two extension operations: query = "hello" -> "hellooo" -> "helllllooo" = s.
 * Return the number of query strings that are stretchy.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "heeellooo", words = ["hello", "hi", "helo"]
 * Output: 1
 * Explanation:
 * We can extend "e" and "o" in the word "hello" to get "heeellooo".
 * We can't extend "helo" to get "heeellooo" because the group "ll" is not size 3 or more.
 * Example 2:
 *
 * Input: s = "zzzzzyyyyy", words = ["zzyy","zy","zyy"]
 * Output: 3
 *
 * https://leetcode.com/problems/expressive-words/
 */

public class ExpressiveWords {

    public static void main(String[] args) {
        new ExpressiveWords().expressiveWords("heeellooo", new String[]{"hello", "hi", "helo"});
    }

    int expressiveWords(String s, String[] words) {
        int stretchy = 0;
        for (String word : words) {
            if (isStretchy(s, word)) stretchy++;
        }
        return stretchy;
    }

    public boolean isStretchy(String s, String word) {
        int si = 0, wi = 0, wlen = word.length(), slen = s.length();
        while (si < slen && wi < wlen) {
            int scount = 0, wcount = 0;

            if (s.charAt(si) != word.charAt(wi)) return false;

            char c = word.charAt(wi);
            // Keep itearting both the strings from the starting character matched as long as the same character repeats
            // and keep counting the occurences of char c in both
            while (wi < wlen && word.charAt(wi) == c) {
                wi++; wcount++;
            }
            while (si < slen && s.charAt(si) == c) {
                si++; scount++;
            }

            if (scount < 3 && scount != wcount || scount >= 3 && scount < wcount) return false;
        }
        // True - only if we have passed all the characters till the end
        return si == slen && wi == wlen;
    }
}
