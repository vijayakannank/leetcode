package array.twod;


/**
 * You are given row x col grid representing a map where grid[i][j] = 1 represents land and grid[i][j] = 0 represents water.
 *
 * Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells).
 *
 * The island doesn't have "lakes", meaning the water inside isn't connected to the water around the island. One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.
 *
 *

 * Example 1:
 *
 *
 * Input: grid = [[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]
 * Output: 16
 * Explanation: The perimeter is the 16 yellow stripes in the image above.
 *
 * https://leetcode.com/problems/island-perimeter/
 */
public class IslandPerimeter {
    public static void main(String[] args) {
        int[][] arr = {
                {0,1,0,0},
                {1,1,1,0},
                {0,1,0,0},
                {1,1,0,0}
        };
        islandPerimeter(arr);
    }

    static int islandPerimeter(int[][] grid) {
        for(int i =0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 1) {
                    return helper(grid, i, j);
                }
            }
        }
        return 0;
    }
    private static int helper(int[][] grid, int i, int j) {
        if(i >= grid.length || i < 0 || j >= grid[i].length || j < 0 || grid[i][j] == 0) {
            return 1;
        }
        if(grid[i][j] != -1) {
            grid[i][j] = -1;
            int down = helper(grid, i+1, j);
            int right = helper(grid, i, j+1);
            int up = helper(grid, i-1, j);
            int left = helper(grid, i, j-1);
            return down+right+up+left;
        }
        return 0;

    }
}
