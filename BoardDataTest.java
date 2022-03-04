//CSDS 132 YINGYU ZHU

package chess;

import chess.european.EuropeanChess;
import chess.european.piece.RookPiece;
import org.junit.Test;

import java.util.function.Predicate;

import static org.junit.Assert.*;

public class BoardDataTest {

    @Test
    public void testAddPiece() {
        BoardData boardData = new BoardData();
        ChessPiece piece = new RookPiece(boardData, new EuropeanChess(), ChessGame.Side.NORTH);
        ChessPiece piece2 = new RookPiece(boardData, new EuropeanChess(), ChessGame.Side.SOUTH);
        boardData.addPiece(piece, 1, 2);
        boardData.addPiece(piece2, new Position(1, 2));
        assertTrue("Test if the last piece we just added to the board exists", boardData.hasPiece(new Position(1, 2)) && boardData.getPiece(new Position(1, 2)) == piece2);
        assertEquals("Test if there's only one piece on the board", 1, boardData.countPiece());
    }

    @Test
    public void testRemovePiece() {
        BoardData boardData = new BoardData();
        ChessPiece piece = new RookPiece(boardData, new EuropeanChess(), ChessGame.Side.NORTH);
        boardData.addPiece(piece, new Position(1, 2));
        ChessPiece removedPiece = boardData.removePiece(new Position(1, 2));
        assertEquals("Test if the piece we just removed equals the piece we just created", removedPiece, piece);
        assertFalse("Test if the piece we just removed doesn't exist", boardData.hasPiece(new Position(1, 2)));
        assertEquals("Test if there's no piece on the board", 0, boardData.countPiece());
        assertNull("Test if removePiece() returns null when there no piece on the specific position", boardData.removePiece(new Position(1, 2)));
    }

    @Test
    public void testMovePiece() {
        BoardData boardData = new BoardData();
        ChessPiece piece = new RookPiece(boardData, new EuropeanChess(), ChessGame.Side.NORTH);
        boardData.addPiece(piece, new Position(1, 2));
        boardData.movePiece(piece, new Position(2, 1));
        assertEquals("Test if the piece we just moved equals the piece on the board", piece, boardData.getPiece(new Position(2, 1)));
        assertFalse("Test if the piece we just moved doesn't on its previous position", boardData.hasPiece(new Position(1, 2)));
        assertEquals("Test if there's only one piece on the board", 1, boardData.countPiece());
    }

    @Test
    public void testHasPiece() {
        BoardData boardData = new BoardData();
        ChessPiece piece = new RookPiece(boardData, new EuropeanChess(), ChessGame.Side.NORTH);
        boardData.addPiece(piece, new Position(1, 2));
        assertTrue("Test if hasPiece() returns true when there's a piece on the specific position", boardData.hasPiece(new Position(1, 2)));
        assertFalse("Test if there's no piece on another position", boardData.hasPiece(new Position(2, 1)));
    }

    @Test
    public void testGetPiece() {
        BoardData boardData = new BoardData();
        ChessPiece piece = new RookPiece(boardData, new EuropeanChess(), ChessGame.Side.NORTH);
        boardData.addPiece(piece, new Position(1, 2));
        assertEquals("Test if the piece on the specific position equals the piece we just add on the board", piece, boardData.getPiece(new Position(1, 2)));
        assertNull("Test if getPiece() returns null when there's no piece on the specific position", boardData.getPiece(new Position(2, 1)));
    }

    @Test
    public void testSelectPiece() {
        BoardData boardData = new BoardData();
        ChessPiece piece = new RookPiece(boardData, new EuropeanChess(), ChessGame.Side.NORTH);
        boardData.addPiece(piece, new Position(1, 2));
        assertFalse("Test if there's no selected piece before we select one", boardData.hasSelectedPiece());
        boardData.selectPiece(new Position(1, 2));
        assertTrue("Test if there's a selected piece", boardData.hasSelectedPiece());
        assertEquals("Test if the piece we just added to the board equals the selected piece.", piece, boardData.getSelectedPiece());
        boardData.selectPiece(new Position(2, 1));
        assertTrue("Test if there's a selected piece even if we try to select a invalid position", boardData.hasSelectedPiece());
        assertEquals("Test if the piece we just added to the board equals the selected piece even if we try to select a invalid position", piece, boardData.getSelectedPiece());
    }

