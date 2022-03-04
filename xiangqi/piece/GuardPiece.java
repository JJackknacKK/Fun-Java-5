//CSDS 132 YINGYU ZHU

package chess.xiangqi.piece;

import chess.BoardData;
import chess.ChessGame;
import chess.ChessPiece;
import chess.Position;
import chess.xiangqi.Xiangqi;

public class GuardPiece extends ChessPiece {
    public GuardPiece(BoardData boardData, ChessGame game, ChessGame.Side side) {
        super(boardData, game, side);
    }

    @Override
    public String getLabel() {
        return "G";
    }

    @Override
    public boolean isLegalNonCaptureMove(int row, int column) {
        Position toPos = new Position(row, column);
        if (!Xiangqi.isPalace(row, column)) return false;
        if (toPos.equals(getPosition().getNorthPosition().getEastPosition())) {
            return true;
        } else if (toPos.equals(getPosition().getNorthPosition().getWestPosition())) {
            return true;
        } else if (toPos.equals(getPosition().getSouthPosition().getEastPosition())) {
            return true;
        } else return toPos.equals(getPosition().getSouthPosition().getWestPosition());
    }
}
