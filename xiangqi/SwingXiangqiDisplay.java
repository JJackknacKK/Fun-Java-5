//CSDS 132 YINGYU ZHU
package chess.xiangqi;

import chess.ButtonStyle;
import chess.SwingChessBoardDisplay;

import javax.swing.*;

public class SwingXiangqiDisplay implements SwingChessBoardDisplay {
    @Override
    public void displayEmptySquare(JButton button, int row, int column) {
        button.setText("");
        if (Xiangqi.isPalace(row, column)) {
            ButtonStyle.DARK_GRAY.applyTo(button);
        } else {
            ButtonStyle.LIGHT_GRAY.applyTo(button);
        }
    }
}