    @Test
    public void selectPiece() {
        BoardData boardData = new BoardData();
        ChessPiece piece = new RookPiece(boardData, new EuropeanChess(), ChessGame.Side.NORTH);
        boardData.addPiece(piece, 1, 2);
        assertFalse("Test if there's no selected piece before we select one", boardData.hasSelectedPiece());
        boardData.selectPiece(1, 2);
        assertTrue("Test if there's a selected piece", boardData.hasSelectedPiece());
        assertEquals("Test if the piece we just added to the board equals the selected piece.", piece, boardData.getSelectedPiece());
        boardData.selectPiece(2, 1);
        assertTrue("Test if there's a selected piece even if we try to select a invalid position", boardData.hasSelectedPiece());
        assertEquals("Test if the piece we just added to the board equals the selected piece even if we try to select a invalid position", piece, boardData.getSelectedPiece());
    }

    @Test
    public void testUnselectPiece() {
        BoardData boardData = new BoardData();
        ChessPiece piece = new RookPiece(boardData, new EuropeanChess(), ChessGame.Side.NORTH);
        boardData.addPiece(piece, new Position(1, 2));
        boardData.selectPiece(new Position(1, 2));
        boardData.unselectPiece();
        assertFalse("Test if there's no selected piece after we unselected the piece", boardData.hasSelectedPiece());
    }

    @Test
    public void testGetSelectedPiece() {
        BoardData boardData = new BoardData();
        ChessPiece piece = new RookPiece(boardData, new EuropeanChess(), ChessGame.Side.NORTH);
        boardData.addPiece(piece, new Position(1, 2));
        assertNull("Test if boardData.getSelectedPiece() returns null before we select a piece", boardData.getSelectedPiece());
        boardData.selectPiece(new Position(1, 2));
        assertNotNull("Test if boardData.getSelectedPiece() returns a piece after we select a piece", boardData.getSelectedPiece());
        assertEquals("Test if the piece we just added to the board equals the selected piece.", piece, boardData.getSelectedPiece());
    }

    @Test
    public void testHasSelectedPiece() {
        BoardData boardData = new BoardData();
        ChessPiece piece = new RookPiece(boardData, new EuropeanChess(), ChessGame.Side.NORTH);
        boardData.addPiece(piece, new Position(1, 2));
        assertFalse("Test if hasSelectedPiece() returns null before we select a piece", boardData.hasSelectedPiece());
        boardData.selectPiece(new Position(1, 2));
        assertTrue("Test if hasSelectedPiece() returns true after we selected a piece", boardData.hasSelectedPiece());
    }

    @Test
    public void testIsSelected() {
        BoardData boardData = new BoardData();
        ChessPiece piece = new RookPiece(boardData, new EuropeanChess(), ChessGame.Side.NORTH);
        boardData.addPiece(piece, new Position(1, 2));
        assertFalse("Test if isSelected() returns false before we select a piece", boardData.isSelected(piece));
        boardData.selectPiece(new Position(1, 2));
        assertTrue("Test if isSelected() returns true after we selected the piece", boardData.isSelected(piece));
    }

    @Test
    public void testAnyMatch() {
        BoardData boardData = new BoardData();
        ChessPiece piece = new RookPiece(boardData, new EuropeanChess(), ChessGame.Side.NORTH);
        Predicate<ChessPiece> validPredicate = it -> it.getLabel().equals("R");
        Predicate<ChessPiece> invalidPredicate = it -> it.getLabel().equals("No");
        boardData.addPiece(piece, new Position(1, 2));
        assertTrue("Test if anyMatch() returns true when there's a matched piece", boardData.anyMatch(validPredicate));
        assertFalse("Test if anyMatch() returns false when there's no matched piece", boardData.anyMatch(invalidPredicate));
    }
}