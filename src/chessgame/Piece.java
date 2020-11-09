package chessgame;

import java.io.Serializable;

/**
 * This class contains information of the chess pieces.
 * 
 * @author Ki Sung Chung
 * @version 1.0
 */
public abstract class Piece implements Serializable {
    /** Default Serial ID. */
    private static final long serialVersionUID = 1L;
    /** Represents the player. */
    private Player player;
    
    /**
     * Creates a Piece object.
     * 
     * @param player as a String
     */
    public Piece(Player player) {
        this.player = player;
    }
    
    /**
     * Returns the owner of each piece.
     * 
     * @return player as a Player object
     */
    public Player getOwner() {
        return this.player;
    }
    
    /**
     * Gets the Player type.
     * 
     * @return player as a String
     */
    public String getPlayerType() {
        return this.player.getPlayer();
    }
    
    /**
     * Gets the name of the piece.
     * 
     * @return piece name as a String
     */
    public abstract String getName();
    
    /**
     * Checks if the move is valid.
     * 
     * @param original as a Square
     * @param target as a Square
     * @return true if the move is valid
     */
    public abstract boolean isValidMove(Square original, Square target);
    
    /**
     * Checks if the path is free of obstacles.
     * 
     * @param original as a Square
     * @param target as a Square
     * @param pieces as a Square 2D array
     * @return true if the path is free of obstacles
     */
    public abstract boolean isFree(Square original, Square target,
            Square[][] pieces);
}
