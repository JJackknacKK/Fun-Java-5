//CSDS 132 YINGYU ZHU

package chess.european.piece;

import chess.BoardData;
import chess.ChessGame;
import chess.ChessPiece;

//CSDS 132 Yingyu Zhu
public class KingPiece extends ChessPiece {
    //Constructor
    public KingPiece(BoardData boardData, ChessGame game, ChessGame.Side side) {
        super(boardData, game, side);
    }

    //Getter method to get label
    public String getLabel() {
        return "K";
    }
    //This is the king class which extends chess.ChessPiece class
    //It override the capture and non-capture methods to determine if it is a legal move
    //Two methods are exactly the same since it already checks if there is an enemy piece or not.
    //They all contains 8 possibilities, in 4 categories.
    //They all check if the input values are less than numRows/numColumns

    @Override
    public boolean isLegalNonCaptureMove(int row, int column) {
        //Category-1, moves up or down. Same Column, goes up one or down one.
        if (getColumn() == column && (getRow() + 1 == row || getRow() - 1 == row) && row <= getGame().getNumRows()) {
            return true;
        }
        //Category-2, moves right or left. Same row, goes left one of right one.
        if (getRow() == row && (getColumn() + 1 == column || getColumn() - 1 == column) && column <= getGame().getNumColumns()) {
            return true;
        }
        //Category-3, moves to left+up or left+down.
        if (column == getColumn() - 1 && (row == getRow() + 1 || row == getRow() - 1) && column <= getGame().getNumColumns() && row <= getGame().getNumRows()) {
            return true;
        }
        //Category-4, moves to right+up or right+down
        //Any condition besides these are not legal to move
        return column == getColumn() + 1 && (row == getRow() + 1 || row == getRow() - 1) && column <= getGame().getNumColumns() && row <= getGame().getNumRows();
    }


    @Override
    public boolean isLegalCaptureMove(int row, int column) {
        //Category-1, moves up or down. Same Column, goes up one or down one.
        if (getColumn() == column && (getRow() + 1 == row || getRow() - 1 == row) && row <= getGame().getNumRows()) {
            return true;
        }
        //Category-2, moves right or left. Same row, goes left one of right one.
        if (getRow() == row && (getColumn() + 1 == column || getColumn() - 1 == column) && column <= getGame().getNumColumns()) {
            return true;
        }
        //Category-3, moves to left+up or left+down.
        if (column == getColumn() - 1 && (row == getRow() + 1 || row == getRow() - 1) && column <= getGame().getNumColumns() && row <= getGame().getNumRows()) {
            return true;
        }
        //Category-4, moves to right+up or right+down
        //Any condition besides these are not legal to move
        return column == getColumn() + 1 && (row == getRow() + 1 || row == getRow() - 1) && column <= getGame().getNumColumns() && row <= getGame().getNumRows();
    }


    public void moveDone() {
        setNeverMoved();
    }
}
  
  
  
  
  
  
  
  
 