package dynamicProgram;

import java.util.HashMap;
import java.util.Map;

public class ZeroOneKnapsackProblem {
    public static void main(String[] args) {
        int[] value = {20, 5, 10, 40, 15, 25};
        int[] weight = {1, 2, 3, 8, 7, 4 };
        System.out.println(
                knapsack(value, weight, value.length-1, 10, new HashMap<>())
        );
    }

    static int knapsack(int[] v, int[] w, int n, int W, Map<String, Integer> map){
        if(W < 0 )
            return Integer.MIN_VALUE;
        if(n <0 || W == 0)
            return 0;
        String key = n+"-"+W;
        if(!map.containsKey(key)){
            map.put(key,
                    Math.max(v[n]+knapsack(v, w, n-1, W-w[n], map),
                            knapsack(v, w, n-1, W, map)
                    )
            );
        }

        return map.get(key);


    }
}
