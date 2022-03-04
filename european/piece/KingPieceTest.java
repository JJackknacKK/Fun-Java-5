//CSDS 132 YINGYU ZHU

package chess.european.piece;

import chess.BoardData;
import chess.ChessGame;
import chess.SwingChessBoard;
import chess.european.EuropeanChess;
import chess.european.SwingEuropeanChessDisplay;
import org.junit.Test;

import static org.junit.Assert.*;

public class KingPieceTest {

    @Test
    public void testGetLabel() {
        EuropeanChess JackKnack = new EuropeanChess();
        BoardData boardData = new BoardData();
        KingPiece bp = new KingPiece(boardData, JackKnack, ChessGame.Side.SOUTH);
        assertEquals("Test if the label is K", "K", bp.getLabel());
    }

    @Test
    public void testLegalNonCaptureMove() {
        EuropeanChess JackKnack = new EuropeanChess();
        SwingEuropeanChessDisplay Jack = new SwingEuropeanChessDisplay();
        BoardData boardData = new SwingChessBoard(JackKnack.getNumRows(), JackKnack.getNumColumns(), Jack, JackKnack).getBoardData();
        KingPiece kp = new KingPiece(boardData, JackKnack, ChessGame.Side.NORTH);
        boardData.addPiece(kp, 4, 4);
        assertFalse("Testing IsLegalNonCaptureMove north side moving to (1, 1)", kp.isLegalNonCaptureMove(1, 1));
        assertTrue("Testing IsLegalNonCaptureMove north side moving to (3, 4)", kp.isLegalNonCaptureMove(3, 4));

    }

    @Test
    public void testLegalCaptureMove() {
        EuropeanChess JackKnack = new EuropeanChess();
        SwingEuropeanChessDisplay Jack = new SwingEuropeanChessDisplay();
        BoardData boardData = new BoardData();
        KingPiece kp = new KingPiece(boardData, JackKnack, ChessGame.Side.NORTH);
        boardData.addPiece(kp, 4, 4);
        assertFalse("Testing IsLegalCaptureMove north side moving to (1, 1)", kp.isLegalCaptureMove(1, 1));
        assertTrue("Testing IsLegalCaptureMove north side moving to (3, 4)", kp.isLegalCaptureMove(3, 4));

    }
}
