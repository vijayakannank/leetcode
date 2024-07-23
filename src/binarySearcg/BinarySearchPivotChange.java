package binarySearcg;

//  ex [1,2,3,4,5,6,7] might
//  become [4,5,6,7,0,1,2,3,4]
public class BinarySearchPivotChange {

    public static void main(String[] args) {
        int[] arr = {5, 6, 7, 8, 9, 10, 1, 2, 3};
        search(arr, 3);
    }

    public static int search(int[] nums, int target) {

        int low = 0;
        int high = nums.length-1;

        while(low<=high){
            int mid = low+(high-low)/2;

            if(nums[mid] == target)
                return mid;
            if(nums[low] <= nums[mid] ) {
                if(nums[low] <=target && nums[mid] > target)
                    high = mid-1;
                else
                    low = mid+1;

            }
            else {
                if(nums[mid] <target && nums[high] >=target){
                    low = mid+1;
                } else
                    high = mid-1;
            }

        }
        return -1;
    }
}
