//CSDS 132 YINGYU ZHU

package chess.european.piece;

import chess.BoardData;
import chess.ChessGame;
import chess.SwingChessBoard;
import chess.european.EuropeanChess;
import chess.european.SwingEuropeanChessDisplay;
import org.junit.Test;

import static org.junit.Assert.*;

public class QueenPieceTest {

    @Test
    public void testGetLabel() {
        EuropeanChess JackKnack = new EuropeanChess();
        SwingEuropeanChessDisplay Jack = new SwingEuropeanChessDisplay();
        BoardData j = new SwingChessBoard(8, 8, Jack, JackKnack).getBoardData();
        QueenPiece qp = new QueenPiece(j, JackKnack, ChessGame.Side.SOUTH);
        assertEquals("Test if the label is Q", "Q", qp.getLabel());
    }


    @Test
    public void testIsLegalNonCaptureMove() {
        EuropeanChess JackKnack = new EuropeanChess();
        BoardData j = new BoardData();
        QueenPiece qp = new QueenPiece(j, JackKnack, ChessGame.Side.SOUTH);
        j.addPiece(qp, 0, 0);
        assertFalse("Testing south side moving to (1, 0)", qp.isLegalNonCaptureMove(1, 0));
        QueenPiece qp2 = new QueenPiece(j, JackKnack, ChessGame.Side.SOUTH);
        j.addPiece(qp2, 5, 5);
        assertFalse("Testing south side moving to (5, 4)", qp.isLegalNonCaptureMove(5, 4));

    }

    @Test
    public void testisLegalCaptureMove() {
        EuropeanChess JackKnack = new EuropeanChess();
        BoardData j = new BoardData();
        QueenPiece qp = new QueenPiece(j, JackKnack, ChessGame.Side.SOUTH);
        j.addPiece(qp, 3, 3);
        assertFalse("Testing south side moving to (1, 0)", qp.isLegalCaptureMove(1, 0));
        assertTrue("Testing south side moving to (2, 4)", qp.isLegalCaptureMove(2, 4));
    }
}
