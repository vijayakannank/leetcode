package backtracking;

import java.util.ArrayList;
import java.util.*;

public class AllPossibleNQueen {

    public static void main(String[] args) {
        AllPossibleNQueen ap = new AllPossibleNQueen();
        ap.solveNQueens(4);
        System.out.println(result);
    }

    static List<List<String>> result = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        int[][] arr = new int[n][n];
        solve(arr, 0, new HashSet<Integer>(), new HashSet<Integer>(), new HashSet<Integer>());
        return result;

    }

    void solve(int[][] arr, int i, Set<Integer> set, Set<Integer> set2, Set<Integer> ver){
        if(i == arr.length){
            addResult(arr);
            return;
        }
        for(int j=0; j<arr.length; j++){
            if(!set.contains(j+i) && !set2.contains(j-i) && !ver.contains(j)){
                arr[i][j] = 1;
                set.add(j+i);
                set2.add(j-i);
                ver.add(j);
                solve(arr, i+1, set, set2, ver);
                set.remove(j+i);
                set2.remove(j-i);
                ver.remove(j);
                arr[i][j] = 0;
            }
        }
    }

    void addResult(int[][] arr){
        List<String> list = new ArrayList<>();
        for(int i=0; i<arr.length; i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0; j< arr.length; j++){
                if(arr[i][j] == 1){
                    sb.append("Q");
                }
                else
                    sb.append(".");
            }
            list.add(sb.toString());
        }
        result.add(list);
    }
}
