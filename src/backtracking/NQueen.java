package backtracking;

import java.util.List;

public class NQueen {

    static int N = 4;
    public static void main(String[] args) {
        NQueen q = new NQueen();
        int[][] arr = new int[N][N];
        q.solve(arr, 0);
        for(int[] row: arr){
            for(int i: row){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }

    boolean isSafe(int[][] arr, int row, int col){
        for(int i=0; i< col; i++){
            if(arr[row][i] ==1 )
                return false;
        }

        for(int i = row, j = col; i >=0 && j >=0 ; i--, j--){
            if(arr[i][j] == 1)
                return false;
        }

        for(int i = row, j = col; i < N && j >=0 ; i++, j--){
            if(arr[i][j] == 1)
                return false;
        }
        return true;
    }

     boolean solve(int[][] arr,int col){
        if(col == N)
            return true;
        for(int i=0; i<N; i++){
            if(isSafe(arr, i, col)){
                arr[i][col] = 1;
                if(solve(arr, col+1))
                    return true;
                arr[i][col] = 0;
            }

        }
        return false;
    }


}
