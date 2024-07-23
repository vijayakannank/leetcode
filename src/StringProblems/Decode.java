package StringProblems;

// 3[a]2[bc]d -> aaabcbcd
// 3[a2[b] -> abbabbabb

import java.util.Stack;

public class Decode {

    static String decode(String str){
        Stack<Integer> counts = new Stack<>();
        Stack<String> strings = new Stack<>();
        String result = "";
        int ptr = 0;
        while(ptr < str.length()){
            char ch = str.charAt(ptr);
            if(Character.isDigit(ch)) {

            }
            else if(ch == '[') {

            }
            else if (ch == ']'){

            }
        }

        return result;
    }
}
