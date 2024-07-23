package array.twod;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a matrix and a target, return the number of non-empty submatrices that sum to target.
 *
 * A submatrix x1, y1, x2, y2 is the set of all cells matrix[x][y] with x1 <= x <= x2 and y1 <= y <= y2.
 *
 * Two submatrices (x1, y1, x2, y2) and (x1', y1', x2', y2') are different if they have some coordinate that is different: for example, if x1 != x1'.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: matrix = [[0,1,0],[1,1,1],[0,1,0]], target = 0
 * Output: 4
 * Explanation: The four 1x1 submatrices that only contain 0.
 * Example 2:
 *
 * Input: matrix = [[1,-1],[-1,1]], target = 0
 * Output: 5
 * Explanation: The two 1x2 submatrices, plus the two 2x1 submatrices, plus the 2x2 submatrix.
 *
 *
 * https://leetcode.com/problems/number-of-submatrices-that-sum-to-target/
 */

public class NumberofSubmatricesThatSumtoTarget {

    public static void main(String[] args) {
        int[][] arr = {
                {1,-1},
                {-1,1}
        };
        new NumberofSubmatricesThatSumtoTarget().numSubmatrixSumTarget(arr,0);
    }

    int numSubmatrixSumTarget(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i=0;i<m;i++){
            for(int j=1;j<n;j++){
                matrix[i][j] += matrix[i][j-1];
            }
        }
        int count = 0;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                Map<Integer, Integer> mp = new HashMap<>();
                mp.put(0, 1);
                int sum = 0;
                for(int r=0;r<m;r++){
                    if(i==0) sum += matrix[r][j];
                    else
                        sum += matrix[r][j]-matrix[r][i-1];
                    count += mp.getOrDefault(sum-target, 0);
                    mp.put(sum, mp.getOrDefault(sum, 0)+1);
                }
            }
        }
        return count;
    }
}
