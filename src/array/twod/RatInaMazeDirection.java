package array.twod;

import java.util.ArrayList;
import java.util.List;

public class RatInaMazeDirection {
    static List<String> result= new ArrayList<>();
    public static void main(String[] args) {
        int[][] arr = {
                {1,1,0},
                {1,1,1},
                {1,1,1}
        };
        new RatInaMazeDirection().dfs(arr, new boolean[arr.length][arr[0].length], 0,0,"");
        System.out.println(result);
    }

    void dfs(int[][] arr, boolean[][] visited, int i, int j, String direction){
        if(i == arr.length-1 && j == arr[0].length-1){
            result.add(direction);
           return;
        }

        if(!isSafe(arr, visited, i, j))
            return;
        visited[i][j] = true;
        dfs(arr, visited, i+1, j,direction+"D");
        dfs(arr, visited, i-1, j,direction+"U");
        dfs(arr, visited, i, j-1,direction+"L");
        dfs(arr, visited, i, j+1,direction+"R");
        visited[i][j] = false;
    }
    boolean isSafe(int[][] arr, boolean[][] visited, int i, int j){
        return i >=0 && j>=0 && i< arr.length && j< arr[0].length && arr[i][j] == 1 && !visited[i][j];
    }
}
