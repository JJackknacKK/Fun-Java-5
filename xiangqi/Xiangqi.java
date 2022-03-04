//CSDS 132 YINGYU ZHU
package chess.xiangqi;

import chess.*;
import chess.xiangqi.piece.*;

//This is the class that complete all the necessary methods that needs to launch the game
public class Xiangqi implements ChessGame {

    //we create a variable turn and use it do decide which payers gets to pally first
    //and then we use it as the to switch players
    private ChessGame.Side turn = ChessGame.Side.NORTH;

    public static boolean isPalace(int row, int col) {
        switch (row) {
            case 0:
            case 1:
            case 2:
            case 7:
            case 8:
            case 9:
                switch (col) {
                    case 3:
                    case 4:
                    case 5:
                        return true;
                }
        }
        return false;
    }

    //This is the function, which checks if the piece is legal to play
    //By checking the piece belongs to whom using turn and getSide()
    public boolean legalPieceToPlay(ChessPiece piece, int toRow, int toColumn) {
        return turn == (piece.getSide());
    }

    //This is the function we need to call every time when we want to move a piece
    //It checks if is legal to move and then check the side of the piece to see if it belongs to the same side player
    //Then we remove the old piece from the current position and add a new one to the destination
    //Then call move done, (some pieces such as pawn and king are different
    //Finally we switch players, and return true or false to show if we moved the piece or not.
    public boolean makeMove(final ChessPiece piece, int toRow, int toColumn) {
        if (piece.isLegalMove(toRow, toColumn) && turn == (piece.getSide())) {
            piece.getBoardData().removePiece(piece.getRow(), piece.getColumn());
            piece.getBoardData().addPiece(piece, toRow, toColumn);
            piece.moveDone();
            if (turn == ChessGame.Side.NORTH) {
                turn = ChessGame.Side.SOUTH;
            } else {
                turn = ChessGame.Side.NORTH;
            }
        }
        return true;
    }

    @Override
    public int getNumRows() {
        return 10;
    }

    @Override
    public int getNumColumns() {
        return 9;
    }

    @Override
    public void startGame(ChessBoard board) {
        BoardData boardData = board.getBoardData();
        for (int col = 0; col < getNumColumns(); col++) {
            for (int row = 0; row < getNumRows(); row++) {
                switch (row) {
                    // North
                    case 0:
                        switch (col) {
                            case 0:
                            case 8:
                                boardData.addPiece(new RookPiece(boardData, this, Side.NORTH), new Position(row, col));
                                break;
                            case 1:
                            case 7:
                                boardData.addPiece(new HorsePiece(boardData, this, Side.NORTH), new Position(row, col));
                                break;
                            case 2:
                            case 6:
                                boardData.addPiece(new ElephantPiece(boardData, this, Side.NORTH), new Position(row, col));
                                break;
                            case 3:
                            case 5:
                                boardData.addPiece(new GuardPiece(boardData, this, Side.NORTH), new Position(row, col));
                                break;
                            case 4:
                                boardData.addPiece(new XiangqiKingPiece(boardData, this, Side.NORTH), new Position(row, col));
                                break;
                        }
                        break;
                    case 2:
                        switch (col) {
                            case 1:
                            case 7:
                                boardData.addPiece(new CannonPiece(boardData, this, Side.NORTH), new Position(row, col));
                                break;
                        }
                        break;
                    case 3:
                        switch (col) {
                            case 0:
                            case 2:
                            case 4:
                            case 6:
                            case 8:
                                boardData.addPiece(new SoldierPiece(boardData, this, Side.NORTH), new Position(row, col));
                                break;
                        }
                        break;

                    // South
                    case 6:
                        switch (col) {
                            case 0:
                            case 2:
                            case 4:
                            case 6:
                            case 8:
                                boardData.addPiece(new SoldierPiece(boardData, this, Side.SOUTH), new Position(row, col));
                                break;
                        }
                        break;
                    case 7:
                        switch (col) {
                            case 1:
                            case 7:
                                boardData.addPiece(new CannonPiece(boardData, this, Side.SOUTH), new Position(row, col));
                                break;
                        }
                        break;
                    case 9:
                        switch (col) {
                            case 0:
                            case 8:
                                boardData.addPiece(new RookPiece(boardData, this, Side.SOUTH), new Position(row, col));
                                break;
                            case 1:
                            case 7:
                                boardData.addPiece(new HorsePiece(boardData, this, Side.SOUTH), new Position(row, col));
                                break;
                            case 2:
                            case 6:
                                boardData.addPiece(new ElephantPiece(boardData, this, Side.SOUTH), new Position(row, col));
                                break;
                            case 3:
                            case 5:
                                boardData.addPiece(new GuardPiece(boardData, this, Side.SOUTH), new Position(row, col));
                                break;
                            case 4:
                                boardData.addPiece(new XiangqiKingPiece(boardData, this, Side.SOUTH), new Position(row, col));
                                break;
                        }
                        break;
                }
            }
        }
    }
}