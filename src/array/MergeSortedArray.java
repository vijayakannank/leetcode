package array;

/**
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
 *
 * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
 *
 * The final sorted array should not be returned by the function, but instead be stored inside the array nums1.
 * To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be
 * merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
 *
 * Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * Output: [1,2,2,3,5,6]
 * Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
 * The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
 *
 * https://leetcode.com/problems/merge-sorted-array/
 */


public class MergeSortedArray {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        merge(nums1, 3, nums2,3);
    }

    static void merge(int[] nums1, int m, int[] nums2, int n) {

        if(n == 0){
            return;
        }
        if(m == 0){
            for(int i =0; i<n; i++){
                nums1[i] = nums2[i];
            }
        }
        int p1 = m - 1;
        int p2 = n - 1;
        for (int i = nums1.length - 1; i >= 0; i--) {
            if(p1 < 0 || p2 >= 0 && nums2[p2] >= nums1[p1]) nums1[i] = nums2[p2--];
            else nums1[i] = nums1[p1--];
        }
    }
}
