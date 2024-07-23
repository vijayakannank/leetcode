package dailyByte.stringProblems;

import java.util.HashSet;
import java.util.Set;

public class FirstUniqueCharacter {

    public static void main(String[] args) {

        System.out.println(firstUniqueCharacter("thedailybyte"));
    }
    static int firstUniqueCharacter(String s){
        Set<Character> set=new HashSet<>();

        for(int i=0;i<s.length();i++){
            if(!set.contains(s.charAt(i)) && !s.substring(i + 1).contains(Character.toString(s.charAt(i))))
                return i;

            else
                set.add(s.charAt(i));
        }

        return -1;
    }
}
