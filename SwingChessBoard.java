//CSDS 132 YINGYU ZHU

package chess;

import chess.european.EuropeanChess;
import chess.european.SwingEuropeanChessDisplay;
import chess.xiangqi.SwingXiangqiDisplay;
import chess.xiangqi.Xiangqi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * <p>Creates a chessboard in a window on the desktop.  The chess.SwingChessBoard has a chess.SwingChessBoardDisplay object that determines
 * how the individual squares of the chessboard should be drawn.</p>
 *
 * <p>The chessboard uses a chess.ChessGame object to determine how the game should be played.  The way the chessboard works
 * is as follows.  The player selects a piece by clicking on the board, and
 * and the chessboard calls the <tt>legalPieceToPlay</tt> method of the chess.ChessGame object.
 * If the player is allowed to select the piece, the board highlights it, and the player can select another square on
 * the board.  The chessboard then calls the <tt>makeMove</tt> method of the chess.ChessGame object.  The chess.ChessGame is
 * responsible for determining if the move is valid, and if it is to update the game and the chessboard
 * with the results of making that move.</p>
 *
 * @author Harold Connamacher
 */
public class SwingChessBoard implements ChessBoard {
    private static SwingChessBoard INSTANCE;
    private final JButton[][] squares;                   // the squares of the board
    private final BoardData boardData;
    private final SwingChessBoardDisplay boardDisplay;        // rules for how to draw the chess board
    private JFrame board;                          // the game board
    private ChessGame gameRules;                   // global rules for this particular game

