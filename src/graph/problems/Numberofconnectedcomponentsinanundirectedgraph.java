package graph.problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to find the number of connected components in an undirected graph.
 *
 * Example 1:
 *      0          3
 *      |          |
 *      1 --- 2    4
 * Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], return 2.
 *
 * Example 2:
 *      0           4
 *      |           |
 *      1 --- 2 --- 3
 * Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [3, 4]], return 1.
 *
 * Note:
 * You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.
 *
 * https://cheonhyangzhang.gitbooks.io/leetcode-solutions/content/323-number-of-connected-components-in-an-undirected-graph.html
 */
public class Numberofconnectedcomponentsinanundirectedgraph {

    public static void main(String[] args) {
        int[][] arr = {{0, 1}, {1, 2}, {3, 4},{2,3}};
        System.out.println( new Numberofconnectedcomponentsinanundirectedgraph().count(5, arr));
    }

    int count(int n, int[][] edges) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            list.get(edge[0]).add(edge[1]);
            list.get(edge[1]).add(edge[0]);
        }
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;

        for(int i =0; i<n; i++){
            if(!visited[i]){
                queue.offer(i);
                count++;
                dfs(queue, visited, list);
            }
        }
        return count;
    }

    void dfs(Queue<Integer> queue, boolean[] visited, List<List<Integer>> adjs){

        while (!queue.isEmpty()){
            int index = queue.poll();
            for(int i: adjs.get(index)){
                if(!visited[i]){
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }
}
