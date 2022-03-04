//CSDS 132 YINGYU ZHU

package chess.european;

import chess.BoardData;
import chess.ChessBoard;
import chess.ChessGame;
import chess.SwingChessBoard;
import chess.european.piece.RookPiece;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class EuropeanChessTest {

    @Test
    public void testLegalPieceToPlay() {
        EuropeanChess europeanChess = new EuropeanChess();
        BoardData boardData = new BoardData();
        RookPiece northPiece = new RookPiece(boardData, europeanChess, ChessGame.Side.NORTH);
        RookPiece southPiece = new RookPiece(boardData, europeanChess, ChessGame.Side.SOUTH);
        boardData.addPiece(northPiece, 1, 2);
        boardData.addPiece(southPiece, 1, 4);
        assertTrue("Testing if it's legal to play", europeanChess.legalPieceToPlay(northPiece, 1, 3));
        assertFalse("Testing if it's legal to play now", europeanChess.legalPieceToPlay(southPiece, 1, 3));
    }

    @Test
    public void testMakeMove() {
        EuropeanChess europeanChess = new EuropeanChess();
        BoardData boardData = new BoardData();
        RookPiece northPiece = new RookPiece(boardData, europeanChess, ChessGame.Side.NORTH);
        RookPiece southPiece = new RookPiece(boardData, europeanChess, ChessGame.Side.SOUTH);
        RookPiece westPiece = new RookPiece(boardData, europeanChess, ChessGame.Side.WEST);
        boardData.addPiece(northPiece, 1, 2);
        boardData.addPiece(westPiece, 1, 4);
        assertTrue("Testing if it could make move", europeanChess.makeMove(northPiece, 1, 3));
        assertFalse("Testing if it could not make move", europeanChess.legalPieceToPlay(westPiece, 1, 3));
    }

    @Test
    public void testStartGame() {
        EuropeanChess europeanChess = new EuropeanChess();
        ChessBoard chessBoard = new SwingChessBoard(europeanChess.getNumRows(), europeanChess.getNumColumns(), new SwingEuropeanChessDisplay(), europeanChess);
        europeanChess.startGame(chessBoard);
        for (int i = 0; i < europeanChess.getNumColumns(); i++) {
            assertTrue("Test if the board is the initial state of Indo-European chess", chessBoard.getBoardData().hasPiece(1, i));
            assertTrue("Test if the board is the initial state of Indo-European chess", chessBoard.getBoardData().hasPiece(6, i));
            if (i == 0 || i == 7) {
                assertTrue("Test if the board is the initial state of Indo-European chess", chessBoard.getBoardData().hasPiece(0, i));
                assertTrue("Test if the board is the initial state of Indo-European chess", chessBoard.getBoardData().hasPiece(7, i));
            }
            if (i == 6 || i == 1) {
                assertTrue("Test if the board is the initial state of Indo-European chess", chessBoard.getBoardData().hasPiece(0, i));
                assertTrue("Test if the board is the initial state of Indo-European chess", chessBoard.getBoardData().hasPiece(7, i));
            }
            if (i == 2 || i == 5) {
                assertTrue("Test if the board is the initial state of Indo-European chess", chessBoard.getBoardData().hasPiece(0, i));
                assertTrue("Test if the board is the initial state of Indo-European chess", chessBoard.getBoardData().hasPiece(7, i));
            }
            if (i == 3) {
                assertTrue("Test if the board is the initial state of Indo-European chess", chessBoard.getBoardData().hasPiece(0, i));
                assertTrue("Test if the board is the initial state of Indo-European chess", chessBoard.getBoardData().hasPiece(7, i));
            }
            if (i == 4) {
                assertTrue("Test if the board is the initial state of Indo-European chess", chessBoard.getBoardData().hasPiece(0, i));
                assertTrue("Test if the board is the initial state of Indo-European chess", chessBoard.getBoardData().hasPiece(7, i));
            }
        }
    }


}
