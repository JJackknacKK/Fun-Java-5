//CSDS 132 YINGYU ZHU

package chess.european.piece;

import chess.BoardData;
import chess.ChessGame;
import chess.ChessPiece;

//This is the Pawn class which extends chess.ChessPiece class while implement chess.ChessBoard
//It override the capture and non-capture methods to determine if it is a legal move
// A class for The Pawn piece
public class PawnPiece extends ChessPiece {

    public PawnPiece(BoardData boardData, ChessGame game, ChessGame.Side side) {
        super(boardData, game, side);
    }

    //Getter method to get label
    public String getLabel() {
        return "P";
    }

    //This is the method that takes two inputs, that checks if the destination has a piece or not, then check if it is at the same column
    //Then check if it is, then check if the destination is only one square away from the current position
    //Then check if the input row is smaller than numRows;
    //Assign it to capture or non-capture.
    @Override
    public boolean isLegalMove(int toRow, int toColumn) {
        if (getSide() == ChessGame.Side.NORTH && toColumn == getColumn()
                && !getBoardData().hasPiece(toRow, toColumn)) {
            return isLegalNonCaptureMove(toRow, toColumn);
        }
        if (getSide() == ChessGame.Side.SOUTH && toColumn == getColumn()
                && !getBoardData().hasPiece(toRow, toColumn)) {
            return isLegalNonCaptureMove(toRow, toColumn);
        }
        if (getSide() == ChessGame.Side.NORTH && toRow == getRow() + 1 && (toColumn == getColumn() + 1 || toColumn == getColumn() - 1
                && getBoardData().hasPiece(toRow, toColumn) && getBoardData().getPiece(toRow, toColumn).getSide() != getSide())) {
            return isLegalCaptureMove(toRow, toColumn);
        }
        if (getSide() == ChessGame.Side.SOUTH && toRow == getRow() - 1 && (toColumn == getColumn() + 1 || toColumn == getColumn() - 1
                && getBoardData().hasPiece(toRow, toColumn) && getBoardData().getPiece(toRow, toColumn).getSide() != getSide())) {
            return isLegalCaptureMove(toRow, toColumn);
        } else {
            return false;
        }
    }


    //This method checks if the the input position has an enemy pieces, return true
    //rest return false
    @Override
    public boolean isLegalCaptureMove(int row, int column) {
        return true;
    }

    //This method checks if it is the first move, return true if it is first move;
    //for normal cases, just check if the inputs are the same position as one square away from current position.
    //else return false
    @Override
    public boolean isLegalNonCaptureMove(int row, int column) {
        if (getSide() == ChessGame.Side.NORTH && getIsFirstMove() && (row == getRow() + 1 || row == getRow() + 2)) {
            return true;
        }
        if (getSide() == ChessGame.Side.SOUTH && getIsFirstMove() && (row == getRow() - 1 || row == getRow() - 2)) {
            return true;
        }
        if (getSide() == ChessGame.Side.NORTH && (row == getRow() + 1)) {
            return true;
        }
        return getSide() == ChessGame.Side.SOUTH && (row == getRow() - 1);
    }

    // This sets isFirstMove to be false after the pawn has moved.
    @Override
    public void moveDone() {
        this.setIsFirstMove();
        this.Change();
    }

    //This is the method that if the pawn reach the end opposite row, it will turn to be any piece the player choose to be.
    //But not King
    public void Change() {
        if ((getSide() == ChessGame.Side.SOUTH && getRow() == 0)
                || (getSide() == ChessGame.Side.NORTH && getRow() == 7)) {
            getBoardData().removePiece(getRow(), getColumn());
            String s = javax.swing.JOptionPane.showInputDialog("choose from queen, rook, bishop, or knight");
            ChessPiece newPiece;
            if (s.equals("queen")) {
                newPiece = new QueenPiece(getBoardData(), getGame(), getSide());
                getBoardData().addPiece(newPiece, getRow(), getColumn());
            }
            if (s.equals("bishop")) {
                newPiece = new BishopPiece(getBoardData(), getGame(), getSide());
                getBoardData().addPiece(newPiece, getRow(), getColumn());
            }
            if (s.equals("rook")) {
                newPiece = new RookPiece(getBoardData(), getGame(), getSide());
                getBoardData().addPiece(newPiece, getRow(), getColumn());
            }
            if (s.equals("knight")) {
                newPiece = new KnightPiece(getBoardData(), getGame(), getSide());
                getBoardData().addPiece(newPiece, getRow(), getColumn());
            }
        }
    }
}