//CSDS 132 YINGYU ZHU

package chess.european.piece;

import chess.BoardData;
import chess.ChessGame;
import chess.ChessPiece;

//CSDS132 Yingyu Zhu
//This is the rook class which extends chess.ChessPiece class while implement chess.ChessBoard
//It override the capture and non-capture methods to determine if it is a legal move
public class RookPiece extends ChessPiece {

    //Constructor
    public RookPiece(BoardData boardData, ChessGame game, ChessGame.Side side) {
        super(boardData, game, side);
    }

    @Override
    public String getLabel() {
        return "R";
    }

    //Rook can only move horizontally or vertically. So, it will have 4 possibilities within two categories
    //Category-1 moves vertically, having the same row, but move left or right.
    //Category-2 moves horizontally, having the same column, but moves up or down.
    //They all check if the input values are greater than 0 and smaller than the numRows/numColumns
    @Override
    public boolean isLegalNonCaptureMove(int row, int column) {
        //This is the Category-1, check for row first, if the same, then....
        if (getRow() == row && column <= getGame().getNumColumns() && column > 0 && row >= 0) {
            //Category-1, condition-1 move to the left, if current column is greater than the input column
            //Checks every square between the current position to the destination, if there are any chess pieces.
            if (getColumn() > column) {
                for (int i = (getColumn() - 1); i >= column; i--) {
                    getBoardData().hasPiece(getRow(), i);
                    if (getBoardData().hasPiece(getRow(), i)) {
                        return false;
                    }
                }
            }
            //Category-1, Condition-2, move to the right, if the current column is less than the input one.
            //Checks every square between the current position to the destination, if there are any chess pieces.
            else if (getColumn() < column) {
                for (int index = (getColumn() + 1); index <= column; index++) {
                    getBoardData().hasPiece(getRow(), index);
                    if (getBoardData().hasPiece(getRow(), index)) {
                        return false;
                    }
                }

            }
            //Any cases besides those two, return false
            else {
                return false;
            }
        }
        //This is the category-2, check the column is the same or not, if true...
        else if (getColumn() == column && row <= getGame().getNumRows()) {
            //Category-2, condition-3, move down, if the current row is greater than the input one
            //Checks every square between the current position to the destination, if there are any chess pieces.
            if (getRow() > row) {
                for (int j = (getRow() - 1); j >= row; j--) {
                    getBoardData().hasPiece(j, getColumn());
                    if (getBoardData().hasPiece(j, getColumn())) {
                        return false;
                    }
                }
            }
            //Category-2, condition-4, move up, if the current row is smaller than the input one
            //Checks every square between the current position to the destination, if there are any chess pieces.
            else if (getRow() < row) {
                for (int k = (getRow() + 1); k <= row; k++) {
                    getBoardData().hasPiece(k, getColumn());
                    if (getBoardData().hasPiece(k, getColumn())) {
                        return false;
                    }
                }

            }
            //Any cases besides those two, return false
            else
                return false;
        } else
            return false;

        return true;
    }

    //This is exactly the same as the one above
    @Override
    public boolean isLegalCaptureMove(int row, int column) {
        //This is the Category-1, check for row first, if the same, then....
        if (getRow() == row && column <= getGame().getNumColumns() && column >= 0 && row >= 0) {
            //Category-1, condition-1 move to the left, if current column is greater than the input column
            //Checks every square between the current position to the destination, if there are any chess pieces.
            if (getColumn() > column) {
                for (int i = (getColumn() - 1); i >= column; i--) {
                    getBoardData().hasPiece(getRow(), i);
                    if (getBoardData().hasPiece(getRow(), i)) {
                        return false;
                    }
                }
            }
            //Category-1, Condition-2, move to the right, if the current column is less than the input one.
            //Checks every square between the current position to the destination, if there are any chess pieces.
            else if (getColumn() < column) {
                for (int index = (getColumn() + 1); index <= column; index++) {
                    getBoardData().hasPiece(getRow(), index);
                    if (getBoardData().hasPiece(getRow(), index)) {
                        return false;
                    }
                }
            }
            //Any cases besides those two, return false
            else {
                return false;
            }
        }
        //This is the category-2, check the column is the same or not, if true...
        else if (getColumn() == column && row <= getGame().getNumRows()) {
            //Category-2, condition-3, move down, if the current row is greater than the input one
            //Checks every square between the current position to the destination, if there are any chess pieces.
            if (getRow() > row) {
                for (int j = (getRow() - 1); j >= row; j--) {
                    getBoardData().hasPiece(j, getColumn());
                    if (getBoardData().hasPiece(j, getColumn())) {
                        return false;
                    }
                }
            }
            //Category-2, condition-4, move up, if the current row is smaller than the input one
            //Checks every square between the current position to the destination, if there are any chess pieces.
            else if (getRow() < row) {
                for (int k = (getRow() + 1); k <= row; k++) {
                    getBoardData().hasPiece(k, getColumn());
                    if (getBoardData().hasPiece(k, getColumn())) {
                        return false;
                    }
                }
            }
            //Any cases besides those two, return false
            else
                return false;
        }
        //ANY condition besides the MAIN TWO CATEGORIES, returns false
        else {
            return false;
        }
        //If there are no pieces on the way to its destination, which means go through the loop successfully, return true
        //It is legal to move
        return true;
    }
}