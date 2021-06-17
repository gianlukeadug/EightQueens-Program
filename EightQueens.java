import java.util.Arrays;

public class EightQueens{
    private char[][] chessBoard; 

    //initialize the entire board to empty state
    public EightQueens(){
        chessBoard = new char[8][8];
        for(int i=0; i<8; i++){
            Arrays.fill(chessBoard[i], 'o');
        }
    }

    //returns the state of the board
    public char[][] getBoard(){
        return this.chessBoard;
    }

    //sets the queen on (row, column)
    public void setQueen(int row, int column){

    }

    //marks the square as o
    public void emptySquare(int row, int column){

    }

    //sets specified number of queens in allowed positions of 
    //the board. May have queens on it already
    public boolean setQueens(int queensRemaining){
        

        return false;
    }

    public void printBoard(){
        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                System.out.print(chessBoard[i][j] + " ");
            }
            System.out.println();
        }
    }

    //main function 
    public static void main(String[] args) {
        EightQueens test = new EightQueens();
        test.printBoard();
    }
 
}