package matrix;

import java.util.ArrayList;
import java.util.List;

public class RatInMaze {
    List<String> list= new ArrayList<>();
    public static void main(String[] args) {
        int[][] arr = {
                {1,0,0,0},
                {1,1,0,0},
                {0,1,0,0},
                {1,1,1,1},
        };
        boolean[][] isVisited = new boolean[arr.length][arr[0].length];
        RatInMaze r = new RatInMaze();
        r.dfs(arr, 0,0,isVisited);

    }

    boolean isSafe(int[][] arr, int i, int j, boolean[][] isVisited){
        return i >=0 && i < arr.length && j >=0 && j <arr.length && arr[i][j] == 1 && !isVisited[i][j];
    }

    void dfs(int[][] arr, int i, int j, boolean[][] isVisited){
        if(i == arr.length-1 && j == arr.length-1){
            System.out.println(list);
            return;
        }
        isVisited[i][j] = true;
        list.add(i+" "+j);
        if(isSafe(arr, i+1,j, isVisited))
            dfs(arr, i+1, j, isVisited);
        if(isSafe(arr, i-1,j, isVisited))
            dfs(arr, i-1, j, isVisited);

        if(isSafe(arr, i,j+1, isVisited))
            dfs(arr, i, j+1, isVisited);
        if(isSafe(arr, i,j-1, isVisited))
            dfs(arr, i, j-1, isVisited);
        list.remove(list.size()-1);
        isVisited[i][j] =  false;
    }


}
