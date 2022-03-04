//CSDS 132 YINGYU ZHU

package chess.xiangqi.piece;

import chess.BoardData;
import chess.ChessGame;
import chess.ChessPiece;
import chess.Position;

public class RookPiece extends ChessPiece {
    public RookPiece(BoardData boardData, ChessGame game, ChessGame.Side side) {
        super(boardData, game, side);
    }

    @Override
    public String getLabel() {
        return "R";
    }

    @Override
    public boolean isLegalNonCaptureMove(int row, int column) {
        Position toPos = new Position(row, column);
        if (getPosition().onSameRow(toPos)) {
            if (getPosition().getCol() > column) {
                for (int i = 1; i < getPosition().getCol() - column; i++) {
                    if (getBoardData().hasPiece(getPosition().getWestPosition(i))) {
                        return false;
                    }
                }
            } else {
                for (int i = 1; i < column - getPosition().getCol(); i++) {
                    if (getBoardData().hasPiece(getPosition().getEastPosition(i))) {
                        return false;
                    }
                }
            }
            return true;
        } else if (getPosition().onSameCol(toPos)) {
            if (getPosition().getRow() > row) {
                for (int i = 1; i < getPosition().getRow() - row; i++) {
                    if (getBoardData().hasPiece(getPosition().getNorthPosition(i))) {
                        return false;
                    }
                }
            } else {
                for (int i = 1; i < row - getPosition().getRow(); i++) {
                    if (getBoardData().hasPiece(getPosition().getSouthPosition(i))) {
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }
}
