package dynamicProgram.TopDown;

import java.util.HashMap;
import java.util.Map;

public class HouseRobber {

    public static void main(String[] args) {
        int[] arr = {1,2,3,8};
        System.out.println(rob(arr, new HashMap<Integer, Integer>(), arr.length-1));
    }

    static int rob(int[] arr, Map<Integer, Integer> map, int n){
        if(n == 0)
            return arr[0];
        if(n ==1 )
            return Math.max(arr[0], arr[1]);
        if(!map.containsKey(n))
            map.put(n, Math.max(rob(arr, map, n-1), rob(arr, map, n-2)+arr[n]));
        return map.get(n);
    }
}
