package graph.problems;

/**
 * In this problem, a tree is an undirected graph that is connected and has no cycles.
 *
 * You are given a graph that started as a tree with n nodes labeled from 1 to n, with one additional edge added. The added edge has two different vertices chosen from 1 to n, and was not an edge that already existed. The graph is represented as an array edges of length n where edges[i] = [ai, bi] indicates that there is an edge between nodes ai and bi in the graph.
 *
 * Return an edge that can be removed so that the resulting graph is a tree of n nodes. If there are multiple answers, return the answer that occurs last in the input.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: edges = [[1,2],[1,3],[2,3]]
 * Output: [2,3]
 * Example 2:
 *
 *
 * Input: edges = [[1,2],[2,3],[3,4],[1,4],[1,5]]
 * Output: [1,4]
 *
 *
 * Constraints:
 *
 * n == edges.length
 * 3 <= n <= 1000
 * edges[i].length == 2
 * 1 <= ai < bi <= edges.length
 * ai != bi
 * There are no repeated edges.
 * The given graph is connected.
 *
 * https://leetcode.com/problems/redundant-connection/
 */
public class RedundantConnection {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        UnionFind uf = new UnionFind(n);
        for(int[] edge: edges){
            if(!uf.union(edge))
                return edge;
        }
        return null;

    }

    private class UnionFind {
        int[] parent;
        int[] rank;

        UnionFind(int n){
            this.parent = new int[n+1];
            this.rank = new int[n+1];

            for(int i =0; i< n; i++){
                this.parent[i] = i;
                this.rank[i] = 0;
            }
        }

        int findParent( int node){
            if(parent[node] == node)
                return node;
            return parent[node] = findParent( parent[node]);
        }

        boolean union(int[] edge){
            int u = edge[0];
            int v = edge[1];

            int up = findParent( u);
            int vp = findParent( v);

            if(up != vp){
                if(rank[up] > rank[vp])
                    parent[vp] = parent[up];
                else if(rank[up] < rank[vp])
                    parent[up] = parent[vp];
                else {
                    parent[vp] = parent[up];
                    rank[up]++;
                }
                return true;

            }
            return false;
        }
    }
}
