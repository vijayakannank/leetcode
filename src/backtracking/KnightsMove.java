package backtracking;

public class KnightsMove {

    int move =0;
    int[] x = {-2,-2,-1,-1,1,1,2,2};
    int[] y = {1,-1,2,-2,-2,2,-1,1};

    public static void main(String[] args) {
        int[][] board = new int[8][8];
        KnightsMove mov = new KnightsMove();
        mov.dfs(board, 0, 0);
        for(int i =0; i<8; i++){
            for(int j=0; j<8; j++){
                System.out.print(" "+board[i][j]);
            }
            System.out.println();
        }
    }

    boolean canMove(int[][] board, int i, int j){

        return i >=0 && j >= 0 && i <board.length && j< board.length && board[i][j] ==0;
    }

    void dfs(int[][] board, int i, int j){
        if(move == board.length * board.length)
            return;
        board[i][j] = ++move;
        for(int k = 0; k<8; k++){
            if(canMove(board, i+x[k], j+y[k]))
                dfs(board, i+x[k], j+y[k]);
        }
    }
}
