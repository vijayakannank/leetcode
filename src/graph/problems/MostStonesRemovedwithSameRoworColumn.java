package graph.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * On a 2D plane, we place n stones at some integer coordinate points. Each coordinate point may have at most one stone.
 *
 * A stone can be removed if it shares either the same row or the same column as another stone that has not been removed.
 *
 * Given an array stones of length n where stones[i] = [xi, yi] represents the location of the ith stone, return the largest possible number of stones that can be removed.
 *
 *
 *
 * Example 1:
 *
 * Input: stones = [[0,0],[0,1],[1,0],[1,2],[2,1],[2,2]]
 * Output: 5
 * Explanation: One way to remove 5 stones is as follows:
 * 1. Remove stone [2,2] because it shares the same row as [2,1].
 * 2. Remove stone [2,1] because it shares the same column as [0,1].
 * 3. Remove stone [1,2] because it shares the same row as [1,0].
 * 4. Remove stone [1,0] because it shares the same column as [0,0].
 * 5. Remove stone [0,1] because it shares the same row as [0,0].
 * Stone [0,0] cannot be removed since it does not share a row/column with another stone still on the plane.
 * Example 2:
 *
 * Input: stones = [[0,0],[0,2],[1,1],[2,0],[2,2]]
 * Output: 3
 * Explanation: One way to make 3 moves is as follows:
 * 1. Remove stone [2,2] because it shares the same row as [2,0].
 * 2. Remove stone [2,0] because it shares the same column as [0,0].
 * 3. Remove stone [0,2] because it shares the same row as [0,0].
 * Stones [0,0] and [1,1] cannot be removed since they do not share a row/column with another stone still on the plane.
 * Example 3:
 *
 * Input: stones = [[0,0]]
 * Output: 0
 * Explanation: [0,0] is the only stone on the plane, so you cannot remove it.
 *
 *
 * Constraints:
 *
 * 1 <= stones.length <= 1000
 * 0 <= xi, yi <= 104
 * No two stones are at the same coordinate poin
 *
 * https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/
 */

public class MostStonesRemovedwithSameRoworColumn {
    public static void main(String[] args) {
        int[][] arr = {{0,0},{0,2},{1,1},{2,0},{2,2}};
        new MostStonesRemovedwithSameRoworColumn().removeStones(arr);
    }

    public int removeStones(int[][] stones) {
        UnionFind uf = new UnionFind(stones.length);
        for(int i =0; i< stones.length; i++){
            for(int j=i+1; j<stones.length; j++){
                int[] u = stones[i];
                int[] v = stones[j];

                if(u[0] == v[0] || u[1] == v[1]){
                    uf.union(i, j);
                }

            }
        }
        return stones.length-uf.countComponent();


    }

    private  class UnionFind{
        int[] parent;
        int[] rank;

        UnionFind(int n){
            parent = new int[n];
            rank = new int[n];

            for(int i=0; i<n; i++){
                parent[i] = i;
                rank[i] = 0;
            }
        }
        int findParent(int node){
            if(parent[node] == node)
                return node;
            return parent[node] = findParent(parent[node]);
        }

        void union(int node1, int node2){
            int p1 = findParent(node1);
            int p2 = findParent(node2);

            if(p1 != p2){
                if(rank[p1] > rank[p2])
                    parent[p2] = p1;
                else if(rank[p2] >  rank[p1])
                    parent[p1] = p2;
                else {
                    parent[p2] = p1;
                    rank[p1]++;
                }
            }
        }
        int countComponent(){
            int componentCount = 0;
            for(int i=0; i<rank.length; i++){
                if(parent[i]  == i)
                    componentCount++;
            }
            return componentCount;
        }
    }
}
