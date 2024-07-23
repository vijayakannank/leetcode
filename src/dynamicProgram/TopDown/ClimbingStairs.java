package dynamicProgram.TopDown;

import java.util.Map;

public class ClimbingStairs {

    int noOfWays(int n, Map<Integer, Integer> map){
        if(n<3) return n;
        if(!map.containsKey(n))
            map.put(n, noOfWays(n-1, map)+ noOfWays(n-2,map));
        return map.get(n);
    }
}
