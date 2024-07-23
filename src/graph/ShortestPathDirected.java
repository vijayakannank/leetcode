package graph;

import java.util.*;

public class ShortestPathDirected {
    public static void main(String[] args) {
        List<List<Pair>> list = new ArrayList<>();
        list.add(Arrays.asList(new Pair(1,2), new Pair(4,1)));
        list.add(Arrays.asList(new Pair(2,3)));
        list.add(Arrays.asList(new Pair(3,6)));
        list.add(Collections.emptyList());
        list.add(Arrays.asList(new Pair(2,2), new Pair(5,4)));
        list.add(Arrays.asList(new Pair(3,1)));
        new ShortestPathDirected().shortestPath(list,4);

    }

    void shortestPath(List<List<Pair>> adjs, int s){
        int[] sp = new int[adjs.size()];
        Arrays.fill(sp, Integer.MAX_VALUE);
        boolean[] visited = new boolean[adjs.size()];

        Stack<Integer> stack = new Stack<>();
        for(int i=0; i< adjs.size(); i++){
            if(visited[i])
                continue;
            topologicalSort(adjs, i, visited, stack);
        }
        sp[s] = 0;
        while(!stack.isEmpty()){
            int index = stack.pop();
            if(sp[index] != Integer.MAX_VALUE){
                for(Pair p: adjs.get(index)){
                    sp[p.getNode()] = Math.min(sp[index]+p.getWeight(), sp[p.getNode()]);
                }
            }

        }
        System.out.println(sp);

    }

    void topologicalSort(List<List<Pair>> adjs, int index, boolean[] visited, Stack<Integer> stack){
        visited[index] = true;

        for(Pair p: adjs.get(index)){
            if(!visited[p.getNode()]){
                topologicalSort(adjs,p.getNode(), visited, stack);
            }
        }
        stack.add(index);
    }

}

