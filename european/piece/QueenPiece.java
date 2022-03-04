//CSDS 132 YINGYU ZHU

package chess.european.piece;

import chess.BoardData;
import chess.ChessGame;
import chess.ChessPiece;

//CSDS132 Yingyu Zhu
//This is the queen class which extends chess.ChessPiece class while implement chess.ChessBoard
//It override the capture and non-capture methods to determine if it is a legal move
//Queen can move horizontal, vertical, and diagonal, So we check them separately.
//The two method are the exact same, with a different int variable. 
public class QueenPiece extends ChessPiece {


    public QueenPiece(BoardData boardData, ChessGame game, ChessGame.Side side) {
        super(boardData, game, side);
    }

    //Getter method to get label
    public String getLabel() {
        return "Q";
    }

    @Override
    public boolean isLegalNonCaptureMove(int row, int column) {

        //Horizontal
        //If the queen moves horizontally, it will move in the same row, but to different columns.
        //check if the row are the same, then check for columns. If input are smaller then it moves to the left
        //If input are bigger, then moves to the right. Additionally, both inout number must be greater than zero.
        if (getRow() == row && column <= getGame().getNumColumns() && column > 0 && row >= 0) {
            //This tests for the Queen moves to the right.
            //Checks every square between the current position to the destination, if there are any chess pieces.
            if (getColumn() > column) {
                for (int i = (getColumn() - 1); i >= column; i--) {
                    getBoardData().hasPiece(getRow(), i);
                    if (getBoardData().hasPiece(getRow(), i)) {
                        return false;
                    }
                }
            }
            //This tests for the Queen moves to the left.
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
        //Vertical
        //check if the column are the same, then check for rows. If input are smaller then it moves down
        //If input are bigger, then moves up. Additionally, both inout number must be greater than zero.
        if (getColumn() == column && row <= getGame().getNumRows()) {
            //Here tests if the Queen is moving down
            //Checks every square between the current position to the destination, if there are any chess pieces.
            if (getRow() > row) {
                for (int j = (getRow() - 1); j >= row; j--) {
                    getBoardData().hasPiece(j, getColumn());
                    if (getBoardData().hasPiece(j, getColumn())) {
                        return false;
                    }
                }
            }
            //Here tests if the Queen is moving up.
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
        //If queen move diagonally, so there are four directions. Divided into two categories
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

    @Override
    public boolean isLegalCaptureMove(int row, int column) {

        //This is the int variable that stores the column number later for the diagonal part
        int q = this.getColumn();

        //Horizontal
        //If the queen moves horizontally, it will move in the same row, but to different columns.
        //check if the row are the same, then check for columns. If input are smaller then it moves to the left
        //If input are bigger, then moves to the right. Additionally, both inout number must be greater than zero.
        if (getRow() == row && column <= getGame().getNumColumns() && column > 0 && row >= 0) {
            //This tests for the Queen moves to the right.
            //Checks every square between the current position to the destination, if there are any chess pieces.
            if (getColumn() > column) {
                for (int i = (getColumn() - 1); i >= column; i--) {
                    getBoardData().hasPiece(getRow(), i);
                    if (getBoardData().hasPiece(getRow(), i)) {
                        return false;
                    }
                }
            }
            //This tests for the Queen moves to the left.
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
        //Vertical
        //check if the column are the same, then check for rows. If input are smaller then it moves down
        //If input are bigger, then moves up. Additionally, both inout number must be greater than zero.
        if (getColumn() == column && row <= getGame().getNumRows()) {
            //Here tests if the Queen is moving down.
            //Checks every square between the current position to the destination, if there are any chess pieces.
            if (getRow() > row) {
                for (int j = (getRow() - 1); j >= row; j--) {
                    getBoardData().hasPiece(j, getColumn());
                    if (getBoardData().hasPiece(j, getColumn())) {
                        return false;
                    }
                }
            }
            //Here tests if the Queen is moving up.
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

        //If queen move diagonally, so there are four directions. Divided into two categories
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
}
  
