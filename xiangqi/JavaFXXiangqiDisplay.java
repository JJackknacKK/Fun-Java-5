//CSDS 132 YINGYU ZHU
package chess.xiangqi;

import chess.ButtonStyle;
import chess.ChessPiece;
import chess.ColorValue;
import chess.JavaFXChessBoardDisplay;
import javafx.scene.control.Button;

public class JavaFXXiangqiDisplay implements JavaFXChessBoardDisplay {

    private static ColorValue getBackgroundColor(int row, int col) {
        return Xiangqi.isPalace(row, col) ? ColorValue.DARK_GRAY : ColorValue.LIGHT_GRAY;
    }

    @Override
    public void displayEmptySquare(Button button, int row, int column) {
        button.setText("");
        if (Xiangqi.isPalace(row, column)) {
            ButtonStyle.DARK_GRAY.applyTo(button);
        } else {
            ButtonStyle.LIGHT_GRAY.applyTo(button);
        }
    }

    @Override
    public void displayFilledSquare(Button button, ChessPiece piece) {
        button.setText(piece.getLabel());
        switch (piece.getSide()) {
            case EAST:
                new ButtonStyle(ColorValue.EAST, getBackgroundColor(piece.getRow(), piece.getColumn())).applyTo(button);
                break;
            case WEST:
                new ButtonStyle(ColorValue.WEST, getBackgroundColor(piece.getRow(), piece.getColumn())).applyTo(button);
                break;
            case NORTH:
                new ButtonStyle(ColorValue.NORTH, getBackgroundColor(piece.getRow(), piece.getColumn())).applyTo(button);
                break;
            case SOUTH:
                new ButtonStyle(ColorValue.SOUTH, getBackgroundColor(piece.getRow(), piece.getColumn())).applyTo(button);
                break;
        }
    }

    @Override
    public void highlightSquare(boolean highlight, Button button, ChessPiece piece) {
        if (highlight) {
            button.setText(piece.getLabel());
            switch (piece.getSide()) {
                case EAST:
                    new ButtonStyle(ColorValue.EAST_HIGHLIGHTED, getBackgroundColor(piece.getRow(), piece.getColumn())).applyTo(button);
                    break;
                case WEST:
                    new ButtonStyle(ColorValue.WEST_HIGHLIGHTED, getBackgroundColor(piece.getRow(), piece.getColumn())).applyTo(button);
                    break;
                case NORTH:
                    new ButtonStyle(ColorValue.NORTH_HIGHLIGHTED, getBackgroundColor(piece.getRow(), piece.getColumn())).applyTo(button);
                    break;
                case SOUTH:
                    new ButtonStyle(ColorValue.SOUTH_HIGHLIGHTED, getBackgroundColor(piece.getRow(), piece.getColumn())).applyTo(button);
                    break;
            }
        } else
            displayFilledSquare(button, piece);
    }
}
