package backtracking;


/**
 * fill the cells with below criteria
 * Each column contains all of the digits from 1 to 9 only once.
 * Each row contains all of the digits from 1 to 9 only once.
 * Each of the nine 3×3 sub-grid contains all of the digits from 1 to 9 only once.
 */
public class Soduku {
    public static void main(String[] args) {

        int[][] arr = {
                {5,3,0,0,7,0,0,0,0},
                {6,0,0,1,9,5,0,0,0},
                {0,9,8,0,0,0,0,6,0},
                {8,0,0,0,6,0,0,0,3},
                {4,0,0,8,0,3,0,0,1},
                {7,0,0,0,2,0,0,0,6},
                {0,6,0,0,0,0,2,8,0},
                {0,0,0,4,1,9,0,0,5},
                {0,0,0,0,8,0,0,7,9}

        };
        boolean result = helper(new int[9][9]);
        System.out.println(result);
    }

    static boolean helper(int[][] arr){
        for(int i=0; i< arr.length; i++){
            for(int j=0; j< arr[0].length; j++){
                if(arr[i][j] == 0){
                    for(int k=1; k< 10; k++){
                        if(isSafe(arr, i, j, k)){
                           arr[i][j] = k;
                           if(helper(arr))
                               return true;
                           arr[i][j] = 0;
                        }

                    }
                    return false;
                }
            }
        }
        return true;
    }
    static boolean isSafe(int[][] arr, int i, int j, int val){
        int count = 0;
        for(int k =0; k< arr.length; k++){
            if(arr[k][j] == val)
                count++;
            if(arr[i][k] == val)
                count++;
            if(arr[3*(i/3)+k/3][3*(j/3)+k%3] == val )
                count++;
        }
        return count == 0;
    }
}
