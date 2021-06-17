import java.util.Arrays;

public class EightQueens{
    private char[][] chessBoard; 

    //returns the state of the board
    public char[][] getBoard(){
        return chessBoard;
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

    private void setBoardEmpty(){
        chessBoard = new char[queensRemaining][queensRemaining];
        Arrays.fill(chessBoard, 'o');
    }
 
}