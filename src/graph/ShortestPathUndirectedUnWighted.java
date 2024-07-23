package graph;

import java.util.*;

public class ShortestPathUndirectedUnWighted {
    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList(1,3));
        list.add(Arrays.asList(0,2,3));
        list.add(Arrays.asList(1,6));
        list.add(Arrays.asList(0,4));
        list.add(Arrays.asList(3,5));
        list.add(Arrays.asList(4,6));
        list.add(Arrays.asList(2,5,7,8));
        list.add(Arrays.asList(6,8));
        list.add(Arrays.asList(6,7));
        new ShortestPathUndirectedUnWighted().bfs(list, 0);
    }

    void bfs(List<List<Integer>> list, int source){
        boolean[] visited = new boolean[list.size()];
        int[] shortestPath = new int[list.size()];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        visited[source] = true;
        shortestPath[source] = 0;
        while(!queue.isEmpty()){
            int index = queue.poll();
            for(int i: list.get(index)){
                if(visited[i])
                    continue;
                visited[i] = true;
                shortestPath[i] = shortestPath[index]+1;
                queue.add(i);
            }
        }
        System.out.println(shortestPath);
    }

}
