package array;

/**
 * Given an m x n grid of characters board and a string word, return true if word exists in the grid.
 *
 * The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.
 */

public class WordSearch {

    boolean exist(char[][] board, String word) {

        for(int i=0; i< board.length; i++){
            for(int j=0; j< board[i].length; j++){
                if(board[i][j] == word.charAt(0) && exist(board, word, new boolean[board.length][board[0].length], i, j, 0)){
                    return true;

                }
            }
        }
        return false;
    }

    boolean exist(char[][] board, String word, boolean[][] visited, int i, int j, int index){

        if(word.length() == index)
            return true;

        if(!isSafe(board, i, j, visited, word.charAt(index)))
            return false;
        visited[i][j] = true;

        boolean isExist = exist(board, word, visited, i-1, j, index+1) ||
                exist(board, word, visited, i+1, j, index+1) ||
                exist(board, word, visited, i, j-1, index+1) ||
                exist(board, word, visited, i, j+1, index+1);
        if(isExist)
            return true;
        visited[i][j] = false;
        return false;

    }

    boolean isSafe(char[][] board, int i, int j, boolean[][] used, char ch){
        return i >-1 && i< board.length && j>-1  && j<board[0].length && !used[i][j] && board[i][j] == ch;

    }
}
