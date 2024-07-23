package array.twod;

/**
 * You are given an n x n binary matrix grid where 1 represents land and 0 represents water.
 *
 * An island is a 4-directionally connected group of 1's not connected to any other 1's. There are exactly two islands in grid.
 *
 * You may change 0's to 1's to connect the two islands to form one island.
 *
 * Return the smallest number of 0's you must flip to connect the two islands.
 *
 *
 *
 * Example 1:
 *
 * Input: grid = [[0,1],[1,0]]
 * Output: 1
 *
 * https://leetcode.com/problems/shortest-bridge/
 */
import java.util.*;

public class ShortestBridge {
    public static void main(String[] args) {
        int[][] arr = {{0,1,0}, {0,0,0}, {0,0,1}};
        System.out.println(new ShortestBridge().shortestBridge(arr));
    }
    Queue<Pair> queue = new LinkedList<>();
    int[][] dirs = {{-1,0}, {1,0}, {0,-1},{0,1}};
    public int shortestBridge(int[][] grid) {
        int[] firstIslandIndex = getFirstIslandIndex(grid);
        dfs(grid, firstIslandIndex[0], firstIslandIndex[1]);
        while(!queue.isEmpty()){
            Pair pair = queue.poll();
            for(int[] dir: dirs){
                int i = pair.r+dir[0];
                int j = pair.c+dir[1];
                if(i<0 || i>=grid.length || j<0 || j>= grid.length || grid[i][j] == 2)
                    continue;
                if(grid[i][j] == 1)
                    return pair.move;
                grid[i][j] = 2;
                queue.add(new Pair(i, j, pair.move+1));
            }
        }
        return -1;
    }

    void dfs(int[][] grid, int i,int j){
        if(!isSafe(grid, i, j))
            return;
        grid[i][j] = 2;
        queue.add(new Pair(i,j, 0));

        dfs(grid, i+1,j);
        dfs(grid, i-1,j);
        dfs(grid, i,j+1);
        dfs(grid, i,j-1);

    }

    boolean isSafe(int[][] grid, int i, int j){
        return i>=0 && i<grid.length && j>=0 && j< grid.length && grid[i][j] == 1;
    }

    int[] getFirstIslandIndex(int[][] grid){
        for(int i =0; i<grid.length; i++){
            for(int j=0; j<grid.length; j++){
                if(grid[i][j] == 1){
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1,-1};
    }
}

class Pair {
    int r;
    int c;
    int move;

    Pair(int r, int c, int move){
        this.r = r;
        this.c = c;
        this.move = move;
    }
}
