package graph;

import java.util.*;

public class DijktrasAlgo {

    public static void main(String[] args) {
        List<List<Pair>> adjs = new ArrayList<>();
        // undirected
//        adjs.add(Collections.emptyList());
//        adjs.add(Arrays.asList(new Pair(2,2), new Pair(4,1)));
//        adjs.add(Arrays.asList(new Pair(1,2), new Pair(5,5), new Pair(3,4)));
//        adjs.add(Arrays.asList(new Pair(2,4), new Pair(4,3), new Pair(5,8)));
//        adjs.add(Arrays.asList(new Pair(1,1), new Pair(3,3)));
//        adjs.add(Arrays.asList(new Pair(2,5), new Pair(3,8)));

        // directed
        adjs.add(Collections.emptyList());
        adjs.add(Arrays.asList(new Pair(2,12), new Pair(4,1)));
        adjs.add(Arrays.asList(new Pair(5,5)));
        adjs.add(Arrays.asList(new Pair(5,7), new Pair(2,1)));
        adjs.add(Arrays.asList(new Pair(3,3)));
        adjs.add(Collections.emptyList());
        new DijktrasAlgo().findMinDis(adjs, 6);
    }

    void findMinDis(List<List<Pair>> adj, int n){
        int[] arr = new int[n];
        Arrays.fill(arr, Integer.MAX_VALUE);
        dfs(adj, arr, 1);
        System.out.println("");
    }

    void dfs(List<List<Pair>> adj, int[] dis, int s){
        PriorityQueue<Pair> queue = new PriorityQueue<>(Comparator.comparingInt(Pair::getWeight));
        queue.add(new Pair(s, 0));
        dis[s] = 0;
        while(!queue.isEmpty()){
            Pair c = queue.poll();
            for(Pair p: adj.get(c.getNode())){
                if(c.getWeight()+p.getWeight() < dis[p.getNode()]){
                    dis[p.getNode()] = c.getWeight()+p.getWeight();
                    queue.add(new Pair(p.getNode(), dis[p.getNode()]));
                }
            }
        }
    }

}
