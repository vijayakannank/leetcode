package matrix;

import java.util.ArrayList;
import java.util.List;

public class Spiral {
    public static void main(String[] args) {
        int[][] arr = {
                {1,2,3},
                {4,5,6},
                {7,8,9},
                {1,8,2}
        };
        Spiral s = new Spiral();
        List<Integer> result = s.traverse(arr);
        System.out.println(result);
    }

    List<Integer>  traverse(int[][] arr){
        List<Integer> result = new ArrayList<>();
        int dir =0;
        int top =0;
        int bottom = arr.length-1;
        int left = 0;
        int right = arr[0].length-1;
        while(top < arr.length && left < arr[0].length){
            if(dir == 0){
                for(int i=left; i<= right; i++){
                    result.add(arr[top][i]);
                }
                top++;
            }
            else if(dir == 1){
                for(int i = top; i<= bottom; i++){
                    result.add(arr[i][right]);
                }
                right--;
            }
            else if(dir ==2){
                for(int i= right; i >= left; i--){
                    result.add(arr[bottom][i]);
                }
                bottom--;
            }
            else if(dir == 3){
                for(int i=bottom; i>=top; i--){
                    result.add(arr[i][left]);
                }
                left++;
            }
            dir = (dir+1)%4;
        }
        return result;
    }
}
