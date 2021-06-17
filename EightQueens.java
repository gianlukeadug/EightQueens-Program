import java.util.Arrays;

public class EightQueens implements Cloneable{
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
        chessBoard[row][column] = 'Q';
        markThreatPattern(row, column);
    }

    //marks the square as o
    public void emptySquare(int row, int column){
        chessBoard[row][column] = 'o';
    }

    //sets specified number of queens in allowed positions of 
    //the board. May have queens on it already
    public boolean setQueens(int queensRemaining){
        

        return false;
    }

    //sets the queen's threat pattern with x's
    private void markThreatPattern(int row, int column){
        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                if(i == row && chessBoard[i][j] != 'Q'){
                    markThreatSpace(i, j);
                }
                if(j == column && chessBoard[i][j] != 'Q'){
                    markThreatSpace(i, j);
                }
                if(i-j == row-column && chessBoard[i][j] != 'Q'){
                    markThreatSpace(i, j);
                }
                if(i+j == row+column && chessBoard[i][j] != 'Q'){
                    markThreatSpace(i, j);
                }
                
            }
        }
    }

    //clone method
    public Object clone() throws CloneNotSupportedException{
        EightQueens clone = (EightQueens) super.clone();
        clone.chessBoard = new char[8][8];
        for(int i=0; i<8; i++){
            clone.chessBoard[i] =  chessBoard[i].clone();
        }
        return clone;
    }

    //prints the board to terminal
    public void printBoard(){
        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                System.out.print(chessBoard[i][j] + " ");
            }
            System.out.println();
        }
    }

    //marks threat spaces
    private void markThreatSpace(int row, int column){
        chessBoard[row][column] = 'x';
    }

    //main function 
    public static void main(String[] args) throws CloneNotSupportedException {
        EightQueens test = new EightQueens();
        test.setQueen(2, 0);
        System.out.println("Test : ");
        test.printBoard();
        
        

        
    }
 
}