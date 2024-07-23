package dailyByte.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NextGreaterElementI {

    public static void main(String[] args) {
        int[] arr1 = {4,1,2};
        int[] arr2 = {1,3,4,2};
        Arrays.stream(nextGreaterElement(arr1, arr2)).forEach(System.out::println);
    }

    static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        Map<Integer, Integer> map = new HashMap();
        for(int i =0; i<nums2.length; i++){
            map.put(nums2[i], i);
        }
        for(int i=0; i<nums1.length; i++){
            int fill   = -1;
            int startIndex = map.get(nums1[i])+1;
            for(int j = startIndex; j<nums2.length; j++){
                if(nums2[j] > nums1[i]){
                    fill = nums2[j];
                    break;
                }
            }
            result[i] = fill;

        }
       return result;
    }
}
