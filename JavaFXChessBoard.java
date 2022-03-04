//CSDS 132 YINGYU ZHU

package chess;

import chess.european.EuropeanChess;
import chess.european.JavaFXEuropeanChessDisplay;
import chess.xiangqi.JavaFXXiangqiDisplay;
import chess.xiangqi.Xiangqi;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;

public class JavaFXChessBoard extends Application implements ChessBoard {
    private ChessGame game;
    private JavaFXChessBoardDisplay display;
    private Button[][] squares;
    private BoardData boardData;

    public JavaFXChessBoard() {
        super();
    }

    public JavaFXChessBoard(JavaFXChessBoardDisplay display, ChessGame game) {
        super();
        this.game = game;
        this.display = display;
        this.boardData = new BoardData();
        this.squares = new Button[game.getNumColumns()][game.getNumRows()];
    }

    @Override
    public void start(Stage primaryStage) {
        List<String> params = getParameters().getRaw();
        String rule = params.get(0);
        if (rule.equals("chess")) {
            display = new JavaFXEuropeanChessDisplay();
            game = new EuropeanChess();
        } else if (rule.equals("xiangqi")) {
            display = new JavaFXXiangqiDisplay();
            game = new Xiangqi();
        } else {
            return;
        }
        squares = new Button[game.getNumColumns()][game.getNumRows()];
        boardData = new BoardData();
        GridPane pane = new GridPane();
        for (int i = 0; i < game.getNumColumns(); i++) {
            for (int j = 0; j < game.getNumRows(); j++) {
                Button button = new Button();
                button.addEventHandler(ActionEvent.ACTION, new SquareEventHandler(this, j, i));
                button.setMinSize(display.getSquareSize(), display.getSquareSize());
                squares[i][j] = button;
                display.displayEmptySquare(button, i, j);
                pane.add(button, i, j);
            }
        }
        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);
        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        hBox.getChildren().add(vBox);
        vBox.getChildren().add(pane);
        Scene scene = new Scene(hBox, display.getSquareSize() * game.getNumColumns(), display.getSquareSize() * game.getNumRows());
        primaryStage.setScene(scene);
        primaryStage.show();
        game.startGame(this);
        updateBoard();
    }

    @Override
    public ChessGame getGameRules() {
        return game;
    }

    public void setGameRules(ChessGame game) {
        this.game = game;
    }

    public Button[][] getSquares() {
        return squares;
    }

    @Override
    public BoardData getBoardData() {
        return boardData;
    }

    @Override
    public void addPiece(ChessPiece piece, int row, int column) {
        boardData.addPiece(piece, row, column);
    }

    @Override
    public ChessPiece removePiece(int row, int column) {
        return boardData.removePiece(row, column);
    }

    @Override
    public boolean hasPiece(int row, int column) {
        return boardData.hasPiece(row, column);
    }

    @Override
    public ChessPiece getPiece(int row, int column) {
        return boardData.getPiece(row, column);
    }

    @Override
    public boolean squareThreatened(int row, int column, ChessPiece piece) {
        for (int i = 0; i < game.getNumRows(); i++) {
            for (int j = 0; j < game.getNumColumns(); j++) {
                if (hasPiece(i, j) && getPiece(i, j).getSide() != piece.getSide() &&
                        getPiece(i, j).isLegalCaptureMove(row, column))
                    return true;
            }
        }
        return false;
    }

    public void updateBoard() {
        display.updateBoard(this, boardData);
    }
}

class SquareEventHandler implements EventHandler<ActionEvent> {
    private final JavaFXChessBoard board;
    private final int row;
    private final int col;

    public SquareEventHandler(JavaFXChessBoard board, int row, int col) {
        this.board = board;
        this.row = row;
        this.col = col;
    }

    @Override
    public void handle(ActionEvent event) {
        if (!board.getBoardData().hasSelectedPiece()) {
            if (board.hasPiece(row, col)) {
                if (board.getGameRules().legalPieceToPlay(board.getPiece(row, col), row, col)) {
                    board.getBoardData().selectPiece(row, col);
                }
            }
        } else {
            if (board.getGameRules().makeMove(board.getBoardData().getSelectedPiece(), row, col)) {
                board.getBoardData().unselectPiece();
            } else {
                if (board.getGameRules().canChangeSelection(board.getBoardData().getSelectedPiece())) {
                    board.getBoardData().unselectPiece();
                }
            }
        }
        board.updateBoard();
    }
}
