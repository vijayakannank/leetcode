package array;

import java.util.ArrayList;
import java.util.List;

public class MissingRange {

    public static void main(String[] args) {
        findMissingRange(new int[]{0, 1,3,50,75},0,75);

    }

    static List<String> findMissingRange(int[] arr, int low, int high){
        List<String> result = new ArrayList<>();

        int index = 0;
        int start = arr[index++];
        int end = arr[index++];
        for(int i= low+1; i<=high; i++){
            if(i == end ){
                if(start+1 != end && end-2 != start)
                    result.add((start + 1) + "->" + (end - 1));

                else if(start+1 != end)
                    result.add((start + 1)+"");
                start = end;
                if(index < arr.length)
                    end = arr[index++];

            }
        }
        return result;
    }
}
