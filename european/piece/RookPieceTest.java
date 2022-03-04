//CSDS 132 YINGYU ZHU

package chess.european.piece;

import chess.BoardData;
import chess.ChessGame;
import chess.SwingChessBoard;
import chess.SwingChessBoardDisplay;
import chess.european.EuropeanChess;
import chess.european.SwingEuropeanChessDisplay;
import org.junit.Test;

import static org.junit.Assert.*;

public class RookPieceTest {

    @Test
    public void testGetLabel() {
        EuropeanChess JackKnack = new EuropeanChess();
        SwingEuropeanChessDisplay Jack = new SwingEuropeanChessDisplay();
        BoardData j = new SwingChessBoard(8, 8, Jack, JackKnack).getBoardData();
        RookPiece rp = new RookPiece(j, JackKnack, ChessGame.Side.SOUTH);
        assertEquals("Test if the label is R", "R", rp.getLabel());
    }


    @Test
    public void testIsLegalNonCaptureMove() {
        chess.european.EuropeanChess JackKnack = new chess.european.EuropeanChess();
        SwingChessBoardDisplay Jack = new chess.european.SwingEuropeanChessDisplay();
        BoardData j = new SwingChessBoard(8, 8, Jack, JackKnack).getBoardData();
        RookPiece rp = new RookPiece(j, JackKnack, ChessGame.Side.NORTH);
        j.addPiece(rp, 0, 0);
        assertTrue("Testing north side moving to (1, 0)", rp.isLegalNonCaptureMove(1, 0));
        assertFalse("Testing north side moving to (1, 2)", rp.isLegalNonCaptureMove(1, 2));
    }

    @Test
    public void testisLegalCaptureMove() {
        chess.european.EuropeanChess JackKnack = new chess.european.EuropeanChess();
        chess.european.SwingEuropeanChessDisplay Jack = new chess.european.SwingEuropeanChessDisplay();
        BoardData j = new SwingChessBoard(8, 8, Jack, JackKnack).getBoardData();
        RookPiece rp = new RookPiece(j, JackKnack, ChessGame.Side.NORTH);
        j.addPiece(rp, 0, 0);
        assertTrue("Testing if is legal CaptureMove north side moving to (1, 0)", rp.isLegalCaptureMove(1, 0));
        assertFalse("Testing if is legal CaptureMove north side moving to (1, 2)", rp.isLegalCaptureMove(1, 2));
    }

}
