package dailyByte.array;

import java.util.Arrays;

public class MoveZeros {
    public static void main(String[] args) {
        int[] arr = new int[]{0,0,1,3,12};
        moveZeroes(arr);
        Arrays.stream(arr).forEach(System.out::println);

    }

    static void moveZeroes(int[] nums) {

        int j=0;
        for(int i=0; i<nums.length; i++){

            if(nums[i]!=0)

            {
                int temp = nums[j];                       //swapping
                nums[j] = nums[i];
                nums[i]=  temp;
                j++;
            }
        }

    }

}
