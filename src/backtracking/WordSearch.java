package backtracking;

public class WordSearch {

    static boolean exist(char[][] board, String word) {
        for(int i=0; i<board.length; i++){
            for(int j=0; j< board[0].length; j++){
                if(board[i][j] == word.charAt(0) && helper(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    static boolean helper(char[][] board, String word, int i, int j, int l){
       if( l == word.length())
           return true;
       if(isSafe(board,  i, j) && board[i][j] == word.charAt(l)){
           char c = board[i][j];
           board[i][j] = '.';
           if(helper(board, word, i-1,j,l+1)
                   || helper(board, word, i+1,j,l+1)
                   || helper(board, word, i,j-1,l+1)
                   || helper(board, word, i,j+1,l+1)
           ){
               return true;
           }
           board[i][j] = c;
       }

        return false;
    }

    static boolean isSafe(char[][] board, int i, int j){
        return i >= 0 && i < board.length && j >= 0 && j < board[0].length && board[i][j] != '.';
    }

    public static void main(String[] args) {
        char[][] arr = {{'A','B','C','E'},
                {'S','F','C','S'},
                {'A', 'D','E','E'}
        };
        System.out.println(exist(arr, "ABCCED"));
    }
}
