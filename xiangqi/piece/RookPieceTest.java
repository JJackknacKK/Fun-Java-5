//CSDS 132 YINGYU ZHU

package chess.xiangqi.piece;

import chess.BoardData;
import chess.ChessGame;
import chess.xiangqi.Xiangqi;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class RookPieceTest {

    @Test
    public void getLabel() {
        assertNotNull(new RookPiece(new BoardData(), new Xiangqi(), ChessGame.Side.NORTH).getLabel());

    }

}