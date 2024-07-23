package array.twod;

/**
 * You are given two m x n binary matrices grid1 and grid2 containing only 0's (representing water) and 1's (representing land). An island is a group of 1's connected 4-directionally (horizontal or vertical). Any cells outside of the grid are considered water cells.
 *
 * An island in grid2 is considered a sub-island if there is an island in grid1 that contains all the cells that make up this island in grid2.
 *
 * Return the number of islands in grid2 that are considered sub-islands.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: grid1 = [[1,1,1,0,0],[0,1,1,1,1],[0,0,0,0,0],[1,0,0,0,0],[1,1,0,1,1]], grid2 = [[1,1,1,0,0],[0,0,1,1,1],[0,1,0,0,0],[1,0,1,1,0],[0,1,0,1,0]]
 * Output: 3
 * Explanation: In the picture above, the grid on the left is grid1 and the grid on the right is grid2.
 * The 1s colored red in grid2 are those considered to be part of a sub-island. There are three sub-islands.
 *
 * https://leetcode.com/problems/count-sub-islands/
 */

public class CountSubIslands {

    boolean isSubIsland = true;
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int count = 0;
        for(int i=0; i<grid1.length;i++){
            for(int j=0; j< grid1[0].length; j++){
                if(grid2[i][j] == 1 && grid1[i][j] == 1){
                    isSubIsland = true;
                    dfs(grid1, grid2, i, j);
                    if(isSubIsland)
                        count++;
                }
            }
        }
        return count;

    }

    void dfs(int[][] grid1, int[][] grid2, int i, int j){
        if(!isSafe(grid2, i, j))
            return;
        if(grid1[i][j] != grid2[i][j])
            isSubIsland= false;
        grid2[i][j] = 2;
        dfs(grid1, grid2, i+1,j);
        dfs(grid1, grid2, i-1,j);
        dfs(grid1, grid2, i,j+1);
        dfs(grid1, grid2, i,j-1);


    }

    boolean isSafe(int[][] grid2, int i, int j){
        return i>=0 && i<grid2.length && j>=0 && j<grid2[0].length && grid2[i][j] ==1;

    }
}
