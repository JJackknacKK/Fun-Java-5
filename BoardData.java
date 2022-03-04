//CSDS 132 YINGYU ZHU

package chess;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class BoardData {
    private final List<ChessPiece> pieces;
    private ChessPiece selectedPiece = null;

    public BoardData() {
        pieces = new ArrayList<>();
    }

    public void addPiece(ChessPiece piece, Position position) {
        if (hasPiece(position)) {
            removePiece(position);
        }
        pieces.add(piece);
        piece.setPosition(position);
    }

    public void addPiece(ChessPiece piece, int row, int col) {
        addPiece(piece, new Position(row, col));
    }

    public ChessPiece removePiece(Position position) {
        if (hasPiece(position)) {
            ChessPiece piece = getPiece(position);
            pieces.remove(piece);
            return piece;
        } else {
            return null;
        }
    }

    public ChessPiece removePiece(int row, int col) {
        return removePiece(new Position(row, col));
    }

    public void movePiece(ChessPiece piece, Position toPosition) {
        if (hasPiece(toPosition)) {
            removePiece(toPosition);
        }
        addPiece(removePiece(piece.getPosition()), toPosition);
    }

    public void movePiece(ChessPiece piece, int toRow, int toCol) {
        movePiece(piece, new Position(toRow, toCol));
    }

    public boolean hasPiece(Position position) {
        return anyMatch(it -> it.getPosition().equals(position));
    }

    public boolean hasPiece(int row, int col) {
        return hasPiece(new Position(row, col));
    }

    public ChessPiece getPiece(Position position) {
        List<ChessPiece> results = pieces.stream().filter(it -> it.getPosition().equals(position)).collect(Collectors.toList());
        if (results.size() > 0) {
            return results.get(0);
        } else {
            return null;
        }
    }

    public ChessPiece getPiece(int row, int col) {
        return getPiece(new Position(row, col));
    }

    public int countPiece() {
        return pieces.size();
    }

    public void selectPiece(Position position) {
        if (hasPiece(position)) {
            selectedPiece = getPiece(position);
        }
        // If there's no piece on the specific position, do nothing.
    }

    public void selectPiece(int row, int col) {
        selectPiece(new Position(row, col));
    }

    public void unselectPiece() {
        selectedPiece = null;
    }

    public ChessPiece getSelectedPiece() {
        return selectedPiece;
    }

    public boolean hasSelectedPiece() {
        return selectedPiece != null;
    }

    public boolean isSelected(ChessPiece piece) {
        return piece == getSelectedPiece();
    }

    public boolean anyMatch(Predicate<ChessPiece> predicate) {
        return pieces.stream().anyMatch(predicate);
    }
}
