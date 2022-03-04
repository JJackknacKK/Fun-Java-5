//CSDS 132 YINGYU ZHU

package chess;

import javafx.scene.control.Button;
import javafx.stage.Screen;

public interface JavaFXChessBoardDisplay {
    void displayEmptySquare(Button button, int row, int column);

    void displayFilledSquare(Button button, ChessPiece piece);

    default double getSquareSize() {
        return Screen.getPrimary().getBounds().getWidth() / 40;
    }

    void highlightSquare(boolean b, Button button, ChessPiece piece);

    default void updateBoard(JavaFXChessBoard board, BoardData data) {
        for (int row = 0; row < board.getGameRules().getNumRows(); row++) {
            for (int col = 0; col < board.getGameRules().getNumColumns(); col++) {
                ChessPiece piece = data.getPiece(row, col);
                Button button = board.getSquares()[col][row];
                if (piece != null) {
                    if (data.isSelected(piece)) {
                        highlightSquare(true, button, piece);
                    } else {
                        displayFilledSquare(button, piece);
                    }
                } else {
                    displayEmptySquare(button, row, col);
                }
            }
        }
    }
}
