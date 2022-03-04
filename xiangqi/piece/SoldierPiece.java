//CSDS 132 YINGYU ZHU

package chess.xiangqi.piece;

import chess.BoardData;
import chess.ChessGame;
import chess.ChessPiece;
import chess.Position;

public class SoldierPiece extends ChessPiece {
    public SoldierPiece(BoardData boardData, ChessGame game, ChessGame.Side side) {
        super(boardData, game, side);
    }

    @Override
    public String getLabel() {
        return "S";
    }

    @Override
    public boolean isLegalNonCaptureMove(int row, int column) {
        Position toPos = new Position(row, column);
        if (!getPosition().isAround(toPos)) return false;
        if (row > getGame().getNumRows() - 1) return false;
        if (row < 0) return false;
        if (column > getGame().getNumColumns() - 1) return false;
        if (column < 0) return false;
        switch (getSide()) {
            case SOUTH:
                if (getPosition().getNorthPosition().equals(toPos)) {
                    return true;
                } else if (getPosition().getRow() < getGame().getNumRows() / 2) {
                    return getPosition().getEastPosition().equals(toPos) || getPosition().getWestPosition().equals(toPos);
                }
                break;
            case NORTH:
                if (getPosition().getSouthPosition().equals(toPos)) {
                    return true;
                } else if (getPosition().getRow() >= getGame().getNumRows() / 2) {
                    return getPosition().getEastPosition().equals(toPos) || getPosition().getWestPosition().equals(toPos);
                }
                break;
            case WEST:
            case EAST:
        }
        return false;
    }
}
