//CSDS 132 YINGYU ZHU

package chess.european.piece;

import chess.BoardData;
import chess.ChessGame;
import chess.SwingChessBoard;
import chess.european.EuropeanChess;
import chess.european.SwingEuropeanChessDisplay;
import org.junit.Test;

import static org.junit.Assert.*;

public class PawnPieceTest {

    @Test
    public void testGetLabel() {
        EuropeanChess JackKnack = new EuropeanChess();
        SwingEuropeanChessDisplay Jack = new SwingEuropeanChessDisplay();
        BoardData j = new SwingChessBoard(8, 8, Jack, JackKnack).getBoardData();
        PawnPiece pp = new PawnPiece(j, JackKnack, ChessGame.Side.SOUTH);
        assertEquals("Test if the label is P", "P", pp.getLabel());
    }

    @Test
    public void testIsLegalMove() {
        EuropeanChess JackKnack = new EuropeanChess();
        SwingEuropeanChessDisplay Jack = new SwingEuropeanChessDisplay();
        BoardData j = new SwingChessBoard(8, 8, Jack, JackKnack).getBoardData();
        PawnPiece pp = new PawnPiece(j, JackKnack, ChessGame.Side.SOUTH);
        j.addPiece(pp, 2, 3);
        assertFalse("Testing IsLegalMove south side moving to (3, 3)", pp.isLegalMove(3, 3));
        assertFalse("Testing IsLegalMove south side moving to (2, 4)", pp.isLegalMove(2, 4));

    }

    @Test
    public void testIsLegalCaptureMove() {
        EuropeanChess JackKnack = new EuropeanChess();
        BoardData j = new BoardData();
        PawnPiece pp = new PawnPiece(j, JackKnack, ChessGame.Side.SOUTH);
        j.addPiece(pp, 2, 3);
        assertTrue("Testing IsLegalCaptureMove south side moving to (1, 0)", pp.isLegalCaptureMove(1, 0));
        assertTrue("Testing IsLegalCaptureMove south side moving to (2, 4)", pp.isLegalCaptureMove(2, 4));

    }

    @Test
    public void testIsLegalNonCaptureMove() {
        EuropeanChess JackKnack = new EuropeanChess();
        SwingEuropeanChessDisplay Jack = new SwingEuropeanChessDisplay();
        BoardData j = new SwingChessBoard(8, 8, Jack, JackKnack).getBoardData();
        PawnPiece pp = new PawnPiece(j, JackKnack, ChessGame.Side.SOUTH);
        j.addPiece(pp, 2, 3);
        assertTrue("Testing IsLegalNonCaptureMove south side moving to (1, 0)", pp.isLegalNonCaptureMove(1, 0));
        assertFalse("Testing IsLegalNonCaptureMove south side moving to (2, 4)", pp.isLegalNonCaptureMove(2, 4));
    }

}
