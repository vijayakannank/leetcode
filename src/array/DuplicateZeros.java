package array;

public class DuplicateZeros {

    public static void main(String[] args) {
        int[] arr = {1,0,2,3,0,4,5,0};
        duplicateZeros(arr);
        System.out.println(arr);
    }

    static void duplicateZeros(int[] arr) {

        //  Loop through the array
        for(int i = 0; i < arr.length; i++) {

            //  Trigger Condition
            if(arr[i] ==0) {
                int j;      // auxilliary variable for swapping
                for(j = arr.length-2; j>=i; j--) {
                    arr[j+1] = arr[j];      //  Shift each element by one space
                }

                i++;
            }
        }
    }
}
