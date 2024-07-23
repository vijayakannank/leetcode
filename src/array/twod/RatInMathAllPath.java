package array.twod;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.codingninjas.com/codestudio/problems/rat-in-a-maze-all-paths_758966
 *
 * if path is not there make it all 1 as zoro
 */
public class RatInMathAllPath {

    static List<List<Integer>> result= new ArrayList<>();
    public static void main(String[] args) {
        int[][] arr = {
                {1,0,1},
                {1,0,1},
                {1,1,1}
        };
        new RatInMathAllPath().dfs(arr, new boolean[arr.length][arr[0].length], 0,0);
        System.out.println(result);
    }

    void dfs(int[][] arr, boolean[][] visited, int i, int j){
        if(i == arr.length-1 && j == arr[0].length-1){
            visited[i][j] =true;
            result.add(convertArrayToList(visited));
            return;
        }

        if(!isSafe(arr, visited, i, j))
            return;
        visited[i][j] = true;
        dfs(arr, visited, i+1, j);
        dfs(arr, visited, i-1, j);
        dfs(arr, visited, i, j-1);
        dfs(arr, visited, i, j+1);
        visited[i][j] = false;
    }

    boolean isSafe(int[][] arr, boolean[][] visited, int i, int j){
        return i >=0 && j>=0 && i< arr.length && j< arr[0].length && arr[i][j] == 1 && !visited[i][j];
    }

    List<Integer> convertArrayToList(boolean[][] visited){
        List<Integer> list = new ArrayList<>();
        for(int i =0; i< visited.length; i++){
            for(int j=0; j<visited[0].length; j++){
                list.add(visited[i][j] ? 1:0);
            }
        }
        return list;
    }
}
