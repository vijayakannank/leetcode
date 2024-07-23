package dynamicProgram.TopDown;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(fibonacci(3, new HashMap<>()));
    }

    static int fibonacci(int n, Map<Integer,Integer> map){
        if(n == 0 || n==1) return n;
        if(!map.containsKey(n))
            map.put(n, fibonacci(n-1, map)+ fibonacci(n-2, map));
        return map.get(n);
    }
}
