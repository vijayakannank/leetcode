package graph.union;

/**
 * There are n computers numbered from 0 to n - 1 connected by ethernet cables connections forming a network where connections[i] = [ai, bi] represents a connection between computers ai and bi. Any computer can reach any other computer directly or indirectly through the network.
 *
 * You are given an initial computer network connections. You can extract certain cables between two directly connected computers, and place them between any pair of disconnected computers to make them directly connected.
 *
 * Return the minimum number of times you need to do this in order to make all the computers connected. If it is not possible, return -1.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: n = 4, connections = [[0,1],[0,2],[1,2]]
 * Output: 1
 * Explanation: Remove cable between computer 1 and 2 and place between computers 1 and 3.
 * Example 2:
 *
 *
 * Input: n = 6, connections = [[0,1],[0,2],[0,3],[1,2],[1,3]]
 * Output: 2
 * Example 3:
 *
 * Input: n = 6, connections = [[0,1],[0,2],[0,3],[1,2]]
 * Output: -1
 * Explanation: There are not enough cables.
 *
 *
 * Constraints:
 *
 * 1 <= n <= 105
 * 1 <= connections.length <= min(n * (n - 1) / 2, 105)
 * connections[i].length == 2
 * 0 <= ai, bi < n
 * ai != bi
 * There are no repeated connections.
 * No two computers are connected by more than one cable.
 *
 * https://leetcode.com/problems/number-of-operations-to-make-network-connected/
 */

public class NumberofOperationstoMakeNetworkConnected {
    int makeConnected(int n, int[][] connections) {
        DisjointSet ds = new DisjointSet(n);
        int redundantConnections = 0;

        for (int[] edge : connections) {
            int v = edge[0], u = edge[1];
            if (!ds.union(v, u)) {
                redundantConnections++;
            }
        }
        return ds.groupCount() - 1 > redundantConnections ? -1 : ds.groupCount() - 1;
    }
}

class DisjointSet {
    private int[] parent;
    private int[] rank;
    private int groups;

    public DisjointSet(int n) {
        this.parent = new int[n];
        this.rank = new int[n];
        this.groups = n;

        for (int v = 0; v < n; v++) {
            this.parent[v] = v;
            this.rank[v] = 1;
        }
    }

    public int find(int v) {
        if (parent[v] == v) return v;
        parent[v] = find(parent[v]);
        return parent[v];
    }

    public boolean union(int v, int u) {
        int sv = find(v), su = find(u);
        if (sv == su) return false;

        if (rank[sv] > rank[su]) {
            rank[sv] += rank[su];
            parent[su] = sv;
        } else {
            rank[su] += rank[sv];
            parent[sv] = su;
        }
        this.groups--;
        return true;
    }

    public int groupCount() {
        return this.groups;
    }
}
