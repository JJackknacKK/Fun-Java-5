//CSDS 132 YINGYU ZHU

package chess;

import chess.european.EuropeanChess;
import chess.european.SwingEuropeanChessDisplay;
import chess.xiangqi.SwingXiangqiDisplay;
import chess.xiangqi.Xiangqi;
import chess.xiangqi.piece.RookPiece;
import org.junit.Test;

import static org.junit.Assert.*;

public class SwingChessBoardTest {

    @Test
    public void getGameRules() {
        EuropeanChess europeanChess = new EuropeanChess();
        SwingChessBoard board = new SwingChessBoard(8, 8, new SwingEuropeanChessDisplay(), europeanChess);
        assertEquals(europeanChess, board.getGameRules());
    }

    @Test
    public void setGameRules() {
        EuropeanChess europeanChess = new EuropeanChess();
        SwingChessBoard board = new SwingChessBoard(8, 8, new SwingEuropeanChessDisplay(), europeanChess);
        Xiangqi xiangqi = new Xiangqi();
        board.setGameRules(xiangqi);
        assertEquals(xiangqi, board.getGameRules());
    }

    @Test
    public void numRows() {
        Xiangqi xiangqi = new Xiangqi();
        SwingChessBoard board = new SwingChessBoard(xiangqi.getNumRows(), xiangqi.getNumColumns(), new SwingXiangqiDisplay(), xiangqi);
        assertEquals(board.numRows(), xiangqi.getNumRows());
    }

    @Test
    public void numColumns() {
        Xiangqi xiangqi = new Xiangqi();
        SwingChessBoard board = new SwingChessBoard(xiangqi.getNumRows(), xiangqi.getNumColumns(), new SwingXiangqiDisplay(), xiangqi);
        assertEquals(board.numColumns(), xiangqi.getNumColumns());
    }

    @Test
    public void testAddPiece() {
        Xiangqi xiangqi = new Xiangqi();
        SwingChessBoard board = new SwingChessBoard(xiangqi.getNumRows(), xiangqi.getNumColumns(), new SwingXiangqiDisplay(), xiangqi);
        ChessPiece piece = new RookPiece(board.getBoardData(), new EuropeanChess(), ChessGame.Side.NORTH);
        board.addPiece(piece, 1, 2);
        assertTrue("Test if the last piece we just added to the board exists", board.hasPiece(1, 2) && board.getPiece(1, 2) == piece);
        assertEquals("Test if there's only one piece on the board", 1, board.getBoardData().countPiece());
    }

    @Test
    public void testRemovePiece() {
        Xiangqi xiangqi = new Xiangqi();
        SwingChessBoard board = new SwingChessBoard(xiangqi.getNumRows(), xiangqi.getNumColumns(), new SwingXiangqiDisplay(), xiangqi);
        BoardData boardData = board.getBoardData();
        ChessPiece piece = new RookPiece(boardData, new EuropeanChess(), ChessGame.Side.NORTH);
        boardData.addPiece(piece, new Position(1, 2));
        ChessPiece removedPiece = board.removePiece(1, 2);
        assertEquals("Test if the piece we just removed equals the piece we just created", removedPiece, piece);
        assertFalse("Test if the piece we just removed doesn't exist", board.hasPiece(1, 2));
        assertEquals("Test if there's no piece on the board", 0, boardData.countPiece());
        assertNull("Test if removePiece() returns null when there no piece on the specific position", board.removePiece(1, 2));
    }

    @Test
    public void squareThreatened() {
        Xiangqi xiangqi = new Xiangqi();
        SwingChessBoard board = new SwingChessBoard(xiangqi.getNumRows(), xiangqi.getNumColumns(), new SwingXiangqiDisplay(), xiangqi);
        BoardData boardData = board.getBoardData();
        ChessPiece piece = new RookPiece(boardData, new EuropeanChess(), ChessGame.Side.NORTH);
        ChessPiece piece2 = new RookPiece(boardData, new EuropeanChess(), ChessGame.Side.SOUTH);
        board.addPiece(piece, 1, 2);
        board.addPiece(piece2, 1, 4);
        assertTrue(board.squareThreatened(1, 2, piece));
        assertTrue(board.squareThreatened(1, 4, piece2));
        board.removePiece(1, 4);
        assertFalse(board.squareThreatened(1, 2, piece));
    }

    @Test
    public void getBoardData() {
        Xiangqi xiangqi = new Xiangqi();
        SwingChessBoard board = new SwingChessBoard(xiangqi.getNumRows(), xiangqi.getNumColumns(), new SwingXiangqiDisplay(), xiangqi);
        assertNotNull(board.getBoardData());
    }
}