    /**
     * Builds a board of the desired size, the display parameters, and the rules for the chess game.
     *
     * @param numRows      the number of rows for the chessboard
     * @param numColumns   the number of columns for the chessboard
     * @param boardDisplay an object that determines how the squares on the chessboard should be drawn
     * @param gameRules    an object that determines when player selection is valid and to update the game with the result of a move
     */
    public SwingChessBoard(final int numRows, final int numColumns, SwingChessBoardDisplay boardDisplay, ChessGame gameRules) {
        // for Mac computers: this allows us to change a button background
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // initialize the board
        this.gameRules = gameRules;
        this.boardDisplay = boardDisplay;
        boardData = new BoardData();
        squares = new JButton[numRows][numColumns];

        // create the board visuals on the event dispatch thread
        try {
            SwingUtilities.invokeAndWait(() -> {
                board = new JFrame();

                // create a grid for the squares and the listener for the user clicks
                JPanel panel = new JPanel(new GridLayout(numRows, numColumns));
                ActionListener responder = new ChessAction();

                // create the squares
                for (int i = 0; i < numRows; i++) {
                    for (int j = 0; j < numColumns; j++) {
                        squares[i][j] = new JButton();
                        squares[i][j].addActionListener(responder);
                        panel.add(squares[i][j]);
                    }
                }
                board.add(panel);
                board.setSize(boardDisplay.getSquareSize() * numColumns, boardDisplay.getSquareSize() * numRows);
                board.setVisible(true);
                board.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ChessGame game;
        if (args[0].equals("chess")) {
            game = new EuropeanChess();
            INSTANCE = new SwingChessBoard(game.getNumRows(), game.getNumColumns(), new SwingEuropeanChessDisplay(), game);
        } else if (args[0].equals("xiangqi")) {
            game = new Xiangqi();
            INSTANCE = new SwingChessBoard(game.getNumRows(), game.getNumColumns(), new SwingXiangqiDisplay(), game);
        } else {
            return;
        }
        game.startGame(INSTANCE);
        INSTANCE.updateBoard();
    }

    /**
     * Returns the rules of the game.
     *
     * @return the rules of the game
     */
    public ChessGame getGameRules() {
        return gameRules;
    }

    /**
     * Changes the rules of the game
     *
     * @param newRules the new rules for the game
     */
    public void setGameRules(ChessGame newRules) {
        this.gameRules = newRules;
    }

    /**
     * Returns the number of rows in the board.
     *
     * @return the number of rows
     */
    public final int numRows() {
        return gameRules.getNumRows();
    }

    /**
     * Returns the number of columns in the board.
     *
     * @return the number of columns
     */
    public final int numColumns() {
        return gameRules.getNumColumns();
    }

    /**
     * Adds a piece to the board at the desired position.  Any piece currently
     * at that position is lost.
     *
     * @param piece the piece to add
     * @param row   the row for the piece
     * @param col   the column for the piece
     */
    public void addPiece(final ChessPiece piece, final int row, final int col) {
        boardData.addPiece(piece, new Position(row, col));
    }

    /**
     * Removes a piece from the board
     *
     * @param row the row of the piece
     * @param col the column of the piece
     * @return the piece removed of null if there was no piece at that square
     */
    public ChessPiece removePiece(final int row, final int col) {
        return boardData.removePiece(new Position(row, col));
    }

    /**
     * Returns true if there is a piece at a specific position of the board.
     *
     * @param row the row to examine
     * @param col the column to examine
     * @return true if there is a piece a this row and column and false
     * if the square is empty
     */
    public boolean hasPiece(int row, int col) {
        return boardData.hasPiece(new Position(row, col));
    }

    /**
     * Returns the chess piece at a specific position on the board.
     *
     * @param row the row for the piece
     * @param col the column for the piece
     * @return the piece at the row and column or null if there is no piece there.
     */
    public ChessPiece getPiece(int row, int col) {
        return boardData.getPiece(new Position(row, col));
    }

    /**
     * Returns true if a particular square is threatened by an opposing piece.
     *
     * @param row    the row of the square
     * @param column the column of the square
     * @param piece  a piece of the game
     * @return true if the square can be attacked by a piece of an opposing side as the parameter piece
     */
    public boolean squareThreatened(int row, int column, ChessPiece piece) {
        for (int i = 0; i < getGameRules().getNumRows(); i++) {
            for (int j = 0; j < getGameRules().getNumColumns(); j++) {
                if (hasPiece(i, j) && getPiece(i, j).getSide() != piece.getSide() &&
                        getPiece(i, j).isLegalCaptureMove(row, column))
                    return true;
            }
        }
        return false;
    }

    @Override
    public void updateBoard() {
        Runnable update = () -> {
            for (int col = 0; col < gameRules.getNumColumns(); col++) {
                for (int row = 0; row < gameRules.getNumRows(); row++) {
                    if (hasPiece(row, col)) {
                        boardDisplay.highlightSquare(boardData.isSelected(getPiece(row, col)), squares[row][col], getPiece(row, col));
                    } else {
                        boardDisplay.displayEmptySquare(squares[row][col], row, col);
                    }
                }
            }

        };

        // run the code to change the display on the event dispatch to avoid drawing errors
        if (SwingUtilities.isEventDispatchThread())
            update.run();
        else {
            try {
                SwingUtilities.invokeAndWait(update);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public BoardData getBoardData() {
        return boardData;
    }

    /**
     * The code the responds when the user clicks on the game board
     */
    private class ChessAction implements ActionListener {

        /**
         * Handle a button click.  The method alternates between selecting a piece
         * and selecting any square.  After both are selected, the piece's
         * legalMove is called, and if the move is legal, the piece is moved.
         *
         * @param e the event that triggered the method
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton b = (JButton) e.getSource();
            // first find which button (board square) was clicked.
            for (int row = 0; row < squares.length; row++) {
                for (int col = 0; col < squares[row].length; col++) {
                    if (squares[row][col] == b) {
                        if (!INSTANCE.getBoardData().hasSelectedPiece()) {
                            if (INSTANCE.hasPiece(row, col)) {
                                if (INSTANCE.getGameRules().legalPieceToPlay(INSTANCE.getPiece(row, col), row, col)) {
                                    INSTANCE.getBoardData().selectPiece(row, col);
                                }
                            }
                        } else {
                            if (INSTANCE.getGameRules().makeMove(INSTANCE.getBoardData().getSelectedPiece(), row, col)) {
                                INSTANCE.getBoardData().unselectPiece();
                            } else {
                                if (INSTANCE.getGameRules().canChangeSelection(INSTANCE.getBoardData().getSelectedPiece())) {
                                    INSTANCE.getBoardData().unselectPiece();
                                }
                            }
                        }
                    }
                }
            }
            INSTANCE.updateBoard();
        }
    }
}
