package graph.problems;
import java.util.*;

/**
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to check whether these edges make up a valid tree.
 *
 * For example:
 *
 * Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.
 *
 * Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.
 *
 * Note: you can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.
 *
 * This is an undirected map, so in-degree methods is not very suitable. Using bfs, since in a valid tree traversal, each not should be only visited once, if there is a loop, you end up visit an already visited node, this is not a valid tree. using a queue, every time, if node is not visited, mark it as visited, then traverse its neighbors, if is not visited, enque it, if there is any cycle in the graph, your queue ends up containing multiple instance of certain numbers.
 *
 * https://tenderleo.gitbooks.io/leetcode-solutions-/content/GoogleMedium/261.html
 */
public class GraphValidTree {
    public static void main(String[] args) {
        int[][] edges = {
                {0,1},
                {1,2},
                {2,3},
                {1,3},
                {1,4}
        };
        new GraphValidTree().validTree(5, edges);
    }
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            list.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            list.get(edge[0]).add(edge[1]);
            list.get(edge[1]).add(edge[0]);
        }
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        while(!queue.isEmpty()){
            int id = queue.poll();
            if(visited[id]){
                return false;
            }
            visited[id] = true;
            for(int neighbor : list.get(id)){
                if(!visited[neighbor]){
                    queue.offer(neighbor);
                }
            }
        }

        for(boolean b : visited){
            if(!b) return false;
        }
        return true;
    }
}
