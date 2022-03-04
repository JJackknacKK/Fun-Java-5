//CSDS 132 YINGYU ZHU

package chess;

public interface ChessBoard {
    ChessGame getGameRules();

    void addPiece(ChessPiece piece, int row, int column);

    ChessPiece removePiece(int row, int column);

    boolean hasPiece(int row, int column);

    ChessPiece getPiece(int row, int column);

    boolean squareThreatened(int row, int column, ChessPiece piece);

    void updateBoard();

    BoardData getBoardData();
}
