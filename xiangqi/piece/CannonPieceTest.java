//CSDS 132 YINGYU ZHU
package chess.xiangqi.piece;

import chess.BoardData;
import chess.ChessGame;
import chess.ChessPiece;
import chess.xiangqi.Xiangqi;
import org.junit.Test;

import static org.junit.Assert.*;

public class CannonPieceTest {

    @Test
    public void getLabel() {
        assertNotNull(new CannonPiece(new BoardData(), new Xiangqi(), ChessGame.Side.NORTH).getLabel());
    }

    @Test
    public void isLegalNonCaptureMove() {
        ChessGame xiangqi = new Xiangqi();
        BoardData boardData = new BoardData();
        ChessPiece piece = new CannonPiece(boardData, xiangqi, ChessGame.Side.NORTH);
        boardData.addPiece(piece, 2, 2);
        assertTrue(piece.isLegalNonCaptureMove(6, 2));
        boardData.addPiece(new RookPiece(boardData, xiangqi, ChessGame.Side.NORTH), 4, 2);
        assertFalse(piece.isLegalNonCaptureMove(6, 2));
    }

    @Test
    public void isLegalCaptureMove() {
        ChessGame xiangqi = new Xiangqi();
        BoardData boardData = new BoardData();
        ChessPiece piece = new CannonPiece(boardData, xiangqi, ChessGame.Side.NORTH);
        boardData.addPiece(piece, 2, 2);
        boardData.addPiece(new RookPiece(boardData, xiangqi, ChessGame.Side.SOUTH), 4, 2);
        boardData.addPiece(new RookPiece(boardData, xiangqi, ChessGame.Side.SOUTH), 6, 2);
        assertTrue(piece.isLegalCaptureMove(6, 2));
        assertFalse(piece.isLegalCaptureMove(4, 2));
    }
}