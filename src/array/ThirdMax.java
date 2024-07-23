package array;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Given an integer array nums, return the third distinct maximum number in this array. If the third maximum does not exist, return the maximum number.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [3,2,1]
 * Output: 1
 * Explanation:
 * The first distinct maximum is 3.
 * The second distinct maximum is 2.
 * The third distinct maximum is 1.
 * Example 2:
 *
 * Input: nums = [1,2]
 * Output: 2
 * Explanation:
 * The first distinct maximum is 2.
 * The second distinct maximum is 1.
 * The third distinct maximum does not exist, so the maximum (2) is returned instead.
 * Example 3:
 *
 * Input: nums = [2,2,3,1]
 * Output: 1
 * Explanation:
 * The first distinct maximum is 3.
 * The second distinct maximum is 2 (both 2's are counted together since they have the same value).
 * The third distinct maximum is 1.
 *
 * https://leetcode.com/problems/third-maximum-number/
 */

public class ThirdMax {
    public static void main(String[] args) {
        thirdMax(new int[] {3,2,1});
    }

    static int thirdMax(int[] nums) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        if(nums == null || nums.length == 0)
            return 0;

        if(nums.length == 1)
            return nums[0];
        Arrays.sort(nums);

        int max =1;
        for(int i = nums.length-1; i>0; i--){
            if(nums[i] != nums[i-1] ) max++;
            if(max == 3)
                return nums[i-1] ;
        }
        return nums[nums.length-1];

    }
}
