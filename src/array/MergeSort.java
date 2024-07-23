package array;

import java.io.IOException;

public class MergeSort {

     static void main(String[] args) {
        try {
            throw new IOException("Hello");
        }catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }

    static int[] mergeSrt(int[] arr, int l, int r){
        if(l<r){
            int mid = (l+r)/2;
            int[] a = mergeSrt(arr, l, mid);
            int[] b = mergeSrt(arr, mid+1, r);
            return merge(a, b);
        } else {
            int[] result = new int[1];
            result[0] = arr[l];
            return result;
        }

    }
    static int[] merge(int[] l, int[] r){
        int i = l.length-1;
        int j= r.length-1;
        int k = i+j+1;
        int[] result = new int[k+1];
        while(i >= 0 && j>=0){
            if(l[i] > r[j])
                result[k--] = l[i--];
            else
                result[k--] = r[j--];
        }
        while (i>=0)
            result[k--] = l[i--];
        while (j>=0)
            result[k--] = r[j--];
        return result;
    }
}
