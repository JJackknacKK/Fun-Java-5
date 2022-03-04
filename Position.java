//CSDS 132 YINGYU ZHU

package chess;

public class Position {
    private int col;
    private int row;

    public Position(int row, int col) {
        this.col = col;
        this.row = row;
    }

    public Position(Position pos) {
        this(pos.getRow(), pos.getCol());
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public Position getNorthPosition(int distance) {
        return new Position(getRow() - distance, getCol());
    }

    public Position getNorthPosition() {
        return getNorthPosition(1);
    }

    public Position getSouthPosition(int distance) {
        return new Position(getRow() + distance, getCol());
    }

    public Position getSouthPosition() {
        return getSouthPosition(1);
    }

    public Position getWestPosition(int distance) {
        return new Position(getRow(), getCol() - distance);
    }

    public Position getWestPosition() {
        return getWestPosition(1);
    }

    public Position getEastPosition(int distance) {
        return new Position(getRow(), getCol() + distance);
    }

    public Position getEastPosition() {
        return getEastPosition(1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Position position = (Position) o;

        if (col != position.col) return false;
        return row == position.row;
    }

    public boolean onSameRow(Position position) {
        return this.row == position.getRow();
    }

    public boolean onSameCol(Position position) {
        return this.col == position.getCol();
    }

    public boolean isAround(Position position) {
        if (equals(position)) return false;
        return Math.abs(position.col - col) < 2 && Math.abs(position.row - row) < 2;
    }
}
