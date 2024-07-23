package graph.mst;

import java.util.*;

public class PrimsAlgo {

    public static void main(String[] args) {

        int n = 4;
         ArrayList<PNode>[] adj  = new ArrayList[4];
         for(int i=0; i<n; i++){
             adj[i] = new ArrayList<>();
         }
         adj[0].add(new PNode(1,5));
         adj[0].add(new PNode(2,4));
         adj[0].add(new PNode(3,3));
         adj[1].add(new PNode(3,8));
         adj[1].add(new PNode(0,5));
         adj[1].add(new PNode(2,1));
         adj[2].add(new PNode(1,1));
         adj[2].add(new PNode(3,2));
         adj[2].add(new PNode(0,4));
         adj[3].add(new PNode(0,3));
         adj[3].add(new PNode(1,8));
         adj[3].add(new PNode(2,2));
         new PrimsAlgo().mst(adj, n);

    }
    void mst(List<PNode>[] adj, int n){
        PriorityQueue<PNode> pq = new PriorityQueue<>(Comparator.comparingInt(a-> a.weight));
        Set<Integer> visited = new HashSet<>();
        pq.add(new PNode(0,0));
        List<PNode> result = new ArrayList<>();

        while(visited.size() < n){
            PNode node = pq.poll();
            if(!visited.contains(node.adj)){
                visited.add(node.adj);
                result.add(node);
                if(visited.size() == n)
                    break;
                for(PNode ad: adj[node.adj]){
                    if(!visited.contains(ad.adj))
                        pq.add(ad);
                }
            }
        }
        for(PNode node: result){
            System.out.println(node.adj+" "+node.weight);
        }
    }
}

class PNode {
    int adj;
    int weight;

    public PNode(int adj, int weight) {
        this.adj = adj;
        this.weight = weight;
    }
}
