package matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacificAtlantic {
    public static void main(String[] args) {
        int[][] arr = {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
        new PacificAtlantic().pacificAtlantic(arr);
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        if (heights == null || heights.length == 0 || heights[0].length == 0)
            return res;
        int row = heights.length;
        int col = heights[0].length;
        boolean[][] pacific = new boolean[row][col];
        boolean[][] atlantic = new boolean[row][col];
        // DFS calls
        for (int i = 0; i < row; i++) {
            dfs(heights, i, 0, Integer.MIN_VALUE, pacific);
            dfs(heights, i, col -1, Integer.MIN_VALUE, atlantic);
        }
        for (int j = 0; j < col; j++) {
            dfs(heights, 0, j, Integer.MIN_VALUE, pacific);
            dfs(heights, row - 1, j, Integer.MIN_VALUE, atlantic);
        }
        // Preparing Result
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (pacific[i][j] && atlantic[i][j])
                    res.add(Arrays.asList(i,j));
            }
        }
        return res;
    }
    // DFS
    public void dfs(int[][] heights, int i, int j, int prev, boolean[][] ocean) {
        if (i < 0 || i >= ocean.length || j < 0 || j >= ocean[0].length)
            return;
        if (heights[i][j] < prev || ocean[i][j])
            return;
        ocean[i][j] = true;
        dfs(heights, i - 1, j, heights[i][j], ocean);
        dfs(heights, i + 1, j, heights[i][j], ocean);
        dfs(heights, i, j - 1, heights[i][j], ocean);
        dfs(heights, i, j + 1, heights[i][j], ocean);
    }
}
