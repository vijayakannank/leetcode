package graph.mst;


import java.util.PriorityQueue;

/**
 * You are given an array points representing integer coordinates of some points on a 2D-plane, where points[i] = [xi, yi].
 *
 * The cost of connecting two points [xi, yi] and [xj, yj] is the manhattan distance between them: |xi - xj| + |yi - yj|, where |val| denotes the absolute value of val.
 *
 * Return the minimum cost to make all points connected. All points are connected if there is exactly one simple path between any two points.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: points = [[0,0],[2,2],[3,10],[5,2],[7,0]]
 * Output: 20
 * Explanation:
 *
 * We can connect the points as shown above to get the minimum cost of 20.
 * Notice that there is a unique path between every pair of points.
 * Example 2:
 *
 * Input: points = [[3,12],[-2,5],[-4,1]]
 * Output: 18
 *
 *
 * Constraints:
 *
 * 1 <= points.length <= 1000
 * -106 <= xi, yi <= 106
 * All pairs (xi, yi) are distinct.
 *
 * https://leetcode.com/problems/min-cost-to-connect-all-points/
 */

public class MinCosttoConnectAllPointsPrims {
    public static void main(String[] args) {
        int[][] arr = {{0,0},{2,2},{3,10},{5,2},{7,0}};
        new MinCosttoConnectAllPointsPrims().minCostConnectPoints(arr);
    }
    int minCostConnectPoints(int[][] points) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.dist - b.dist);
        pq.add(new Pair(0, 0));
        int n = points.length;
        boolean[] visited = new boolean[n];
        int count = 0;
        int result = 0;

        while(count<n){
            Pair pair = pq.poll();
            if(visited[pair.vrt])
                continue;
            visited[pair.vrt] = true;

            result += pair.dist;
            count++;
            for(int i =0; i<n; i++){
                if(!visited[i]){
                    int d = Math.abs(points[i][0] - points[pair.vrt][0])+Math.abs(points[i][1]-points[pair.vrt][1]);
                    pq.add(new Pair(i, d));
                }
            }

        }
        return result;


    }
}


class Pair {
    int vrt;
    int dist;

    Pair(int vrt, int dist){
        this.vrt = vrt;
        this.dist = dist;
    }
}