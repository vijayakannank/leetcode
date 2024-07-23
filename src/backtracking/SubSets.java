package backtracking;

import java.util.*;

public class SubSets {
    public static void main(String[] args) {
        int[] arr = {4,4,4,1,4};
        System.out.println(subsets(arr));
    }

    static List<List<Integer>> subsets(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
//        Arrays.sort(nums);
        generate(nums, new ArrayList<>(), result,0);
        System.out.println(result.size());
        return result;
    }

    static void generate(int[] nums, List<Integer> list, List<List<Integer>> result, int index){
        if(!result.contains(list))
            result.add(new ArrayList<>(list));
        for(int i=index;  i<nums.length; i++){
            list.add(nums[i]);
            generate(nums, list, result,i+1);
            list.remove(list.size()-1);
        }
    }
}
