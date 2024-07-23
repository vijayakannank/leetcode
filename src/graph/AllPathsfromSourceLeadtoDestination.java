package graph;

import java.util.*;

/**
 * Given the edges of a directed graph, and two nodes source and destination of this graph, determine whether or not all paths starting from source eventually end at destination, that is:
 *
 * At least one path exists from the source node to the destination node
 * If a path exists from the source node to a node with no outgoing edges, then that node is equal to destination.
 * The number of possible paths from source to destination is a finite number.
 * Return true if and only if all roads from source lead to destination.
 *
 * Example 1:
 *
 *
 *
 * Input: n = 3, edges = [[0,1],[0,2]], source = 0, destination = 2
 * Output: false
 * Explanation: It is possible to reach and get stuck on both node 1 and node 2.
 * Example 2:
 *
 *
 *
 * Input: n = 4, edges = [[0,1],[0,3],[1,2],[2,1]], source = 0, destination = 3
 * Output: false
 * Explanation: We have two possibilities: to end at node 3, or to loop over node 1 and node 2 indefinitely.
 * Example 3:
 *
 *
 *
 * Input: n = 4, edges = [[0,1],[0,2],[1,3],[2,3]], source = 0, destination = 3
 * Output: true
 * Example 4:
 *
 *
 *
 * Input: n = 3, edges = [[0,1],[1,1],[1,2]], source = 0, destination = 2
 * Output: false
 * Explanation: All paths from the source node end at the destination node, but there are an infinite number of paths,
 * such as 0-1-2, 0-1-1-2, 0-1-1-1-2, 0-1-1-1-1-2, and so on.
 * Example 5:
 *
 *
 *
 * Input: n = 2, edges = [[0,1],[1,1]], source = 0, destination = 1
 * Output: false
 * Explanation: There is infinite self-loop at destination node.
 * Note:
 *
 * The given graph may have self loops and parallel edges.
 * The number of nodes n in the graph is between 1 and 10000
 * The number of edges in the graph is between 0 and 10000
 * 0 <= edges.length <= 10000
 * edges[i].length == 2
 * 0 <= source <= n - 1
 * 0 <= destination <= n - 1
 * All paths from the beginning to the end.
 *
 * Given the edge edges of a digraph, as well as the starting point source and destination destination of the graph, we determine whether all paths starting from the starting point source end at the destination destination
 *
 * There is at least one path from the starting point source to the destination destination
 * If there is a path from the starting point source to the node without edge, the node is the end of the path.
 * The number of possible paths from source to destination is finite
 * Returns true when all paths starting from the starting point source can reach the destination destination, otherwise it returns false.
 * Source: LeetCode
 * Link: https://leetcode-cn.com/problems/all-paths-from-source-lead-to-destination
 * The copyright belongs to the network. Commercial reprint please contact the official authorization, non-commercial reprint please indicate the source.
 *
 * This is a digraph problem. The meaning of the title is very clear, given the starting point, the end point, all the edges, please judge whether all the edges from the starting point can take you to the end point.
 *
 * Encounter graph problem, the vast majority still use DFS to traverse, get the answer. What should I pay attention to in this question
 *
 * When a destination is encountered (this point has no next node), judge whether the point is destination
 * Whether there is ring coloring in Graphs
 * Thinking is not difficult to think, code implementation needs more practice, interview will write 6.
 *
 * Time O(V + E)
 *
 * Space O(n)
 *
 * https://www.fatalerrors.org/a/leetcode-1059-all-paths-from-source-lead-to-destination.html
 */
public class AllPathsfromSourceLeadtoDestination {

    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        // build the graph
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.putIfAbsent(edge[0], new ArrayList<>());
            graph.get(edge[0]).add(edge[1]);
        }
        return helper(graph, new HashSet<Integer>(), source, destination);
    }

    private boolean helper(Map<Integer, List<Integer>> graph, Set<Integer> visited, int cur, int end) {
        // base case
        if (!graph.containsKey(cur)) {
            return cur == end;
        }
        visited.add(cur);
        for (int neighbor : graph.get(cur)) {
            if (visited.contains(neighbor) || !helper(graph, visited, neighbor, end)) {
                return false;
            }
        }
        visited.remove(cur);
        return true;
    }
}
