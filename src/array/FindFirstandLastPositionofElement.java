package array;

public class FindFirstandLastPositionofElement {

    public static void main(String[] args) {
        searchRange(new int[]{5,7,7,8,8,10}, 8);
    }

    static int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int[] result = {-1,-1};

        int low = 0;
        int high = nums.length-1;

        while(low<=high){
            int mid = low+(high-low)/2;
            if(nums[mid] == target){
                int tmp = mid;
                while(mid+1 < n && nums[mid+1] == nums[mid])
                    mid = mid+1;
                result[1] = mid;

                mid = tmp;
                while(mid-1 >=0  && nums[mid-1] == nums[mid])
                    mid = mid-1;
                result[0] = mid;
                return result;
            }

            else if(nums[mid] < target)
                low = mid+1;
            else
                high = mid-1;
        }

        return result;
    }
}
