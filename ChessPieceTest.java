//CSDS 132 YINGYU ZHU

package chess;

import chess.xiangqi.Xiangqi;
import chess.xiangqi.piece.RookPiece;
import org.junit.Test;

import static org.junit.Assert.*;

public class ChessPieceTest {

    @Test
    public void getSide() {
        assertEquals(ChessGame.Side.NORTH, new RookPiece(new BoardData(), new Xiangqi(), ChessGame.Side.NORTH).getSide());
        assertEquals(ChessGame.Side.SOUTH, new RookPiece(new BoardData(), new Xiangqi(), ChessGame.Side.SOUTH).getSide());
        assertEquals(ChessGame.Side.EAST, new RookPiece(new BoardData(), new Xiangqi(), ChessGame.Side.EAST).getSide());
        assertEquals(ChessGame.Side.WEST, new RookPiece(new BoardData(), new Xiangqi(), ChessGame.Side.WEST).getSide());
    }

    @Test
    public void getLabel() {
        assertNotNull(new RookPiece(new BoardData(), new Xiangqi(), ChessGame.Side.NORTH).getLabel());
    }

    @Test
    public void getIcon() {
        assertNull(new RookPiece(new BoardData(), new Xiangqi(), ChessGame.Side.NORTH).getIcon());
    }

    @Test
    public void setPosition() {
        ChessPiece piece = new RookPiece(new BoardData(), new Xiangqi(), ChessGame.Side.NORTH);
        piece.setPosition(1, 2);
        assertEquals(piece.getPosition(), new Position(1, 2));
        piece.setPosition(new Position(3, 4));
        assertEquals(piece.getPosition(), new Position(3, 4));
    }

    @Test
    public void isLegalMove() {
        BoardData boardData = new BoardData();
        ChessGame xiangqi = new Xiangqi();
        ChessPiece piece = new RookPiece(boardData, xiangqi, ChessGame.Side.NORTH);
        boardData.addPiece(piece, 2, 2);
        assertEquals(piece.isLegalNonCaptureMove(2, 5), piece.isLegalMove(2, 5));
        assertEquals(piece.isLegalNonCaptureMove(4, 4), piece.isLegalMove(4, 4));
        boardData.addPiece(new RookPiece(boardData, xiangqi, ChessGame.Side.SOUTH), 2, 5);
        boardData.addPiece(new RookPiece(boardData, xiangqi, ChessGame.Side.SOUTH), 4, 4);
        assertEquals(piece.isLegalCaptureMove(2, 5), piece.isLegalMove(2, 5));
        assertEquals(piece.isLegalCaptureMove(4, 4), piece.isLegalMove(4, 4));
    }

    @Test
    public void getBoardData() {
        BoardData boardData = new BoardData();
        ChessGame xiangqi = new Xiangqi();
        ChessPiece piece = new RookPiece(boardData, xiangqi, ChessGame.Side.NORTH);
        assertEquals(boardData, piece.getBoardData());
    }

    @Test
    public void getGame() {
        BoardData boardData = new BoardData();
        ChessGame xiangqi = new Xiangqi();
        ChessPiece piece = new RookPiece(boardData, xiangqi, ChessGame.Side.NORTH);
        assertEquals(xiangqi, piece.getGame());
    }

    @Test
    public void getPosition() {
        BoardData boardData = new BoardData();
        ChessGame xiangqi = new Xiangqi();
        ChessPiece piece = new RookPiece(boardData, xiangqi, ChessGame.Side.NORTH);
        boardData.addPiece(piece, 2, 3);
        assertEquals(new Position(2, 3), piece.getPosition());
    }

    @Test
    public void getRow() {
        BoardData boardData = new BoardData();
        ChessGame xiangqi = new Xiangqi();
        ChessPiece piece = new RookPiece(boardData, xiangqi, ChessGame.Side.NORTH);
        boardData.addPiece(piece, 3, 2);
        assertEquals(new Position(3, 2).getRow(), piece.getRow());
    }

    @Test
    public void getColumn() {
        BoardData boardData = new BoardData();
        ChessGame xiangqi = new Xiangqi();
        ChessPiece piece = new RookPiece(boardData, xiangqi, ChessGame.Side.NORTH);
        boardData.addPiece(piece, 3, 2);
        assertEquals(new Position(3, 2).getCol(), piece.getColumn());
    }

    @Test
    public void moveDone() {
        BoardData boardData = new BoardData();
        ChessGame xiangqi = new Xiangqi();
        ChessPiece piece = new RookPiece(boardData, xiangqi, ChessGame.Side.NORTH);
        piece.moveDone();
    }

    @Test
    public void getIsFirstMove() {
        BoardData boardData = new BoardData();
        ChessGame xiangqi = new Xiangqi();
        ChessPiece piece = new RookPiece(boardData, xiangqi, ChessGame.Side.NORTH);
        assertTrue(piece.getIsFirstMove());
    }

    @Test
    public void setIsFirstMove() {
        BoardData boardData = new BoardData();
        ChessGame xiangqi = new Xiangqi();
        ChessPiece piece = new RookPiece(boardData, xiangqi, ChessGame.Side.NORTH);
        piece.setIsFirstMove();
        assertFalse(piece.getIsFirstMove());
    }

    @Test
    public void getNeverMoved() {
        BoardData boardData = new BoardData();
        ChessGame xiangqi = new Xiangqi();
        ChessPiece piece = new RookPiece(boardData, xiangqi, ChessGame.Side.NORTH);
        assertTrue(piece.getNeverMoved());
    }

    @Test
    public void setNeverMoved() {
        BoardData boardData = new BoardData();
        ChessGame xiangqi = new Xiangqi();
        ChessPiece piece = new RookPiece(boardData, xiangqi, ChessGame.Side.NORTH);
        piece.setNeverMoved();
        assertTrue(piece.getNeverMoved());
    }
}