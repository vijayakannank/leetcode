package array;

public class EvenNoSquare {
    public static void main(String[] args) {
        int[] arr = {9, -2, -9, 11, 56, -12, -3};
        evenSquare(arr);
        System.out.println("");
    }

    static void evenSquare(int[] arr){
        for(int i=0; i<arr.length; i +=2){
            arr[i] *= arr[i];
        }
    }
}
