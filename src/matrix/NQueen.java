package matrix;

import java.util.HashSet;
import java.util.Set;

public class NQueen {
    public static void main(String[] args) {
        NQueen nQueen = new NQueen();
        int[][] arr = new int[8][8];
        nQueen.solve(arr, 0, new HashSet<Integer>(),new HashSet<Integer>(),new HashSet<Integer>());
    }

    void solve(int[][] arr, int i, Set<Integer> set,  Set<Integer> set2, Set<Integer> ver){
        if(i == arr.length){
            System.out.println("true");
            return;
        }
        for(int j=0; j< arr.length; j++){
            if(!set.contains(j+i) && !set2.contains(j-i) && !ver.contains(j)){
                arr[i][j] =1;
                set.add(j+i);
                set2.add(j-i);
                ver.add(j);
                solve(arr, i+1, set, set2, ver);
                set.remove(j+i);
                set2.remove(j-i);
                ver.remove(j);
                arr[i][j] =0;
            }
        }
    }
}
