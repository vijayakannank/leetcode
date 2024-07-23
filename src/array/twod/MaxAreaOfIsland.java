package array.twod;

/**
 * https://leetcode.com/problems/max-area-of-island/
 */
public class MaxAreaOfIsland {

    public static void main(String[] args) {
        int[][] grid = {{0,0,1,0,0,0,0,1,0,0,0,0,0},
                { 0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}};
        System.out.println(findMaxArea(grid));
    }

    static int findMaxArea(int[][] grid){
        int max =0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length;j++){
                max = Math.max(max, DFS(grid, i, j));
            }
        }
        return max;
    }
    static int DFS(int[][] grid, int i, int j){
        if (i >= 0
                && j >= 0
                && i < grid.length
                && j < grid[0].length
                && grid[i][j] == 1) {

            // mark as visited
            grid[i][j] = -1;

            return 1 +  DFS(grid, i + 1, j) + DFS(grid, i - 1, j) + DFS(grid, i, j - 1)+DFS(grid, i, j + 1) ;
        }
        return 0;
    }
}
