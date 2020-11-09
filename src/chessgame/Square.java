package chessgame;

import java.io.Serializable;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

/**
 * This class creates each square inside the chess board.
 * 
 * @author Ki Sung Chung
 * @version 1.0
 */
public class Square extends Rectangle implements Serializable {
    /** Default Serial ID. */
    private static final long serialVersionUID = 1L;
    /** Represents the rows of the chess board. */
    private int row;
    /** Represents the columns of the chess board. */
    private int col;
    /** Represents the chess piece. */
    private Piece piece;
    /** Represents the size of the square width and height. */
    private final int size = 70;
    
    /**
     * Constructs a square object.
     * 
     * @param row as an integer
     * @param col as an integer
     */
    public Square(int row, int col) {
        this.setHeight(size);
        this.setWidth(size);
        this.row = row;
        this.col = col;
        this.piece = null;
        
        // sets the color of the squares depending on the position on the board
        if ((row + col) % 2 == 0) {
            this.setFill(Color.LIGHTBLUE);
        } else {
            this.setFill(Color.LIGHTYELLOW);
        }
    }

    /**
     * Sets the piece on the square.
     * 
     * @param piece as a Piece object
     */
    public void setPiece(Piece piece) {
        Image image;
        String location = "file:piece/";
        String file = piece.getPlayerType() + "/" + piece.getName() + ".png";
        image = new Image(location + file);
        this.piece = piece;        
        if (this.piece != null) {
            this.setFill(new ImagePattern(image));
        }
    }
    
    /**
     * Gets the piece from the square.
     * 
     * @return piece as Piece object
     */
    public Piece getPiece() {
        return this.piece;
    }
    
    /**
     * Gets the row number.
     * 
     * @return row as an integer
     */
    public int getRow() {
        return this.row;
    }
    
    /**
     * Gets the column number.
     * 
     * @return col as an integer
     */
    public int getCol() {
        return this.col;
    }
    
    /**
     * Removes the piece from the square.
     */
    public void removePiece() {
        if ((row + col) % 2 == 0) {
            this.setFill(Color.LIGHTBLUE);
        } else {
            this.setFill(Color.LIGHTYELLOW);
        }
        this.piece = null;
    }
    
    /**
     * Checks if a piece is set on the square.
     * 
     * @return true if the square has a piece
     */
    public boolean hasPiece() {
        if (this.piece != null) {
            return true;
        }
        return false;
    }
}
