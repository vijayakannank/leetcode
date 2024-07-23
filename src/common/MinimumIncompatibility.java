package common;

import java.util.*;

public class MinimumIncompatibility {

    public static void main(String[] args) {
        int[] arr = {4,2,1,1};
        minimumIncompatibility(arr, 2);
    }

    static  public int minimumIncompatibility(int[] nums, int k) {
        if(nums.length %k != 0)
            return -1;
        Map<Integer, Integer> map = new TreeMap<>();

        for(Integer i : nums){
            if(map.get(i) != null && map.get(i) == k)
                return -1;
            map.put(i, map.getOrDefault(i,0)+1);
        }
        Set<Integer> keys = map.keySet();
        List<Integer> list = new ArrayList<>();
        while(keys.size() >= k){
//            int sum =
        }
        return 0;
    }
}
