//CSDS 132 YINGYU ZHU

package chess.european;

import chess.ButtonStyle;
import chess.ChessPiece;
import chess.JavaFXChessBoardDisplay;
import javafx.scene.control.Button;

public class JavaFXEuropeanChessDisplay implements JavaFXChessBoardDisplay {

    @Override
    public void displayEmptySquare(Button button, int row, int column) {
        button.setText("");
        if ((row + column) % 2 == 0) {
            ButtonStyle.BLACK.applyTo(button);
        } else {
            ButtonStyle.WHITE.applyTo(button);
        }
    }

    @Override
    public void displayFilledSquare(Button button, ChessPiece piece) {
        button.setText(piece.getLabel());
        switch (piece.getSide()) {
            case EAST:
                ButtonStyle.EAST.applyTo(button);
                break;
            case WEST:
                ButtonStyle.WEST.applyTo(button);
                break;
            case NORTH:
                ButtonStyle.NORTH.applyTo(button);
                break;
            case SOUTH:
                ButtonStyle.SOUTH.applyTo(button);
                break;
        }
    }

    @Override
    public void highlightSquare(boolean highlight, Button button, ChessPiece piece) {
        if (highlight) {
            button.setText(piece.getLabel());
            switch (piece.getSide()) {
                case EAST:
                    ButtonStyle.EAST_HIGHLIGHTED.applyTo(button);
                    break;
                case WEST:
                    ButtonStyle.WEST_HIGHLIGHTED.applyTo(button);
                    break;
                case NORTH:
                    ButtonStyle.NORTH_HIGHLIGHTED.applyTo(button);
                    break;
                case SOUTH:
                    ButtonStyle.SOUTH_HIGHLIGHTED.applyTo(button);
                    break;
            }
        } else
            displayFilledSquare(button, piece);
    }
}
