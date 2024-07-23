package array;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class FindAllMissingNoInAnArray {

    public static void main(String[] args) {
       findKthLargest(new int[]{3,2,1,5,6,4,9},2);

    }
    static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i: nums){
            queue.add(i);
            if(queue.size() > k){
                queue.remove();
            }
        }
        return queue.remove();
    }
}
