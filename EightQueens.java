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
        int row = 8 - queensRemaining;
        int column = 0;
        if(queensRemaining <= 0){
            removeThreatPattern(row, column);
            return true;
        }
        
        while(column < 8){
            if(chessBoard[row][column] == 'o'){
                setQueen(row, column);
                    if(setQueens(queensRemaining-1)){
                        removeThreatPattern(row, column);
                        return true;
                    }
                    
                    emptySquare(row, column);
                    removeThreatPattern(row, column);
                    
                }
                column++;
        }
        
        
            
        

        return false;
    }

    //sets the queen's threat pattern with x's
    private void markThreatPattern(int row, int column){
        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                if(i == row && chessBoard[i][j] == 'o'){
                    markThreatSpace(row, i, j);
                }
                if(j == column && chessBoard[i][j] == 'o'){
                    markThreatSpace(row, i, j);
                }
                if(i-j == row-column && chessBoard[i][j] == 'o'){
                    markThreatSpace(row, i, j);
                }
                if(i+j == row+column && chessBoard[i][j] == 'o'){
                    markThreatSpace(row, i, j);
                }
                
            }
        }
    }

    private void removeThreatPattern(int row, int column){
        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                if(i == row && chessBoard[i][j] == (char)('a'+row)){
                    emptySquare(i, j);
                }
                if(j == column && chessBoard[i][j] == (char)('a'+row)){
                    emptySquare(i, j);
                }
                if(i-j == row-column && chessBoard[i][j] == (char)('a'+row)){
                    emptySquare(i, j);
                }
                if(i+j == row+column && chessBoard[i][j] == (char)('a'+row)){
                    emptySquare(i, j);
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
        System.out.println();
    }

    //marks threat spaces
    private void markThreatSpace(int queenRow, int row, int column){
        for(int i=0; i<8; i++){
            if(i == queenRow){
                chessBoard[row][column] = (char)('a' + i);
            }
        }
    }

    //main function 
    public static void main(String[] args) throws CloneNotSupportedException {
        EightQueens test = new EightQueens();
        System.out.println(test.setQueens(7));
        
        System.out.println("Test : ");
        test.printBoard();
               
        

        
    }
 
}