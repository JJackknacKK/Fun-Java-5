//CSDS 132 YINGYU ZHU

package chess.xiangqi.piece;

import chess.BoardData;
import chess.ChessGame;
import chess.ChessPiece;
import chess.xiangqi.Xiangqi;
import org.junit.Test;

import static org.junit.Assert.*;

public class SoldierPieceTest {

    @Test
    public void getLabel() {
        assertNotNull(new SoldierPiece(new BoardData(), new Xiangqi(), ChessGame.Side.NORTH).getLabel());
    }

    @Test
    public void isLegalNonCaptureMove() {
        BoardData boardData = new BoardData();
        ChessGame chessGame = new Xiangqi();
        ChessPiece piece1 = new SoldierPiece(boardData, chessGame, ChessGame.Side.NORTH);
        ChessPiece piece2 = new SoldierPiece(boardData, chessGame, ChessGame.Side.SOUTH);
        ChessPiece piece3 = new SoldierPiece(boardData, chessGame, ChessGame.Side.WEST);
        boardData.addPiece(piece1, 3, 4);
        boardData.addPiece(piece2, 6, 4);
        boardData.addPiece(piece3, 5, 5);
        assertFalse(piece3.isLegalNonCaptureMove(5, 4));
        assertTrue(piece1.isLegalNonCaptureMove(4, 4));
        assertTrue(piece2.isLegalNonCaptureMove(5, 4));
        assertFalse(piece1.isLegalNonCaptureMove(5, 4));
        assertFalse(piece2.isLegalNonCaptureMove(4, 4));
        boardData.movePiece(piece1, 6, 4);
        boardData.addPiece(piece2, 3, 4);
        assertTrue(piece1.isLegalNonCaptureMove(7, 4));
        assertTrue(piece2.isLegalNonCaptureMove(2, 4));
        assertTrue(piece1.isLegalNonCaptureMove(6, 5));
        assertTrue(piece2.isLegalNonCaptureMove(3, 5));
    }
}