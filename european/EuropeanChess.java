//CSDS 132 YINGYU ZHU

package chess.european;

import chess.BoardData;
import chess.ChessBoard;
import chess.ChessGame;
import chess.ChessPiece;
import chess.european.piece.*;

//This is the class that complete all the necessary methods that needs to launch the game
public class EuropeanChess implements ChessGame {

    //we create a variable turn and use it do decide which payers gets to pally first
    //and then we use it as the to switch players
    private ChessGame.Side turn = ChessGame.Side.NORTH;

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
        try {
            if (piece.isLegalMove(toRow, toColumn)) {
                if (turn == (piece.getSide())) {
                    piece.getBoardData().movePiece(piece, toRow, toColumn);
                    piece.moveDone();
                    if (turn == Side.NORTH) {
                        turn = Side.SOUTH;
                    } else if (turn == Side.SOUTH) {
                        turn = Side.NORTH;
                    }
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public int getNumRows() {
        return 8;
    }

    @Override
    public int getNumColumns() {
        return 8;
    }

    @Override
    public void startGame(ChessBoard board) {
        BoardData boardData = board.getBoardData();
        for (int i = 0; i < getNumColumns(); i++) {
            boardData.addPiece(new PawnPiece(boardData, this, ChessGame.Side.NORTH), 1, i);
            boardData.addPiece(new PawnPiece(boardData, this, ChessGame.Side.SOUTH), 6, i);
            if (i == 0 || i == 7) {
                boardData.addPiece(new RookPiece(boardData, this, ChessGame.Side.NORTH), 0, i);
                boardData.addPiece(new RookPiece(boardData, this, ChessGame.Side.SOUTH), 7, i);
            }
            if (i == 6 || i == 1) {
                boardData.addPiece(new KnightPiece(boardData, this, ChessGame.Side.NORTH), 0, i);
                boardData.addPiece(new KnightPiece(boardData, this, ChessGame.Side.SOUTH), 7, i);
            }
            if (i == 2 || i == 5) {
                boardData.addPiece(new BishopPiece(boardData, this, ChessGame.Side.NORTH), 0, i);
                boardData.addPiece(new BishopPiece(boardData, this, ChessGame.Side.SOUTH), 7, i);
            }
            if (i == 3) {
                boardData.addPiece(new QueenPiece(boardData, this, ChessGame.Side.NORTH), 0, i);
                boardData.addPiece(new QueenPiece(boardData, this, ChessGame.Side.SOUTH), 7, i);
            }
            if (i == 4) {
                boardData.addPiece(new KingPiece(boardData, this, ChessGame.Side.NORTH), 0, i);
                boardData.addPiece(new KingPiece(boardData, this, ChessGame.Side.SOUTH), 7, i);
            }
        }
    }
}