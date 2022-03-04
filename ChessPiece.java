//CSDS 132 YINGYU ZHU

package chess;

//CSDS132 Yingyu Zhu
//This is an abstract class at the top of hierarchy, which also implements the interface chess.ChessGame
//It contains all the methods and instance variables that other classes which extends chess.ChessPiece needs.
//Pawn, Bishop, Queen,King,Knight,and Rook all extends chess.ChessPiece
public abstract class ChessPiece {

    //Here are all the instance variables that needs to initialize it.
    private final ChessGame game;
    private final ChessGame.Side side;
    private final BoardData boardData;
    private String label;
    private Object icon;
    private Position position;
    //This boolean variable works for the getter/setter methods for isFirstMove only for pawn.
    private boolean isFirstMove = true;
    private boolean neverMoved = true;

    public ChessPiece(BoardData boardData, ChessGame game, ChessGame.Side side) {
        this.game = game;
        this.boardData = boardData;
        this.side = side;
    }

    //return this piece belongs to whom
    public ChessGame.Side getSide() {
        return side;
    }

    //Return the label for the pieces
    public abstract String getLabel();

    //return the Icon for pieces
    public Object getIcon() {
        return icon;
    }

    //Set the position of the piece from the current position to the input position.
    public void setPosition(int row, int column) {
        this.position = new Position(row, column);
    }

    //First step to check if is legal to move
    //It checks if there is an enemy piece at destination or not, and call isLegalCapture or isLegalNonCaptureMove as appropriate.
    public boolean isLegalMove(int toRow, int toColumn) {
        if (getBoardData().hasPiece(toRow, toColumn)) {
            return isLegalCaptureMove(toRow, toColumn);
        } else {
            return isLegalNonCaptureMove(toRow, toColumn);
        }
    }

    /**
     * @return chess.ChessBoard instance which places all the chess pieces
     */
    public BoardData getBoardData() {
        return boardData;
    }

    /**
     * @return current chess.ChessGame instance
     */
    public ChessGame getGame() {
        return game;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public int getRow() {
        return position.getRow();
    }

    public int getColumn() {
        return position.getCol();
    }

    //This is the method to check if the move is legal when there is not an enemy piece at destination.
    //It will be override for every single Chess pieces. To follow up the condition
    public abstract boolean isLegalNonCaptureMove(int row, int column);

    //This is the method to check if the move is legal when there is an enemy piece at destination.
    //It will be override for every single Chess pieces. To follow up the condition
    public boolean isLegalCaptureMove(int row, int column) {
        return getBoardData().getPiece(row, column).getSide() != getSide() && isLegalNonCaptureMove(row, column);
    }

    //Waiting for other class to override it.
    public void moveDone() {

    }

    //These two getter and setter methods are to get access for chess.european.piece.PawnPiece class
    //In order to check if the Pawn can move one/two space
    public boolean getIsFirstMove() {
        return isFirstMove;
    }

    public void setIsFirstMove() {
        this.isFirstMove = false;
    }

    //These two getter and setter methods are to get access for kingPiece class
    //in order to achieve the castling.
    public boolean getNeverMoved() {
        return neverMoved;
    }

    public void setNeverMoved() {
        neverMoved = true;
    }
}