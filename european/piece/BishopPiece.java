//CSDS 132 YINGYU ZHU

package chess.european.piece;

import chess.BoardData;
import chess.ChessGame;
import chess.ChessPiece;

//CSDS 132 Yingyu Zhu
//This is the Bishop class which extends chess.ChessPiece class while implement chess.ChessBoard
//It override the capture and non-capture methods to determine if it is a legal move
public class BishopPiece extends ChessPiece {

    //Constructor
    public BishopPiece(BoardData boardData, ChessGame game, ChessGame.Side side) {
        super(boardData, game, side);
    }


    //Getter method to get label
    public String getLabel() {
        return "B";
    }
    //This is to check if it is legal to move this bishop piece from current position to the input position.
    //Bishop only move diagonally, so there are four directions. Divided into two categories
    //If it goes 1. up+right 2. down+left---the sum of coordinates(row+column) will be the same for all cases---Categories 1
    //If it goes 3. up+left 4. down+right---the difference of the coordinates (column - row) will be the same for all cases---Categories 2


    @Override
    public boolean isLegalNonCaptureMove(int row, int column) {

        //So we check for the categories1 1. If the sum are the same, the input values are less or equal than the numRows/Columns and bigger than zero
        if ((row + column) == (getRow() + getColumn()) && row <= getGame().getNumRows() && column <= getGame().getNumColumns() && row >= 0 && column >= 0) {

            //Then we check for conditions 1 and 2 separately.
            //Check for 1. up+right. So input row must be bigger and input columns must be smaller.
            //use for loop to check if there are any pieces in the way to the destination. Return false is there is one immediately
            if (row < getRow() && column > getColumn()) {
                //This int variables is to store the column value
                //And it varies in different loops to help check if there are pieces or not in the pathway to destination.
                int index = this.getColumn() + 1;
                for (int i = (getRow() - 1); i < row; i--) {
                    getBoardData().hasPiece(i, (index));
                    if (getBoardData().hasPiece(i, index)) {
                        return false;
                    }
                    index = index + 1;
                }
            }
            //Here is condition 2. down+left. input row and column need to be smaller
            //use for loop to check if there are any pieces in the way to the destination. Return false is there is one immediately
            else if (row > getRow() && column < getColumn()) {
                //This int variables is to store the column value
                //And it varies in different loops to help check if there are pieces or not in the pathway to destination.
                int x = this.getColumn() - 1;
                for (int j = (getRow() + 1); j > row; j++) {
                    getBoardData().hasPiece(j, x);
                    if (getBoardData().hasPiece(j, x)) {
                        return false;
                    }
                    x = x - 1;
                }
            }
            //anything else, such as input row = current row or input column = current column.
            //return false
            else
                return false;
        }

        //Here is the Category-2 which checks 3 up+left and 4 down+right separately
        //use for loop to check if there are any pieces in the way to the destination. Return false is there is one immediately
        else if ((column - row) == (getColumn() - getRow()) && row >= 0 && column >= 0) {
            //This int variables is to store the column value
            //And it varies in different loops to help check if there are pieces or not in the pathway to destination.
            int c = this.getColumn() - 1;
            //Here is the condition 3 up+left. input row and column must be bigger. Then go through the loop
            if (row < getRow() && column < getColumn()) {
                for (int k = (getRow() - 1); k < row; k--) {
                    getBoardData().hasPiece(k, c);
                    if (getBoardData().hasPiece(k, c)) {
                        return false;
                    }
                    c = c - 1;
                }
            }
            //Here is the condition 4 down+right. Input row needs to be smaller and input column needs to be bigger
            //Go through the loop and return false if there are any pieces on the way.
            else if (row > getRow() && column > getColumn()) {
                //This int variables is to store the column value
                //And it varies in different loops to help check if there are pieces or not in the pathway to destination.
                int v = this.getColumn() + 1;
                for (int n = (getRow() + 1); n > row; n++) {
                    getBoardData().hasPiece(n, v);
                    if (getBoardData().hasPiece(n, v)) {
                        return false;
                    }
                    v = v + 1;
                }
            }
        }
        //ANY condition besides the MAIN TWO CATEGORIES, returns false
        else {
            return false;
        }
        //If there are no pieces on the way to its destination, which means go through the loop successfully, return true
        //It is legal to move
        return true;
    }

    //This function is the exactly the same as the one above.
    @Override
    public boolean isLegalCaptureMove(int row, int column) {
        //So we check for the categories1 1. If the sum are the same, the input values are less or equal than the numRows/Columns and bigger than zero
        if ((row + column) == (getRow() + getColumn()) && row <= getGame().getNumRows() && column <= getGame().getNumColumns() && row >= 0 && column >= 0) {

            //Then we check for conditions 1 and 2 separately.
            //Check for 1. up+right. So input row must be bigger and input columns must be smaller.
            //use for loop to check if there are any pieces in the way to the destination. Return false is there is one immediately
            if (row < getRow() && column > getColumn()) {

                //This int variables is to store the column value
                //And it varies in different loops to help check if there are pieces or not in the pathway to destination.
                int index2 = this.getColumn() + 1;
                for (int i = (getRow() - 1); i < row; i--) {
                    getBoardData().hasPiece(i, (index2));
                    if (getBoardData().hasPiece(i, index2)) {
                        return false;
                    }
                    index2 = index2 + 1;
                }
            }

            //Here is condition 2. down+left. input row and column need to be smaller
            //use for loop to check if there are any pieces in the way to the destination. Return false is there is one immediately
            else if (row > getRow() && column < getColumn()) {
                //This int variables is to store the column value
                //And it varies in different loops to help check if there are pieces or not in the pathway to destination.
                int b = this.getColumn() - 1;
                for (int j = (getRow() + 1); j > row; j++) {
                    getBoardData().hasPiece(j, b);
                    if (getBoardData().hasPiece(j, b)) {
                        return false;
                    }
                    b = b - 1;
                }
            }
            //anything else, such as input row = current row or input column = current column.
            //return false
            else
                return false;
        }

        //Here is the Category-2 which checks 3 up+left and 4 down+right separately
        //use for loop to check if there are any pieces in the way to the destination. Return false is there is one immediately
        else if ((column - row) == (getColumn() - getRow()) && row >= 0 && column >= 0) {

            //This int variables is to store the column value
            //And it varies in different loops to help check if there are pieces or not in the pathway to destination.
            int a = this.getColumn() - 1;
            //Here is the condition 3 up+left. input row and column must be bigger. Then go through the loop
            if (row < getRow() && column < getColumn()) {
                for (int k = (getRow() - 1); k < row; k--) {
                    getBoardData().hasPiece(k, a);
                    if (getBoardData().hasPiece(k, a)) {
                        return false;
                    }
                    a = a - 1;
                }
            }
            //Here is the condition 4 down+right. Input row needs to be smaller and input column needs to be bigger
            //Go through the loop and return false if there are any pieces on the way.
            else if (row > getRow() && column > getColumn()) {
                //This int variables is to store the column value
                //And it varies in different loops to help check if there are pieces or not in the pathway to destination.
                int e = this.getColumn() + 1;
                for (int n = (getRow() + 1); n > row; n++) {
                    getBoardData().hasPiece(n, e);
                    if (getBoardData().hasPiece(n, e)) {
                        return false;
                    }
                    e = e + 1;
                }
            }
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