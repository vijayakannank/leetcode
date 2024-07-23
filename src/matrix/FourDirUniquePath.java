package matrix;

import java.util.ArrayList;
import java.util.List;

public class FourDirUniquePath {
    static int count = 0;
    List<String> list = new ArrayList<>();

    public static void main(String[] args) {
       FourDirUniquePath p = new FourDirUniquePath();
       int[][] arr = {
               {0,1,0,0},
               {0,0,0,0},
               {1,0,0,0},
       };
       boolean[][] isVisited = new boolean[arr.length][arr[0].length];
       p.count(arr, 0,0, isVisited);
        System.out.println(count);
    }

    boolean isValid(int[][] arr, int i, int j, boolean[][] isVisited){
        return i >=0 && j >=0 && i < arr.length && j < arr[0].length && arr[i][j] == 0 && !isVisited[i][j] ;
    }

    void count(int[][] arr, int i, int j, boolean[][] isVisited ){
        if(i == arr.length-1 && j == arr[0].length-1){
            count++;
            System.out.println(list);
            return;
        }
        isVisited[i][j] = true;
        list.add(i+"-"+j);
        if(isValid(arr,i-1, j, isVisited))
            count(arr, i-1,j, isVisited);
        if(isValid(arr,i+1, j, isVisited))
            count(arr, i+1,j, isVisited);
        if(isValid(arr,i, j-1, isVisited))
            count(arr, i,j-1, isVisited);
        if(isValid(arr,i, j+1, isVisited))
            count(arr, i,j+1, isVisited);
        isVisited[i][j] = false;
        list.remove(list.size()-1);
    }
}
