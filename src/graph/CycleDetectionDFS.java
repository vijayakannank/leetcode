package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CycleDetectionDFS {

    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(Collections.emptyList());
        list.add(Collections.singletonList(3));
        list.add(Collections.singletonList(5));
        list.add(Arrays.asList(1,4));
        list.add(Collections.singletonList(3));
        list.add(Arrays.asList(2,6,8));
        list.add(Arrays.asList(5,7));
        list.add(Arrays.asList(6,8));
        list.add(Arrays.asList(7,5));
        System.out.println(new CycleDetectionDFS().detectCycle(1, list));
    }
    boolean dfs(int v, int p, List<List<Integer>> adjs, boolean[] visited){
        visited[v] = true;
        for(int av: adjs.get(v)){
            if(av == p)
                continue;
            if(visited[av])
                return true;
            if(dfs(av, v, adjs, visited))
                return true;
        }
        return false;
    }

    boolean detectCycle(int v, List<List<Integer>> list){
        boolean[] vis = new boolean[list.size()];
        for(int i=1; i< list.size(); i++){
            if(!vis[i]){
                if(dfs(i,-1, list, vis))
                    return true;
            }
        }
        return false;
    }
}
