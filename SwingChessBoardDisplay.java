//CSDS 132 YINGYU ZHU

package chess;

import javax.swing.*;

/**
 * Rules for how we want the chess board to display
 *
 * @author Harold Connamacher
 */
public interface SwingChessBoardDisplay {

    /**
     * The initial size of a square on the chess board, initially 1/40 the width of the screen
     *
     * @return the size of a square
     */
    default int getSquareSize() {
        return java.awt.Toolkit.getDefaultToolkit().getScreenSize().width / 40;
    }

    /**
     * Display a square that has no piece on it.
     *
     * @param button the button that is used for the chessboard square
     * @param row    the row of this square on the board
     * @param column the column of this square on the board
     */
    void displayEmptySquare(JButton button, int row, int column);

    /**
     * Display a square that has a piece on it.
     *
     * @param button the button that is used for the chessboard square
     * @param piece  the piece that is on this square
     */
    default void displayFilledSquare(JButton button, ChessPiece piece) {
        switch (piece.getSide()) {
            case NORTH:
                ButtonStyle.NORTH.applyTo(button);
                break;
            case SOUTH:
                ButtonStyle.SOUTH.applyTo(button);
                break;
            case EAST:
                ButtonStyle.EAST.applyTo(button);
                break;
            case WEST:
                ButtonStyle.WEST.applyTo(button);
        }
        button.setText(piece.getLabel());
        button.setIcon((Icon) piece.getIcon());
    }

    /**
     * Highlight a square of the board.
     *
     * @param highlight do we want the highlight on (true) or off (false)?
     * @param button    the button that is used for the chessboard square
     * @param piece     the piece (if any) that is on this square
     */
    default void highlightSquare(boolean highlight, JButton button, ChessPiece piece) {
        if (highlight) {
            switch (piece.getSide()) {
                case NORTH:
                    ButtonStyle.NORTH_HIGHLIGHTED.applyTo(button);
                    break;
                case SOUTH:
                    ButtonStyle.SOUTH_HIGHLIGHTED.applyTo(button);
                    break;
                case EAST:
                    ButtonStyle.EAST_HIGHLIGHTED.applyTo(button);
                    break;
                case WEST:
                    ButtonStyle.WEST_HIGHLIGHTED.applyTo(button);
            }
        } else {
            displayFilledSquare(button, piece);
        }
    }
}