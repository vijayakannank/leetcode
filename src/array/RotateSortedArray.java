package array;

public class RotateSortedArray {
    public static void main(String[] args) {
        System.out.println(search(new int[]{4,5,6,7,0,1,2}, 7));
    }

    static int search(int[] nums, int target) {
        String str = "adf";

        int low =0;
        int high = nums.length-1;
        while(low <= high){
            int mid = low+(high-low)/2;
            if(nums[mid] == target)
                return mid;
            if(nums[low] <= nums[mid]){
                if(nums[low] <= target && nums[mid] > target)
                    high = mid-1;
                else
                    low = mid+1;
            }
            else {
                if(nums[mid] < target && nums[high] >= target)
                    low = mid+1;

                else
                    high = mid-1;
            }
        }

        return -1;
    }
}
