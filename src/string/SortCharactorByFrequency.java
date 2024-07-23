package string;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SortCharactorByFrequency {

    public static void main(String[] args) {
        System.out.println(frequencySort("Aabb"));
    }
    static String frequencySort(String s){
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> map = new HashMap<>();
        for(Character ch: s.toCharArray()){
            map.put(ch, map.getOrDefault(ch,0)+1);
        }
        PriorityQueue<Character> queue = new PriorityQueue<>((a,b) -> map.get(b) - map.get(a));
        queue.addAll(map.keySet());
        while (!queue.isEmpty()){
            char ch = queue.remove();
            for(int i = 0; i< map.get(ch); i++){
                sb.append(ch);
            }
        }

        return sb.toString();
    }
}
