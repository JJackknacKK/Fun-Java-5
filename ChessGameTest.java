//CSDS 132 YINGYU ZHU

package chess;

import chess.european.EuropeanChess;
import chess.european.piece.PawnPiece;
import chess.xiangqi.Xiangqi;
import chess.xiangqi.piece.RookPiece;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ChessGameTest {
    @Test
    public void canChangeSelection() {
        ChessGame xiangqi = new Xiangqi();
        assertTrue(xiangqi.canChangeSelection(new RookPiece(new BoardData(), xiangqi, ChessGame.Side.NORTH)));
        ChessGame europeanChess = new EuropeanChess();
        assertTrue(europeanChess.canChangeSelection(new PawnPiece(new BoardData(), europeanChess, ChessGame.Side.NORTH)));
    }
}
