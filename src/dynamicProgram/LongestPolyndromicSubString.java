package dynamicProgram;

import java.util.HashMap;
import java.util.Map;

public class LongestPolyndromicSubString {

    public static void main(String[] args) {
        String s = "ABBDCACB";
        StringBuilder sb = new StringBuilder(s);
        sb.reverse().toString();
        System.out.println(findString(s, 0, s.length()-1, new HashMap<>()));
    }

    static String findString(String s, int i, int j, Map<String, String> map){
        if(i>j)
            return "";
        if(i == j)
            return ""+s.charAt(i);
        String key = i+"-"+j;
        if(!map.containsKey(key)){
            if(s.charAt(i) == s.charAt(j))
                map.put(key, s.charAt(i)+findString(s, i+1, j-1, map)+s.charAt(j));
            else{
                String s1 = findString(s, i+1, j, map);
                String s2 = findString(s, i, j-1, map);
                map.put(key, s1.length() > s2.length() ? s1: s2);
            }

        }
        return map.get(key);
    }

    static int findLength(String s, int i, int j, Map<String, Integer> map){
        if(i>j)
            return 0;
        if(i == j)
            return 1;
        String key = i+"-"+j;
        if(!map.containsKey(key)){
            if(s.charAt(i) == s.charAt(j))
                map.put(key, findLength(s, i+1, j-1, map)+2);
            else
                map.put(key, Math.max(findLength(s, i+1, j, map), findLength(s, i, j-1, map)));
        }
        return map.get(key);
    }
}
