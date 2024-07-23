package dailyByte.stringProblems;

import java.util.Stack;

/**
 * This question is asked by Google. Given a string only containing the following characters (, ), {, }, [, and ]
 * return whether or not the opening and closing characters are in a valid order.
 */
public class ValidateCharectors {

    public static void main(String[] args) {
        String str = "(()[{}])[]";
        System.out.println(validateCharectors(str));
    }

    static boolean validateCharectors(String str) {
        boolean isValidate = true;
        Stack<Character> characters = new Stack<>();
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
           if(ch == '(' || ch == '{' || ch == '[')
               characters.push(ch);
           else if(!isValidCh(characters, ch))
               return false;
        }
        return isValidate;
    }
    static boolean isValidCh(Stack<Character> characters, char currentCh) {
        if(characters.isEmpty()) return false;
        boolean isValid;
        char ch = characters.pop();
        switch (currentCh) {
            case ')' :  isValid = '(' == ch;
            break;
            case ']' : isValid = '[' == ch;
            break;
            case '}' : isValid = '{' == ch;
            break;
            default: isValid = false;
        }
        return isValid;
    }
}
