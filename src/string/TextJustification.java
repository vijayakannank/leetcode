package string;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of strings words and a width maxWidth, format the text such that each line has exactly maxWidth characters and is fully (left and right) justified.
 *
 * You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.
 *
 * Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line does not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
 *
 * For the last line of text, it should be left-justified, and no extra space is inserted between words.
 *
 * Note:
 *
 * A word is defined as a character sequence consisting of non-space characters only.
 * Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
 * The input array words contains at least one word.
 *
 *
 * Example 1:
 *
 * Input: words = ["This", "is", "an", "example", "of", "text", "justification."], maxWidth = 16
 * Output:
 * [
 *    "This    is    an",
 *    "example  of text",
 *    "justification.  "
 * ]
 * Example 2:
 *
 * Input: words = ["What","must","be","acknowledgment","shall","be"], maxWidth = 16
 * Output:
 * [
 *   "What   must   be",
 *   "acknowledgment  ",
 *   "shall be        "
 * ]
 * Explanation: Note that the last line is "shall be    " instead of "shall     be", because the last line must be left-justified instead of fully-justified.
 * Note that the second line is also left-justified because it contains only one word.
 *
 * https://leetcode.com/problems/text-justification/
 */
public class TextJustification {

    public static void main(String[] args) {
        String[] arr = {"This", "is", "an", "example", "of", "text", "justification."};
        new TextJustification().fullJustify(arr, 16);
    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        int len = words.length;
        List<String> mList = new ArrayList<>();
        for(int i = 0; i< len; i++) {

            int length = 0, count = 0;
            while(i<len && length+words[i].length()+(count) <= maxWidth){
                length = length+words[i].length();
                i++; count++;
            }
            int spaces, last_space;
            if(i<len){ //middle justified
                spaces = count>1 ? (maxWidth-length)/(count-1): (maxWidth-length);
                last_space = count>1 ? (maxWidth-length)%(count-1):0;
            } else { //last justified case
                spaces = 1;
                last_space = 0;
            }
            String space = "";
            while(spaces > 0) {
                space += " "; spaces--;
            }
            String res = "";
            while(count > 0) {
                res+= words[i-count]+((count>1)?space:"");
                if(last_space > 0) {
                    res+= " ";
                    last_space--;
                }
                count--;
            }
            while(res.length()<maxWidth) {
                res += " ";
            }
            mList.add(res);
            i--;
        }

        return mList;
    }
}
