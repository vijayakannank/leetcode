package array;

import java.util.HashMap;
import java.util.Map;

public class ContiguousBinaySubArray {

    public static void main(String[] args) {
        int[] arr = {0,0,1,1,0,0,0,1,1,1};
        System.out.println(findMaxLength(arr));
    }
    static int findMaxLength(int[] nums) {
        int result =0;
        int sum =0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);
        for(int i=0;i<nums.length; i++){
            sum += nums[i] == 1 ? 1: -1;
            if(map.containsKey(sum))
                result = Math.max(result, i-map.get(sum));
            else
                map.put(sum, i);
        }
        return result;
    }
}
