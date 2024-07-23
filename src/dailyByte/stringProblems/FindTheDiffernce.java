package dailyByte.stringProblems;

import java.util.HashMap;
import java.util.Map;

public class FindTheDiffernce {
    public static void main(String[] args) {
        char a = 97;
        System.out.println(a);
       // System.out.println(findTheDifference("a","aa"));
    }

    static char findTheDifference(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for(char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }

        for(char ch: t.toCharArray()){
            if(!map.containsKey(ch) || map.get(ch) == 0)
                return ch;
            else
                map.put(ch, map.get(ch)-1);
        }
        return '|';

    }
}
