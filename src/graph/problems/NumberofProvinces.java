package graph.problems;


import java.util.*;
/**
 * There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b, and city b is connected directly with city c, then city a is connected indirectly with city c.
 *
 * A province is a group of directly or indirectly connected cities and no other cities outside of the group.
 *
 * You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.
 *
 * Return the total number of provinces.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
 * Output: 2
 * Example 2:
 *
 *
 * Input: isConnected = [[1,0,0],[0,1,0],[0,0,1]]
 * Output: 3
 *
 *
 * Constraints:
 *
 * 1 <= n <= 200
 * n == isConnected.length
 * n == isConnected[i].length
 * isConnected[i][j] is 1 or 0.
 * isConnected[i][i] == 1
 * isConnected[i][j] == isConnected[j][i]
 *
 * https://leetcode.com/problems/number-of-provinces/
 */
public class NumberofProvinces {
    int findCircleNum(int[][] isConnected) {

        List<List<Integer>> adj = new ArrayList<>();
        int n =isConnected.length;

        for(int i =0; i<n; i++)
            adj.add(new ArrayList<>());

        for(int i =0; i< n; i++){
            for(int j=0; j<n; j++){
                if(i != j && isConnected[i][j] == 1)
                    adj.get(i).add(j);
            }
        }

        boolean[] visited = new boolean[n];
        int result = 0;

        for(int i =0; i<n; i++){
            if(!visited[i]){
                dfs(adj,visited, i);
                result++;

            }
        }
        return result;
    }

    void dfs( List<List<Integer>> adj, boolean[] visited, int i){
        if(visited[i])
            return;
        visited[i] = true;

        for(int a: adj.get(i))
            dfs(adj, visited, a);
    }
}
