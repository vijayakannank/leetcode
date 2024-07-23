package array.twod;

/**
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
 *
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 *
 *
 *
 * Example 1:
 *
 * Input: grid = [
 *   ["1","1","1","1","0"],
 *   ["1","1","0","1","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","0","0","0"]
 * ]
 * Output: 1
 *
 * https://leetcode.com/problems/number-of-islands/description/
 */
public class NoOfIslands {
    int numIslands(char[][] grid) {
        int count = 0;
        for(int i=0; i< grid.length; i++){
            for(int j= 0; j< grid[0].length; j++){
                if(grid[i][j] == '1'){
                    dfs(grid, i, j);
                    count++;
                }

            }
        }
        return count;

    }

    void dfs(char[][] arr, int i,int j){
        if(i <0  || i >= arr.length || j < 0 || j >= arr[0].length || arr[i][j] == '0'){
            return;
        }
        arr[i][j] = '0';
        dfs(arr, i+1, j);
        dfs(arr, i-1, j);
        dfs(arr,i, j+1);
        dfs(arr,i, j-1);
    }
}
