package array;

public class RatInMaze {
    public static void main(String[] args) {
        int[][] arr = {
            {0,1,0,0,0},
            {0,0,0,1,0},
            {0,1,1,0,0},
            {0,1,1,0,1},
            {0,1,1,0,1}
        };
        boolean result = helper(arr, 0,0, new boolean[arr.length][arr[0].length]);
        System.out.println(result);
    }

    static boolean helper(int[][] arr, int i, int j, boolean[][] visited){
        if(i == arr.length-1 && j == arr[0].length-1 && arr[i][j] == 0)
            return true;
        if(!isSafe(arr, i, j))
            return false;
        if(!visited[i][j]){
            int temp = arr[i][j];
            arr[i][j] = 2;

            visited[i][j] = true;
           boolean canMove =  helper(arr, i+1, j, visited) ||
            helper(arr, i-1, j, visited)||
            helper(arr, i, j+1, visited)||
            helper(arr, i, j-1, visited);
           if(canMove)
               return true;
            visited[i][j] = false;
            arr[i][j] = temp;
        }
        return false;
    }

    static boolean isSafe(int[][] arr, int i, int j){
        return i>-1 && j>-1 && i< arr.length && j < arr.length && arr[i][j] == 0;
    }
}
