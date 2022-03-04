//CSDS 132 YINGYU ZHU

package chess.xiangqi.piece;

import chess.BoardData;
import chess.ChessGame;
import chess.ChessPiece;
import chess.Position;
import chess.xiangqi.Xiangqi;

public class XiangqiKingPiece extends ChessPiece {
    public XiangqiKingPiece(BoardData boardData, ChessGame game, ChessGame.Side side) {
        super(boardData, game, side);
    }

    @Override
    public String getLabel() {
        return "K";
    }

    @Override
    public boolean isLegalNonCaptureMove(int row, int column) {
        Position toPos = new Position(row, column);
        if (Xiangqi.isPalace(row, column) && toPos.isAround(getPosition()) && (toPos.onSameRow(getPosition()) ||
                toPos.onSameCol(getPosition()))) {
            switch (getSide()) {
                case SOUTH:
                    for (int i = 1; i <= row; i++) {
                        if (getBoardData().hasPiece(toPos.getNorthPosition(i))) {
                            ChessPiece chessPiece = getBoardData().getPiece(toPos.getNorthPosition(i));
                            if (chessPiece instanceof XiangqiKingPiece) {
                                if (chessPiece.getSide() != getSide()) {
                                    return false;
                                }
                            } else {
                                return true;
                            }
                        }
                    }
                    return true;
                case NORTH:
                    for (int i = 1; i <= getGame().getNumRows() - row - 1; i++) {
                        if (getBoardData().hasPiece(toPos.getSouthPosition(i))) {
                            ChessPiece chessPiece = getBoardData().getPiece(toPos.getSouthPosition(i));
                            if (chessPiece instanceof XiangqiKingPiece) {
                                if (chessPiece.getSide() != getSide()) {
                                    return false;
                                }
                            } else {
                                return true;
                            }
                        }
                    }
                    return true;
            }
        }
        return false;
    }
}
