package backtracking;

import java.util.HashMap;
public class NumberCombination4 {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        System.out.println(new NumberCombination4().combinationSum4(arr, 4));
    }
    int combinationSum4(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap();
        return combo(nums, target, map);
    }

    public int combo(int[] nums, int target, HashMap<Integer, Integer> map) {
        if (map.containsKey(target)) return map.get(target);
        if (target == 0) return 1;
        if (target < 0) return 0;

        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            count += combo(nums, target - nums[i], map);
        }
        map.put(target, count);
        return map.get(target);
    }
}
