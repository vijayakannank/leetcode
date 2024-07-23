package systemDesign.tictacktoe;

public class Board {
    private int[][] board = new int[3][3];

    void instructionBoard(){
        System.out.println("| - | - | - |");
        System.out.println("| 1 | 2 | 3 |");
        System.out.println("| - | - | - |");
        System.out.println("| 4 | 5 | 6 |");
        System.out.println("| - | - | - |");
        System.out.println("| 7 | 8 | 9 |");
        System.out.println("| - | - | - |");

    }

//    5 - 1,1
//    8 - 2,1

    void placePiece(int position, char type){

        int row = position /3;
        int col = position %3-1;

    }


    void displayBoard(){
        System.out.println("| - | - | - |");
        System.out.println(printRow(0));
        System.out.println("| - | - | - |");
        System.out.println(printRow(1));
        System.out.println("| - | - | - |");
        System.out.println(printRow(2));
        System.out.println("| - | - | - |");
    }
    private String printRow(int row) {
        StringBuilder sb = new StringBuilder("|");
        for(int i =0; i< 3; i++){
            sb.append(" ").append(board[row][i]).append(" |");
        }
        return sb.toString();
    }
}
