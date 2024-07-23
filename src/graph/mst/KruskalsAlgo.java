package graph.mst;

import java.util.*;

public class KruskalsAlgo {

    public static void main(String[] args) {
        int n = 4;
        int e = 6;
        Node[] edges = new Node[e];
        edges[0] = new Node(0,1,5);
        edges[1] = new Node(0,2,4);
        edges[2] =  new Node(0, 3, 3);
        edges[3] = new Node(1,3,15);
        edges[4] = new Node(2,3, 2);
        edges[5] = new Node(2,1, 1);
        new KruskalsAlgo().mst(edges, 4);
    }
    void mst(Node[] edges, int n){
        Arrays.sort(edges, Comparator.comparingInt(a -> a.weight));
        List<Node> mst = new ArrayList<>();
        UnionFind uf = new UnionFind(n);

        for(int i=0; i< edges.length; i++){
            if(mst.size() == n-1)
                break;
            if(!uf.union(edges[i].src, edges[i].dest))
                mst.add(edges[i]);
        }
        for(Node node: mst)
            System.out.println(node.src+" "+node.dest);

    }

}

class Node {
    int src;
    int dest;
    int weight;

    public Node(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }
}

class UnionFind {
    int[] parent;
    int[] rank;

    public UnionFind(int n) {
        parent = new int[n];
        rank = new int[n];
       for(int i=0; i<n; i++){
           parent[i] = i;
       }
    }
    int find(int i){
        if(parent[i] == i)
            return i;
        return parent[i] = find(parent[i]);
    }

    boolean union(int i, int j) {
        int iP = find(i);
        int jP = find(j);

        if (iP == jP)
            return true;
        if (rank[iP] > rank[jP])
            parent[jP] = parent[iP];
        else if (rank[iP] < rank[jP])
            parent[iP] = parent[jP];
        else{
            parent[jP] = parent[iP];
            rank[iP]++;
        }

        return false;
    }

    @Override
    public String toString() {
        return "UnionFind{" +
                "parent=" + Arrays.toString(parent) +
                ", rank=" + Arrays.toString(rank) +
                '}';
    }
}
