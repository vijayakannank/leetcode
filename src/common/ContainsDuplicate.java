package common;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public static void main(String[] args) {
        containsDuplicate(new int[]{1,2,3,1});
    }

   static boolean containsDuplicate(int[] nums) {
        if(nums == null || nums.length ==0) return false;

        Set<Integer> set = new HashSet<>();
        for(Integer i: nums){
            if(set.contains(i))
                return true;
            else
                set.add(i);
        }

        return false;

    }
}
