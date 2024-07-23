package matrix;

public class KnightMove {


    int move =0;
    boolean isSafe(int[][] arr, int i, int j){
        return i >=0 && j >=0 && i <arr.length && j <arr.length && arr[i][j] != -1;
    }

//    void dfs()
}
