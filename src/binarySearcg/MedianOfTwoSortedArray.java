package binarySearcg;

public class MedianOfTwoSortedArray {

    static double findMedianSortedArrays(int[] a, int[] b) {

        double result = 0.0;
        int len1 = a.length;
        int len2 = b.length;
        if(len1 > len2)
            return findMedianSortedArrays(b,a);

        int low = 0;
        int high = a.length;
        while(low<=high){
            int mid1 = low+(high-low)/2;
            int mid2 = (len1+len2+1)/2-mid1;

            int l1 = mid1 == 0 ? Integer.MIN_VALUE : a[mid1-1];
            int r1 = mid1 == len1 ? Integer.MAX_VALUE: a[mid1];

            int l2 = mid2 == 0? Integer.MIN_VALUE : b[mid2-1];
            int r2 = mid2 == len2? Integer.MAX_VALUE: b[mid2];

            if(l1 < r2 && l2 < r1){
                if((len1+len2)%2 == 0)
                    return (Math.max(l1,l2)+Math.min(r1, r2))/2.0;
                else
                   return Math.max(l1,l2);
            }
            else if(l2 > r1)
                low = mid1+1;
            else
                high = mid1-1;
        }
        return result;

    }

    public static void main(String[] args) {
        int[] nums1 = {1,2};
        int[] nums2 = {3,4};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

}
