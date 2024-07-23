package array.twod;

/**
 * Given an m x n integers matrix, return the length of the longest increasing path in matrix.
 *
 * From each cell, you can either move in four directions: left, right, up, or down. You may not move diagonally or move outside the boundary (i.e., wrap-around is not allowed).
 *
 *
 *
 * Example 1:
 *
 *
 * Input: matrix = [[9,9,4],[6,6,8],[2,1,1]]
 * Output: 4
 * Explanation: The longest increasing path is [1, 2, 6, 9].
 *
 * https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
 */
public class LongestIncreasingPathinAMatrix {
    int m;
    int n;
    int[][] ans;
    int[][] dir = {{0,1}, {1,0}, {0,-1}, {-1,0}};

    public int longestIncreasingPath(int[][] mat) {
        m = mat.length;
        n = mat[0].length;
        ans = new int[m][n];

        int res = 0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int temp = dfs(i,j,mat);
                res = Math.max(res, temp);
            }
        }
        return res;
    }

    public int dfs(int i, int j, int[][] mat){
        if(ans[i][j]!=0)
            return ans[i][j];

        int res = 1;
        for(int[] arr : dir){
            int x = i+arr[0];
            int y = j+arr[1];

            if(x<0 || y<0 || x>=m || y>=n || mat[x][y]<=mat[i][j])
                continue;
            res = Math.max(res, 1+dfs(x,y,mat));

        }
        ans[i][j] = res;
        return res;
    }

}
