//CSDS 132 YINGYU ZHU

package chess.xiangqi.piece;

import chess.BoardData;
import chess.ChessGame;
import chess.ChessPiece;
import chess.Position;

public class HorsePiece extends ChessPiece {
    public HorsePiece(BoardData boardData, ChessGame game, ChessGame.Side side) {
        super(boardData, game, side);
    }

    @Override
    public String getLabel() {
        return "H";
    }

    @Override
    public boolean isLegalNonCaptureMove(int row, int column) {
        Position toPos = new Position(row, column);
        if (toPos.equals(getPosition().getNorthPosition(2).getEastPosition()) || toPos.equals(getPosition().getNorthPosition(2).getWestPosition())) {
            return !getBoardData().hasPiece(getPosition().getNorthPosition());
        } else if (toPos.equals(getPosition().getSouthPosition(2).getEastPosition()) || toPos.equals(getPosition().getSouthPosition(2).getWestPosition())) {
            return !getBoardData().hasPiece(getPosition().getSouthPosition());
        } else if (toPos.equals(getPosition().getNorthPosition().getEastPosition(2)) || toPos.equals(getPosition().getSouthPosition().getEastPosition(2))) {
            return !getBoardData().hasPiece(getPosition().getEastPosition());
        } else if (toPos.equals(getPosition().getNorthPosition().getWestPosition(2)) || toPos.equals(getPosition().getSouthPosition().getWestPosition(2))) {
            return !getBoardData().hasPiece(getPosition().getWestPosition());
        } else return false;
    }
}
