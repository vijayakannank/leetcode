package StringProblems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LetterCombinationOfPhone {

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }

    static List<String> letterCombinations(String digits) {
        LinkedList<String> result = new LinkedList<>();
        if(digits.isEmpty())
            return result;
        result.add("");
        String[] arr = {
                "",
                "",
                "abc",
                "def",
                "ghi",
                "jkl",
                "mno",
                "pqrs",
                "tuv",
                "wxyz"
        };

        for(int i = 0; i<digits.length();i++){
            int index = Character.getNumericValue(digits.charAt(i));
            while (result.peek().length() == i) {
                String permudation = result.remove();
                for(char c: arr[index].toCharArray()){
                    result.add(permudation+c);
                }
            }
        }

        return result;
    }
}
