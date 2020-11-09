package chessgame;

import java.io.Serializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

/**
 * This class creates the chess board and initialize the chess pieces on to the
 * board.
 * 
 * @author Ki Sung Chung
 * @version 1.0
 */
public class Board extends GridPane implements Serializable {
    /** Default Serial ID. */
    private static final long serialVersionUID = 1L;
    /** Holds each square on the chess board. */
    private Square[][] squares;
    /** Holds chess pieces. */
    private Square[][] pieces;
    /** Represents the square that is targeted. */
    private Square target;
    /** Represents the square that was originally selected. */
    private Square original;
    /** Represents the size of the rows and columns on the chess board. */
    private final int size = 8;
    /** Represents the size of the square width and height. */
    private final int squareSize = 70;
    /** Represents Player 1. */
    private Player p1 = new Player("p1");
    /** Represents Player 2. */
    private Player p2 = new Player("p2");
    /** Represents the current player. */
    private Player currentPlayer;
    
    /**
     * Constructs the chess board.
     */
    public Board() {
        squares = new Square[size][size];
        pieces = new Square[size][size];
        target = null;
        original = null;
        currentPlayer = p1;
        
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                squares[row][col] = new Square(row, col);
                pieces[row][col] = new Square(row, col);

                // Adds each square to the board to create chess board
                this.add(squares[row][col], col, row);
                // Adds the pieces on the board
                this.add(pieces[row][col], col, row);

                // Event Handler added to pieces
                this.pieces[row][col]
                        .setOnMouseClicked(this::processMouseClick);
            }
        }
        // Sets the pieces in the starting position
        this.initStartPosition();
    }

    /**
     * Handles event when the mouse is clicked. First mouse click selects the 
     * piece and the second mouse click moves the piece to the clicked location.
     * 
     * @param e invokes the method
     */
    public void processMouseClick(MouseEvent e) {
        target = (Square) e.getSource();
        Piece piece1 = target.getPiece();
        
        if (original != null) {
            Piece piece2 = original.getPiece();
            
            if (piece2.getOwner() == this.getCurrentPlayer() 
                    && piece2.isValidMove(original, target) 
                    && piece2.isFree(original, target, pieces)) {
                if (piece1 == null) {
                    target.setPiece(piece2);
                    original.removePiece();
                } else {
                    target.removePiece();
                    target.setPiece(piece2);
                    original.removePiece();
                }
                
                this.switchPlayer();
                original = null;
            } else {
                original = null;
            }
        } else {
            if (piece1 != null) {
                original = target;
            }
        }
    }

    /**
     * Initializes chess pieces in the starting position.
     */
    private void initStartPosition() {
        final int col0 = 0;
        final int col1 = 1;
        final int col2 = 2;
        final int col3 = 3;
        final int col4 = 4;
        final int col5 = 5;
        final int col6 = 6;
        final int col7 = 7;
        final int row6 = 6;
        final int row7 = 7;
        
        // Pieces for player 1
        this.pieces[0][col0].setPiece(new Rook(p1));
        this.pieces[0][col1].setPiece(new Bishop(p1));
        this.pieces[0][col2].setPiece(new Knight(p1));
        this.pieces[0][col3].setPiece(new King(p1));
        this.pieces[0][col4].setPiece(new Queen(p1));
        this.pieces[0][col5].setPiece(new Knight(p1));
        this.pieces[0][col6].setPiece(new Bishop(p1));
        this.pieces[0][col7].setPiece(new Rook(p1));
        for (int i = 0; i < this.pieces[0].length; i++) {
            this.pieces[1][i].setPiece(new Pawn(p1));
        }

        // Pieces for player 2
        this.pieces[row7][col0].setPiece(new Rook(p2));
        this.pieces[row7][col1].setPiece(new Bishop(p2));
        this.pieces[row7][col2].setPiece(new Knight(p2));
        this.pieces[row7][col3].setPiece(new King(p2));
        this.pieces[row7][col4].setPiece(new Queen(p2));
        this.pieces[row7][col5].setPiece(new Knight(p2));
        this.pieces[row7][col6].setPiece(new Bishop(p2));
        this.pieces[row7][col7].setPiece(new Rook(p2));
        for (int i = 0; i < this.pieces[0].length; i++) {
            this.pieces[row6][i].setPiece(new Pawn(p2));
        }
    }
    
    /**
     * Returns the current player.
     * 
     * @return currentPlayer as Player
     */
    public Player getCurrentPlayer() {
        return this.currentPlayer;
    }
    
    /**
     * Switches current player.
     */
    public void switchPlayer() {
        if (this.currentPlayer == this.p1) {
            this.currentPlayer = this.p2;
        } else {
            this.currentPlayer = this.p1;
        }
    }
    
    /**
     * Re-creates the board and sets pieces when opening saved chess game.
     */
    public void openSavedGame() {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                // Re-creates the board squares
                squares[row][col].setWidth(squareSize);
                squares[row][col].setHeight(squareSize);
                if ((row + col) % 2 == 0) {
                    squares[row][col].setFill(Color.LIGHTBLUE);
                } else {
                    squares[row][col].setFill(Color.LIGHTYELLOW);
                }
                
                // Re-creates and sets the chess pieces on the board
                pieces[row][col].setWidth(squareSize);
                pieces[row][col].setHeight(squareSize);
                pieces[row][col].setOnMouseClicked(this::processMouseClick);
                if (pieces[row][col].getPiece() != null) {
                    pieces[row][col].setPiece(pieces[row][col].getPiece());
                } else {
                    pieces[row][col].removePiece();
                }
                
                // Add board squares and chess pieces
                this.add(squares[row][col], col, row);
                this.add(pieces[row][col], col, row);
            }
        }
    }
}
