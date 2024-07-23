package binarySearcg;

public class MinInRotatedSortedArray {

    public static void main(String[] args) {
        int[] arr = {6,1,2,3,4,5};
        System.out.println(findMin(arr));
    }

    static int findMin(int[] arr){
        if(arr.length == 0) return 0;
        if(arr.length == 1) return arr[0];
        int start = 0;
        int end = arr.length-1;

        while (start <= end){
            int mid = start+ (end-start)/2;
            // {6,1,2,3,4,5}
            if(mid > 0 && arr[mid] < arr[mid-1]) {
                return arr[mid];
            } else if(arr[start] <= arr[mid] && arr[mid] > arr[end]){
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
        return arr[start];
    }
}
//[4,5,6,1,2]