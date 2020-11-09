package chessgame;

import java.io.Serializable;

/**
 * This class represents the chess game players.
 * 
 * @author Ki Sung Chung
 * @version 1.0
 */
public class Player implements Serializable {
    /** Default Serial ID. */
    private static final long serialVersionUID = 1L;
    /** Represents the player. */
    private String player;
    
    /**
     * Creates a player object.
     * 
     * @param player as a String
     */
    public Player(String player) {
        this.player = player;
    }
    
    /**
     * Gets the player type.
     * 
     * @return player as a String
     */
    public String getPlayer() {
        return this.player;
    }
}
