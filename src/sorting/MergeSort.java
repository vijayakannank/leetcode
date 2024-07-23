package sorting;

public class MergeSort {

    int[] mergeSort(int[] arr){
        int n = arr.length;
        if( n ==0 ) return new int[]{};
        if(n == 1) return arr;
        int mid = n/2;
        int[] left = new int[mid];
        int[] right = new int[n-mid];
        int ln = left.length;
        for(int i = 0; i< ln; i++)
            left[i] = arr[i];
        for(int i = 0; i< right.length; i++)
            right[i] = arr[ln+i];
        int[] la = mergeSort(left);
        int[] ra = mergeSort(right);
        return merge(la, ra);
    }

    int[] merge(int[] arr, int[] arr1){
        int i =0;
        int j=0;

        int k =0;
        int[] result = new int[arr.length+ arr1.length];

        while(i < arr.length && j < arr1.length ){
            if(arr[i] < arr1[j])


                result[k++] = arr[i++];
            else
                result[k++] = arr1[j++];
        }
        while (i<arr.length)
            result[k++] = arr[i++];
        while (j<arr1.length)
            result[k++] = arr1[j++];

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {2,4,1,5,9,8,6};
        MergeSort sort = new MergeSort();
        int[] result = sort.mergeSort(arr);
        System.out.println("completed");
    }
}
