//CSDS 132 YINGYU ZHU

package chess.european.piece;

import chess.BoardData;
import chess.ChessGame;
import chess.european.EuropeanChess;
import org.junit.Test;

import static org.junit.Assert.*;

public class BishopPieceTest {

    @Test
    public void testGetLabel() {
        EuropeanChess JackKnack = new EuropeanChess();
        BoardData boardData = new BoardData();
        BishopPiece bp = new BishopPiece(boardData, JackKnack, ChessGame.Side.SOUTH);
        assertEquals("Test if the label is B", "B", bp.getLabel());
    }

    @Test
    public void testIsLegalNonCaptureMove() {
        EuropeanChess JackKnack = new EuropeanChess();
        BoardData boardData = new BoardData();
        BishopPiece bp = new BishopPiece(boardData, JackKnack, ChessGame.Side.SOUTH);
        boardData.addPiece(bp, 4, 4);
        assertTrue("Testing IsLegalNonCaptureMove south side moving to (1, 1)", bp.isLegalNonCaptureMove(1, 1));
        assertFalse("Testing IsLegalNonCaptureMove south side moving to (3, 4)", bp.isLegalNonCaptureMove(3, 4));

    }

    @Test
    public void testIsLegalCaptureMove() {
        EuropeanChess JackKnack = new EuropeanChess();
        BoardData boardData = new BoardData();
        BishopPiece bp = new BishopPiece(boardData, JackKnack, ChessGame.Side.SOUTH);
        boardData.addPiece(bp, 4, 4);
        assertTrue("Testing IsLegalCaptureMove south side moving to (1, 1)", bp.isLegalCaptureMove(1, 1));
        assertFalse("Testing IsLegalCaptureMove south side moving to (3, 4)", bp.isLegalCaptureMove(3, 4));

    }
}
