package graph;

import java.util.*;

public class TopologicalSort {

    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(Collections.emptyList());
        list.add(Arrays.asList(2,3));
        list.add(Collections.singletonList(7));
        list.add(Arrays.asList(4,5));
        list.add(Collections.singletonList(5));
        list.add(Collections.emptyList());
        list.add(Collections.singletonList(2));
        list.add(Collections.emptyList());
        System.out.println(new TopologicalSort().topologicalSort(list));
    }

    List<Integer> topologicalSort(List<List<Integer>> list){
        boolean[] visited = new boolean[list.size()];
        Stack<Integer> stack = new Stack<>();
        for(int i=1; i<list.size(); i++){
            if(!visited[i])
                dfs(list, visited, i, stack);
        }
        List<Integer> result = new ArrayList<>();
        while(!stack.isEmpty()){
            result.add(stack.pop());
        }
        return result;
    }

    void dfs(List<List<Integer>> list, boolean[] visited, int index, Stack<Integer> stack){
        if(visited[index])
            return;
        visited[index]= true;
        for(int i: list.get(index)){
            dfs(list, visited, i, stack);
        }
        stack.push(index);
    }
}
