//CSDS 132 YINGYU ZHU

package chess;

import chess.european.SwingEuropeanChessDisplay;
import chess.xiangqi.SwingXiangqiDisplay;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SwingChessBoardDisplayTest {

    @Test
    public void getSquareSize() {
        assertEquals(java.awt.Toolkit.getDefaultToolkit().getScreenSize().width / 40,
                new SwingEuropeanChessDisplay().getSquareSize());
        assertEquals(java.awt.Toolkit.getDefaultToolkit().getScreenSize().width / 40,
                new SwingXiangqiDisplay().getSquareSize());
    }

}