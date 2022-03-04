//CSDS 132 YINGYU ZHU
package chess.xiangqi;

import chess.*;
import chess.xiangqi.piece.RookPiece;
import org.junit.Test;

import static org.junit.Assert.*;

public class XiangqiTest {

    @Test
    public void isPalace() {
        assertTrue(Xiangqi.isPalace(1, 4));
        assertFalse(Xiangqi.isPalace(2, 2));
    }

    @Test
    public void legalPieceToPlay() {
        ChessGame xiangqi = new Xiangqi();
        BoardData boardData = new BoardData();
        RookPiece northPiece = new RookPiece(boardData, xiangqi, ChessGame.Side.NORTH);
        RookPiece southPiece = new RookPiece(boardData, xiangqi, ChessGame.Side.SOUTH);
        boardData.addPiece(northPiece, 1, 2);
        boardData.addPiece(southPiece, 1, 4);
        assertTrue("Testing if it's legal to play", xiangqi.legalPieceToPlay(northPiece, 1, 3));
        assertFalse("Testing if it's legal to play now", xiangqi.legalPieceToPlay(southPiece, 1, 3));
    }

    @Test
    public void makeMove() {
        Xiangqi xiangqi = new Xiangqi();
        BoardData boardData = new BoardData();
        RookPiece northPiece = new RookPiece(boardData, xiangqi, ChessGame.Side.NORTH);
        RookPiece southPiece = new RookPiece(boardData, xiangqi, ChessGame.Side.SOUTH);
        RookPiece eastPiece = new RookPiece(boardData, xiangqi, ChessGame.Side.EAST);
        boardData.addPiece(northPiece, 1, 2);
        boardData.addPiece(southPiece, 1, 4);
        boardData.addPiece(eastPiece, 2, 3);
        assertFalse("Testing if it could not make move", xiangqi.legalPieceToPlay(eastPiece, 1, 3));
        assertTrue("Testing if it could make move", xiangqi.makeMove(northPiece, 1, 3));
        assertTrue("Testing if it could make move", xiangqi.legalPieceToPlay(southPiece, 1, 3));
        assertTrue("Testing if it could make move", xiangqi.makeMove(southPiece, 1, 3));
    }

    @Test
    public void getNumRows() {
        assertEquals(10, new Xiangqi().getNumRows());
    }

    @Test
    public void getNumColumns() {
        assertEquals(9, new Xiangqi().getNumColumns());
    }

    @Test
    public void startGame() {
        ChessGame xiangqi = new Xiangqi();
        ChessBoard chessBoard = new SwingChessBoard(xiangqi.getNumRows(), xiangqi.getNumColumns(), new SwingXiangqiDisplay(), xiangqi);
        xiangqi.startGame(chessBoard);
        BoardData boardData = chessBoard.getBoardData();
        for (int col = 0; col < xiangqi.getNumColumns(); col++) {
            for (int row = 0; row < xiangqi.getNumRows(); row++) {
                switch (row) {
                    // North
                    case 0:
                    case 9:
                        assertTrue("Test if the board is the initial state of Chinese Xiangqi chess", boardData.hasPiece(new Position(row, col)));
                        break;
                    case 2:
                    case 7:
                        switch (col) {
                            case 1:
                            case 7:
                                assertTrue("Test if the board is the initial state of Chinese Xiangqi chess", boardData.hasPiece(new Position(row, col)));
                                break;
                            default:
                                assertFalse("Test if the board is the initial state of Chinese Xiangqi chess", boardData.hasPiece(new Position(row, col)));
                        }
                        break;
                    case 3:

                        // South
                    case 6:
                        switch (col) {
                            case 0:
                            case 2:
                            case 4:
                            case 6:
                            case 8:
                                assertTrue("Test if the board is the initial state of Chinese Xiangqi chess", boardData.hasPiece(new Position(row, col)));
                                break;
                            default:
                                assertFalse("Test if the board is the initial state of Chinese Xiangqi chess", boardData.hasPiece(new Position(row, col)));
                        }
                        break;
                    default:
                        assertFalse("Test if the board is the initial state of Chinese Xiangqi chess", boardData.hasPiece(new Position(row, col)));
                }
            }
        }
    }
}