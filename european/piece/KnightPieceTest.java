//CSDS 132 YINGYU ZHU

package chess.european.piece;

import chess.BoardData;
import chess.ChessGame;
import chess.Position;
import chess.european.EuropeanChess;
import org.junit.Test;

import static org.junit.Assert.*;

public class KnightPieceTest {

    @Test
    public void testGetLabel() {
        EuropeanChess JackKnack = new EuropeanChess();
        BoardData boardData = new BoardData();
        KnightPiece bp = new KnightPiece(boardData, JackKnack, ChessGame.Side.SOUTH);
        assertEquals("Test if the label is N", "N", bp.getLabel());
    }

    @Test
    public void testIsLegalNonCaptureMove() {
        EuropeanChess JackKnack = new EuropeanChess();
        BoardData j = new BoardData();
        KnightPiece kp = new KnightPiece(j, JackKnack, ChessGame.Side.NORTH);
        j.addPiece(kp, new Position(4, 4));
        assertFalse("Testing IsLegalNonCaptureMove north side moving to (1, 1)", kp.isLegalNonCaptureMove(1, 1));
        assertFalse("Testing IsLegalNonCaptureMove north side moving to (7, 1)", kp.isLegalNonCaptureMove(7, 1));
        assertTrue("Testing IsLegalNonCaptureMove north side moving to (5, 2)", kp.isLegalNonCaptureMove(5, 2));

    }

    @Test
    public void testIsLegalCaptureMove() {
        EuropeanChess JackKnack = new EuropeanChess();
        BoardData j = new BoardData();
        KnightPiece kp = new KnightPiece(j, JackKnack, ChessGame.Side.NORTH);
        j.addPiece(kp, new Position(4, 4));
        assertFalse("Testing IsLegalCaptureMove north side moving to (1, 1)", kp.isLegalCaptureMove(1, 1));
        assertFalse("Testing IsLegalCaptureMove north side moving to (7, 1)", kp.isLegalCaptureMove(7, 1));
        assertTrue("Testing IsLegalCaptureMove north side moving to (5, 2)", kp.isLegalCaptureMove(5, 2));

    }

}
