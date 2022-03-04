//CSDS 132 YINGYU ZHU

package chess.xiangqi.piece;

import chess.BoardData;
import chess.ChessGame;
import chess.ChessPiece;
import chess.Position;

public class ElephantPiece extends ChessPiece {
    public ElephantPiece(BoardData boardData, ChessGame game, ChessGame.Side side) {
        super(boardData, game, side);
    }

    @Override
    public String getLabel() {
        return "E";
    }

    @Override
    public boolean isLegalNonCaptureMove(int row, int column) {
        Position toPos = new Position(row, column);
        switch (getSide()) {
            case SOUTH:
                if (row < getGame().getNumRows() / 2) return false;
            case NORTH:
                if (row >= getGame().getNumRows() / 2) return false;
            case WEST:
            case EAST:
        }
        if (toPos.equals(getPosition().getNorthPosition(2).getEastPosition(2)) && !getBoardData().hasPiece(getPosition().getNorthPosition().getEastPosition())) {
            return true;
        } else if (toPos.equals(getPosition().getNorthPosition(2).getWestPosition(2)) && !getBoardData().hasPiece(getPosition().getNorthPosition().getWestPosition())) {
            return true;
        } else if (toPos.equals(getPosition().getSouthPosition(2).getEastPosition(2)) && !getBoardData().hasPiece(getPosition().getSouthPosition().getEastPosition())) {
            return true;
        } else
            return toPos.equals(getPosition().getSouthPosition(2).getWestPosition(2)) && !getBoardData().hasPiece(getPosition().getSouthPosition().getWestPosition());
    }
}
