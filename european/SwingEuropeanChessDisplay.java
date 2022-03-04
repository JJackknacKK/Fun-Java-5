//CSDS 132 YINGYU ZHU

package chess.european;

import chess.ButtonStyle;
import chess.SwingChessBoardDisplay;

import javax.swing.*;

/**
 * Rules for how we want a board to display for a game of European chess
 *
 * @author Harold Connamacher
 */
public class SwingEuropeanChessDisplay implements SwingChessBoardDisplay {

    /**
     * Display a square that has no piece on it.  Will produce a red/black checkerboard.
     *
     * @param button the button that is used for the chessboard square
     * @param row    the row of this square on the board
     * @param column the column of this square on the board
     */
    public void displayEmptySquare(JButton button, int row, int column) {
        if ((row + column) % 2 == 0) {
            ButtonStyle.BLACK.applyTo(button);
        } else {
            ButtonStyle.WHITE.applyTo(button);
        }
        button.setText(null);
        button.setIcon(null);
    }
}