//CSDS 132 YINGYU ZHU

package chess.xiangqi.piece;

import chess.BoardData;
import chess.ChessGame;
import chess.ChessPiece;
import chess.xiangqi.Xiangqi;
import org.junit.Test;

import static org.junit.Assert.*;

public class XiangqiKingPieceTest {

    @Test
    public void getLabel() {
        assertNotNull(new XiangqiKingPiece(new BoardData(), new Xiangqi(), ChessGame.Side.NORTH).getLabel());
    }

    @Test
    public void isLegalNonCaptureMove() {
        BoardData boardData = new BoardData();
        ChessGame xiangqi = new Xiangqi();
        ChessPiece piece1 = new XiangqiKingPiece(boardData, xiangqi, ChessGame.Side.NORTH);
        ChessPiece piece2 = new XiangqiKingPiece(boardData, xiangqi, ChessGame.Side.SOUTH);
        boardData.addPiece(piece1, 0, 4);
        boardData.addPiece(piece2, 9, 3);
        assertTrue(piece1.isLegalNonCaptureMove(1, 4));
        assertTrue(piece2.isLegalNonCaptureMove(8, 3));
        assertFalse(piece2.isLegalNonCaptureMove(9, 4));
        assertFalse(piece1.isLegalNonCaptureMove(1, 3));
        boardData.addPiece(new RookPiece(boardData, xiangqi, ChessGame.Side.SOUTH), 5, 4);
        assertTrue(piece2.isLegalNonCaptureMove(9, 4));
        assertFalse(piece1.isLegalNonCaptureMove(0, 3));
        boardData.addPiece(new RookPiece(boardData, xiangqi, ChessGame.Side.NORTH), 5, 3);
        assertTrue(piece1.isLegalNonCaptureMove(0, 3));
    }
}