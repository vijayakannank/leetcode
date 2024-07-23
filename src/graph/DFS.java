package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DFS {

    public static void main(String[] args) {
        List<List<Integer>> adjs = new ArrayList<>();
        adjs.add(Arrays.asList(1,4));
        adjs.add(Collections.singletonList(2));
        adjs.add(Collections.emptyList());
        adjs.add(Collections.emptyList());
        adjs.add(Arrays.asList(5,6));
        adjs.add(Collections.emptyList());
        adjs.add(Collections.emptyList());
        new DFS().dfs(0, adjs);
    }

    List<Integer> dfs(int i, List<List<Integer>> adjs){
        List<Integer> list = new ArrayList<>();
        util(i, adjs, list, new boolean[adjs.size()]);
        return list;
    }
    void util(int i, List<List<Integer>> adjs, List<Integer> result, boolean[] visited){
        if(visited[i])
            return;
        visited[i] = true;
        result.add(i);
        for(int cur: adjs.get(i)){
            util(cur, adjs,result, visited);
        }
    }
}
