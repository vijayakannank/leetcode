package array;

/**
 * Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [-4,-1,0,3,10]
 * Output: [0,1,9,16,100]
 * Explanation: After squaring, the array becomes [16,1,0,9,100].
 * After sorting, it becomes [0,1,9,16,100].
 * Example 2:
 *
 * Input: nums = [-7,-3,2,3,11]
 * Output: [4,9,9,49,121]
 * https://leetcode.com/problems/squares-of-a-sorted-array/description/
 */
public class SortedSquares {

    public static void main(String[] args) {
        int[] arr = {-1};
        sortedSquares(arr);
    }

    static int[] sortedSquares(int[] nums) {
        if(nums == null )
            return nums;

        int n = nums.length;
        int[] arr = new int[n];
        int j = 0;
        int index = 0;

        while(j<n && nums[j]<0){
            j++;
        }
        int i = j-1;
        while(i >=0 && j<n){
            if(nums[j] >= Math.abs(nums[i])){
                arr[index++] = nums[i]*nums[i--];
            } else {
                arr[index++] = nums[j]* nums[j++];
            }
        }
        while (i>=0){
            arr[index++] = nums[i]*nums[i-1];
        }
        while (j<n){
            arr[index++]= nums[j]*nums[j++];
        }
        return arr;
    }
}
