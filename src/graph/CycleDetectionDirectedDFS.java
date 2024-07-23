package graph;

import sun.security.provider.certpath.Vertex;

import java.util.*;

public class CycleDetectionDirectedDFS {
    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(Collections.emptyList());
        list.add(Collections.singletonList(2));
        list.add(Arrays.asList(3,4));
        list.add(Collections.emptyList());
        list.add(Collections.singletonList(5));
        list.add(Collections.singletonList(6));
        list.add(Collections.singletonList(7));
//        list.add(Collections.emptyList());
        list.add(Collections.singletonList(4));
        System.out.println(new CycleDetectionDirectedDFS().findCycle(list));

    }

    private boolean findCycle(List<List<Integer>> list) {
        int[] processed = new int[list.size()];
        Stack<Integer> stack = new Stack<>();
        for(int i=1; i<list.size(); i++){
            if(processed[i] != 2 && dfs(list, i, processed, stack))
                return true;
        }
        return false;

    }


    boolean dfs(List<List<Integer>> list, int node, int[] processed, Stack<Integer> stack) {
        if(processed[node] == 1)
            return true;
        processed[node] = 1;
        stack.push(node);
        while (!stack.isEmpty()){
            int value = stack.pop();
            for(int i: list.get(value)){
                if(processed[i] != 2){
                    if(dfs(list, i, processed, stack)){
                        return true;
                    }
                }
            }
            processed[value] =2;
        }
        return false;
    }
}
