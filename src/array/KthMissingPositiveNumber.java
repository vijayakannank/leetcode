package array;

import java.util.*;

/**
 * Given an array arr of positive integers sorted in a strictly increasing order, and an integer k.
 *
 * Return the kth positive integer that is missing from this array.
 *
 *
 *
 * Example 1:
 *
 * Input: arr = [2,3,4,7,11], k = 5
 * Output: 9
 * Explanation: The missing positive integers are [1,5,6,8,9,10,12,13,...]. The 5th missing positive integer is 9.
 */

public class KthMissingPositiveNumber {

    public static void main(String[] args) {
        findKthPositive(new int[]{2,3,4,7,11}, 5);

    }
    static  int findKthPositive(int[] arr, int k) {
        if(arr == null || arr.length ==0 )
            return k;
        int i=1;
        int index = 0;
        int mn = 0;

        while(mn < k){
            while(index < arr.length && i == arr[index]) {
                index++;
                i++;
            }
            mn++;
            if(mn == k)
                return i;
            i++;
        }
        return 0;
    }

    int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for(Integer i : nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>((n1, n2) -> n1.equals(n2) ? n2.compareTo(n1) : n1-n2);

        for(Integer i: map.keySet()){
            queue.add(i);
        }



        int[] result = new int[nums.length];
        int index = 0;

        while(!queue.isEmpty()){
            int key = queue.poll();
            for(int i=0; i<map.get(key); i++){
                result[index++] = key;
            }
        }
        return result;
    }

    int numIdenticalPairs(int[] nums) {
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        for(int i: nums){
            map.put(i, map.getOrDefault(i,0)+1);
        }

        int result = 0;
        for(Integer i: map.keySet()){
            Integer n = map.get(i);
            if(n > 1){
                result += n*(n-1)/2;
            }
        }
        return result;
    }
}
