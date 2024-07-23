package graph;

import java.util.*;

public class BFS {
    public static void main(String[] args) {
        List<List<Integer>> adjs = new ArrayList<>();
        adjs.add(Arrays.asList(1,4,6));
        adjs.add(Collections.singletonList(2));
        adjs.add(Collections.emptyList());
        adjs.add(Collections.emptyList());
        adjs.add(Arrays.asList(5,6));
        adjs.add(Collections.emptyList());
        adjs.add(Collections.singletonList(0));
        new BFS().bfs(0, adjs);
    }

    List<Integer> bfs(int val, List<List<Integer>> adjs){
        List<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[adjs.size()];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(val);
        result.add(val);
        visited[val]  = true;
        while(!queue.isEmpty()){
            int cur = queue.poll();
            for(int j: adjs.get(cur)){
                if(!visited[j]){
                    visited[j] = true;
                    result.add(j);
                    queue.add(j);
                }
            }
        }

        return result;
    }
}
